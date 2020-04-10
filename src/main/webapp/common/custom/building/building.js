const API_URL = `${CONST_HOST_URL}/api-server`;
var currentRequestForm = "";
var ITEMS_ON_PAGE = 10;
$(document).ready(function () {

  const buildingToTableRowHTML = (building) => {
    return `<td class="center">
      <label class="pos-rel">
        <input class="checkbox-delete c-id${building.id}" type="checkbox" class="ace">
            
        </label>
    </td>
      <td>
        <a href="#">${building.name}</a>
      </td>
      <td>${building.address}</td>
      <td>${building.managerName}</td>
      <td>${building.managerPhone}</td>
      <td>${building.buildingArea}</td>
      <td>${building.rentCost}</td>
      <td>${building.buildingTypeInString}</td>
      <td>${building.rentArea}</td>
      <td>
        <div class="hidden-sm hidden-xs action-buttons">

          <button id='btn_assign_code${building.id}' data-toggle="modal"
            data-target="#modalStaff"
            class="btn_assign ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
              <i class="ace-icon fa fa-tags bigger-130"></i></span></button>

            <button id='btn_update_code${building.id}' data-toggle="modal" data-target="#myModal"
          class="btn_update ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
            <i class="ace-icon fa fa-pencil bigger-130"></i></span></button>

        <button id="btn_delete_code${building.id}"
          class="btn_delete ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
            <i class="ace-icon fa fa-trash-o bigger-130"></i></span></button>

        </div>

    </td >`
  }

  const loadData = (url, callback) => {
    var data = "";

    fetch(url)
      .then(res => res.json())
      .then(res => {
        res.map(building => {
          data += `<tr id="checkbox-row-${building.id}">
          ${buildingToTableRowHTML(building)}
          </tr>`
        })
        $('#data-building-list')[0].innerHTML = data;
        callback();
      }
      )
  }


  const buildingPagination = (numItems, itemsOnPage, currentPage, callback) => {

    $('#pagination-container').pagination({
      items: numItems,
      itemsOnPage: itemsOnPage,
      egdes: 2,
      currentPage: currentPage,
      prevText: "Previous",
      nextText: "Next",
      onPageClick: function (pageNumber) {
        $.LoadingOverlay("show");
        loadData(`${API_URL}/building?request=list&${currentRequestForm}&page=${pageNumber}&size=${ITEMS_ON_PAGE}`, callback);
      }
    });
  }

  const fetchFirstPagination = (url, callback) => {
    fetch(url).then(res => res.json()).then(count => {
      buildingPagination(count, ITEMS_ON_PAGE, 1, callback);
      callback();
    })
      .catch(e => {
        console.log('err' + e);
      })
  }

  const hideLoading = () => {
    $.LoadingOverlay("hide");
  }


  const fetchData = async () => {
    $.LoadingOverlay("show");
    currentRequestForm = $('#building_form').serialize();
    loadData(`${API_URL}/building?request=list&${currentRequestForm}&page=1&size=${ITEMS_ON_PAGE}`, () => {
      fetchFirstPagination(`${API_URL}/building?request=count&${currentRequestForm}`, hideLoading);
    })
  }

  fetchData();

  $('#btn_search').click(() => {
    currentRequestForm = $('#building_form').serialize();
    fetchData();
  })


  $("#dynamic-table").on("click", "button[id^='btn_assign']", function () {
    $.LoadingOverlay("show");
    var tbody =
      document.getElementById("tBody");
    let id = $(this).attr('id');
    let buildingId = id.substr(id.indexOf("_code") + 5);
    $('#assign_buildingId').val(buildingId);
    var data = "";
    fetch(`${API_URL}/staff/assignment?id=${buildingId}`)
      .then(res => res.json())
      .then(res => {
        res.map(e => {
          data += '<tr> <td><input type="hidden" id="assignstaff_code' + e[0] + '"> <input type="checkbox"' + e[2] + ' ></td> <td>' + (e[1] == null ? '' : e[1]) + '</td> </tr>';
        })
        tbody.innerHTML = data;
        $.LoadingOverlay("hide");
      }
      )
      .catch(e => {
        $.LoadingOverlay("hide");
      })

  });


  $("#dynamic-table").on("click", "button[id^='btn_update']", function () {
    $.LoadingOverlay("show");
    $('#submit_save')[0].innerHTML = 'Cập nhật';
    $('.modal-title')[0].innerHTML = "Cập nhật tòa nhà";

    let id = $(this).attr('id');
    let buildingId = id.substr(id.indexOf("_code") + 5);
    $('#modal_buildingId').val(buildingId);
    fetch(`${API_URL}/building?request=find-by-id&id=${buildingId}`)
      .then(res => res.json())
      .then(res => {
        $('#buildingForm')[0].reset();
        binding(res);
        $.LoadingOverlay("hide");
      })
      .catch(e => {
        $.LoadingOverlay("hide");
      })
  })


  $("#btn_add_building").click(() => {

    $('.modal-title')[0].innerHTML = "Cập nhật tòa nhà";
    $('#submit_save')[0].innerHTML = 'Thêm mới';
    $('#modal_buildingId').val('');
    $('#buildingForm')[0].reset();
  })


  function binding(obj) {
    const map = new Map(Object.entries(obj));
    var inputList = $("#buildingForm .z-field");
    for (let i = 0; i < inputList.length; i++) {
      const data = map.get(inputList[i]['name']);
      if (!!data) {
        if (inputList[i]['name'] == 'buildingType') {
          if (obj.buildingType.includes(inputList[i]['value'])) {
            inputList[i]['checked'] = true;
          }
        }
        else {
          inputList[i]['value'] = data;
        }

      }
    }
  }


  $("#delete-selected-building").click(() => {
    var rows = $("input[class^='checkbox-delete']:checked");
    let ids = [];
    for (let i = 0; i < rows.length; i++) {
      let className = rows[i].className;
      let id = className.substr(className.indexOf("c-id") + 4);
      ids.push(parseInt(id));
    }
    let data = { 'ids': ids }
    $.confirm({
      title: false,
      content: 'Bạn có muốn thực hiện thao tác xóa!',
      buttons: {
        confirm: {
          text: 'Đồng ý',
          btnClass: 'btn-danger',
          action: () => {
            $.LoadingOverlay("show");
            fetch(`${API_URL}/building`, {
              method: 'DELETE',
              body: JSON.stringify(data),
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(res => res.json())
              .then(res => {
                if (res == true) {
                  $.LoadingOverlay("hide");
                  $("#dynamic-table input[class^='checkbox-delete']:checked").closest('tr').remove();
                  $.alert('Đã xóa thành công');
                }else{
                  $.alert('Thao tác thất bại');
                }
              })
              .catch(e => {
                $.LoadingOverlay("hide");
                $.alert('Thất bại');
              })
          }

        },
        cancel: {
          text: 'Hủy'
        }
      }
    });


  })
  $("#dynamic-table").on("click", "button[id^='btn_delete']", function () {

    let id = $(this).attr('id');
    let buildingId = id.substr(id.indexOf("_code") + 5);
    let ids = [parseInt(buildingId)];
    let data = { 'ids': ids }
    $.confirm({
      title: false,
      content: 'Bạn có muốn thực hiện thao tác xóa!',
      buttons: {
        confirm: {
          text: 'Đồng ý',
          btnClass: 'btn-danger',
          action: () => {
            $.LoadingOverlay("show");
            fetch(`${API_URL}/building`, {
              method: 'DELETE',
              body: JSON.stringify(data),
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(res => res.json())
              .then(res => {
                $.LoadingOverlay("hide");
                if (res == true) {
                  $(this).closest("tr").remove();
                  $.alert('Đã xóa thành công');
                }else{
                  $.alert('Thao tác thất bại');
                }
              })
              .catch(e => {
                $.LoadingOverlay("hide");
                $.alert('Thất bại');
              })
          }
        },
        cancel: {
          text: 'Hủy'
        }
      }
    });
  });



  $("#saveAssignmentStaff").click(() => {
    var x = $("#tBody")[0].rows;
    var staffId = [];
    var buildingId = [];
    $.each(x, function (i, field) {
      if ($(field).find('input[type=checkbox]').is(':checked')) {
        let id = $(field).find("input[id^='assignstaff_code']").attr('id');
        let getStaffId = id.substr(id.indexOf("_code") + 5);
        staffId.push(parseInt(getStaffId));
      };
    });
    buildingId = (parseInt($('#assign_buildingId').attr('value')));
    let data = { staffId, buildingId };

    $.confirm({
      title: false,
      content: 'Bạn có muốn thực hiện các thay đổi!',
      buttons: {
        confirm: {
          text: 'Đồng ý',
          btnClass: 'btn-danger',
          action: () => {
            $.LoadingOverlay("show");
            fetch(`${API_URL}/staff/assignment`, {
              method: 'POST', // or 'PUT'
              body: JSON.stringify(data), // data can be `string` or {object}!
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(res => res.json())
              .then(res => {
                $.LoadingOverlay("hide");
                $.alert('Thực hiện thành công');
              })
              .catch(e => {
                $.LoadingOverlay("hide");
                $.alert('Thất bại');
              })
          }
        },
        cancel: {
          text: 'Hủy'
        }
      }
    });
  })

  $("#submit_save").click(function () {
    var x = $("#buildingForm").serializeArray();
    var type = [];
    var data = {};
    $.each(x, function (i, field) {
      data[field.name] = field.value;
      if (field.name == 'buildingType') {
        type.push(field.value);
      }
    });
    let method = 'POST';
    if ((!!$('#modal_buildingId')[0].value)) {
      method = 'PUT';
    }

    data['buildingType'] = type;

    $.confirm({
      title: false,
      content: 'Bạn có muốn thực hiện các thay đổi!',
      buttons: {
        confirm: {
          text: 'Đồng ý',
          btnClass: 'btn-danger',
          action: () => {
            $.LoadingOverlay("show");
            fetch(`${API_URL}/building`, {
              method: method,
              body: JSON.stringify(data), // data can be `string` or {object}!
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(res => res.json())
              .then(res => {
                $('#buildingForm')[0].reset();
                $('#myModal').modal('hide');
                if (method == 'PUT') {
                  $.LoadingOverlay("hide");
                  $(`#checkbox-row-${res.id}`).html(buildingToTableRowHTML(res));
                  $.alert('Thực hiện thành công');
                } else {
                  const pageString = $('#pagination-container .active > span')[0].innerHTML;
                  const pageNumber = parseInt(pageString);
                  loadData(`${API_URL}/building?request=list&${currentRequestForm}&page=${pageNumber}&size=${ITEMS_ON_PAGE}`, () => {
                    hideLoading();
                    $.alert('Thực hiện thành công');
                  })
                }
              })
              .catch(e => {
                $.LoadingOverlay("hide");
                $.alert('Thất bại');
              });
          },
        },
        cancel: {
          text: 'Hủy'
        }
      }
    });

  });
})

