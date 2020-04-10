const API_URL = `${CONST_HOST_URL}/api-server`;
var currentRequestForm = "";
var ITEMS_ON_PAGE = 10;
$(document).ready(function () {

  const userToTableRowHTML = (user) => {
    return `<td class="center">
      <label class="pos-rel">
        <input class="checkbox-delete c-id${user.id}" type="checkbox" class="ace">
            
        </label>
    </td>
      <td>
        <a href="#">${user.username}</a>
      </td>
      <td>${user.fullname}</td>
      <td>${user.phone}</td>
      <td>${user.role == 0 ? 'Nhân viên' : 'Quản trị viên'}</td>
      <td>${user.status == 0 ? 'Ngưng hoạt động' : 'Hoạt động'}</td>
      <td>
        <div class="hidden-sm hidden-xs action-buttons">
            ${user.role==0 ?
              `<button id='btn_update_code${user.id}' data-toggle="modal" data-target="#myModal"
                class="btn_update ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
                  <i class="ace-icon fa fa-pencil bigger-130"></i></span></button>
              `: ``}
        </div>
    </td >`
  }

  const loadData = (url, callback) => {
    var data = "";

    fetch(url)
      .then(res => res.json())
      .then(res => {
        res.map(user => {
          data += `<tr id="checkbox-row-${user.id}">
          ${userToTableRowHTML(user)}
          </tr>`
        })
        $('#data-user-list')[0].innerHTML = data;
        callback();
      }
      )
  }


  const userPagination = (numItems, itemsOnPage, currentPage, callback) => {

    $('#pagination-container').pagination({
      items: numItems,
      itemsOnPage: itemsOnPage,
      egdes: 2,
      currentPage: currentPage,
      prevText: "Previous",
      nextText: "Next",
      onPageClick: function (pageNumber) {
        loadData(`${API_URL}/staff/list?${currentRequestForm}&page=${pageNumber}&size=${ITEMS_ON_PAGE}`, callback);
      }
    });
  }

  const fetchFirstPagination = (url, callback) => {
    fetch(url).then(res => res.json()).then(count => {
      userPagination(count, ITEMS_ON_PAGE, 1, callback);
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
    currentRequestForm = $('#user_form').serialize();
    loadData(`${API_URL}/staff/list?${currentRequestForm}`, () => {
      fetchFirstPagination(`${API_URL}/staff/count?${currentRequestForm}`, hideLoading);
    })
  }

  fetchData();

  $('#btn_search').click(() => {
    currentRequestForm = $('#user_form').serialize();
    fetchData();
  })


  $("#dynamic-table").on("click", "button[id^='btn_assign']", function () {
    $.LoadingOverlay("show");
    var tbody =
      document.getElementById("tBody");
    let id = $(this).attr('id');
    let userId = id.substr(id.indexOf("_code") + 5);
    $('#assign_userId').val(userId);
    var data = "";
    fetch(`${API_URL}/staff/assignment?id=${userId}`)
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
    
    $('.modal-title')[0].innerHTML = "Cập nhật người dùng";
    $('#submit_save')[0].innerHTML = 'Cập nhật';
    $('select[name="status"]').parent().show();
    $('input[name="username"]').parent().hide();

    let id = $(this).attr('id');
    let userId = id.substr(id.indexOf("_code") + 5);
    $('#modal_userId').val(userId);
    fetch(`${API_URL}/staff?id=${userId}`)
      .then(res => res.json())
      .then(res => {
        $('#userForm')[0].reset();
        binding(res);
        $.LoadingOverlay("hide");
      })
      .catch(e => {
        console.log(e);
        $.LoadingOverlay("hide");
      })
  })


  $("#btn_add_user").click(() => {
    $('.modal-title')[0].innerHTML = "Thêm mới người dùng";
    $('#submit_save')[0].innerHTML = 'Thêm mới';
    $('#modal_userId').val('');
    $('#userForm')[0].reset();
    $('select[name="status"]').parent().hide();
    $('input[name="username"]').parent().show();
  })


  function binding(obj) {
    const map = new Map(Object.entries(obj));
    var inputList = $("#userForm .z-field");
    for (let i = 0; i < inputList.length; i++) {
      const data = map.get(inputList[i]['name']);
      if (data != undefined && data != null) {
        inputList[i]['value'] = data;
      }
    }
  }


  $("#delete-selected-user").click(() => {
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
            fetch(`${API_URL}/staff`, {
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
              .catch(e=>{
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
    let userId = id.substr(id.indexOf("_code") + 5);
    let ids = [parseInt(userId)];
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
            fetch(`${API_URL}/staff`, {
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
              .catch(e=>{
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
    var userId = [];
    $.each(x, function (i, field) {
      if ($(field).find('input[type=checkbox]').is(':checked')) {
        let id = $(field).find("input[id^='assignstaff_code']").attr('id');
        let getStaffId = id.substr(id.indexOf("_code") + 5);
        staffId.push(parseInt(getStaffId));
      };
    });
    userId = (parseInt($('#assign_userId').attr('value')));
    let data = { staffId, userId };

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
              .catch(e=>{
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
    var x = $("#userForm").serializeArray();
    var type = [];
    var data = {};
    $.each(x, function (i, field) {
      data[field.name] = field.value;
      if (field.name == 'userType') {
        type.push(field.value);
      }
    });
    let method = 'POST';
    if ((!!$('#modal_userId')[0].value)) {
      method = 'PUT';
    }

    data['userType'] = type;
    
    $.confirm({
      title: false,
      content: 'Bạn có muốn thực hiện các thay đổi!',
      buttons: {
        confirm: {
          text: 'Đồng ý',
          btnClass: 'btn-danger',
          action: () => {
            $.LoadingOverlay("show");
            fetch(`${API_URL}/staff`, {
              method: method,
              body: JSON.stringify(data), // data can be `string` or {object}!
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(res => res.json())
              .then(res => {
                $('#userForm')[0].reset();
                $('#myModal').modal('hide');
                if (method == 'PUT') {
                  $.LoadingOverlay("hide");
                  $(`#checkbox-row-${res.id}`).html(userToTableRowHTML(res));
                  $.alert('Thực hiện thành công');
                } else {
                  const pageString = $('#pagination-container .active > span')[0].innerHTML;
                  const pageNumber = parseInt(pageString);
                  loadData(`${API_URL}/staff/list?${currentRequestForm}&page=${pageNumber}&size=${ITEMS_ON_PAGE}`, () => {
                    hideLoading();
                    $.alert('Thực hiện thành công');
                  });
                }

              })
              .catch(e=>{
                $.LoadingOverlay("hide");
                $.alert('Thất bại');
              })
          },
        },
        cancel: {
          text: 'Hủy'
        }
      }
    });

  });
})

