const API_URL = `${CONST_HOST_URL}/api-server`;
var currentRequestForm = "";
var ITEMS_ON_PAGE = 10;
var currentCareLoadMoreIndex = 1;
var currentTourLoadMoreIndex = 1;

$(document).ready(function () {



  function normalizeData(data){
    return data==null ? '' : data;
  }

  const customerToTableRowHTML = (customer) => {
    return `<td class="center">
        <label class="pos-rel">
            <input class="checkbox-delete c-id${customer.id}" type="checkbox" class="ace">
            
        </label>
    </td>
    <td>
        <a href="#">${normalizeData(customer.name)}</a>
    </td>
    <td>${normalizeData(customer.phone)}</td>
    <td>${normalizeData(customer.email)}</td>
    <td>${normalizeData(customer.demand)}</td>
    <td>${normalizeData(customer.createdBy)}</td>
    <td>${timeConverter(customer.createdDate)}</td>
    <td>Đang xử lý</td>
    <td>
    <div class="hidden-sm hidden-xs action-buttons">

      <button id='btn_assign_code${customer.id}' data-toggle="modal"
      data-target="#modalStaff"
      class="btn_assign ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
        <i class="ace-icon fa fa-tags bigger-130"></i></span></button>
      
      <button id='btn_update_code${customer.id}' data-toggle="modal" data-target="#myModal"
    class="btn_update ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
      <i class="ace-icon fa fa-pencil bigger-130"></i></span></button>

      <button id='btn_care_code${customer.id}' data-toggle="modal" data-target="#transactionModal"
    class="btn_update ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
      <i class="ace-icon fa fa-users bigger-130"></i></span></button>


      <button id="btn_delete_code${customer.id}"
    class="btn_delete ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
      <i class="ace-icon fa fa-trash-o bigger-130"></i></span></button>
      
  </div>


    </td>`
  }


  function timeConverter(UNIX_timestamp) {
    if (!!!UNIX_timestamp) return '';
    var a = new Date(UNIX_timestamp);
    // var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
    var year = a.getFullYear();
    var month = a.getMonth() + 1;
    var date = a.getDate();
    var hour = a.getHours();
    var min = a.getMinutes();
    var sec = a.getSeconds();
    var time = (hour < 10 ? '0' : '') + hour + ':' + (min < 10 ? '0' : '') + min + "       " +
      (date < 10 ? '0' : '') + date + '-' + (month < 10 ? '0' : '') + month + '-' + year;
    return time;
  }


  const transactionToTableRowHTML = (obj) => {
    return `<tr>
      <td>${timeConverter(obj.createdDate)}</td>
      <td style="max-width: 300px;">${obj.note}</td>
      <td>${obj.createdBy}</td>
      </tr>`
  }

  const loadData = (url, callback) => {
    var data = "";
    fetch(url)
      .then(res => res.json())
      .then(res => {
        res.map(customer => {
          data += `<tr id="checkbox-row-${customer.id}">
          ${customerToTableRowHTML(customer)}
          </tr>`
        })
        $('#data-customer-list')[0].innerHTML = data;
        callback();
      }
      )
  }

  const customerPagination = (numItems, itemsOnPage, currentPage, callback) => {

    $('#pagination-container').pagination({
      items: numItems,
      itemsOnPage: itemsOnPage,
      egdes: 2,
      currentPage: currentPage,
      prevText: "Previous",
      nextText: "Next",
      onPageClick: function (pageNumber) {
        $.LoadingOverlay("show");
        loadData(`${API_URL}/customer/list?${currentRequestForm}&page=${pageNumber}&size=${ITEMS_ON_PAGE}`, callback);
      }
    });
  }

  const hideLoading = () => {
    $.LoadingOverlay("hide");
  }

  const fetchFirstPagination = (url, callback) => {
    fetch(url).then(res => res.json()).then(count => {
      customerPagination(count, ITEMS_ON_PAGE, 1, callback);
      $('.table-header')[0].innerHTML = `Tìm thấy ${count} kết quả`;
      callback();
    })
      .catch(e => {
        console.log('err' + e);
      })
  }



  const fetchData = async () => {
    $.LoadingOverlay("show");
    currentRequestForm = $('#customer_form').serialize();
    loadData(`${API_URL}/customer/list?${currentRequestForm}&page=1&size=${ITEMS_ON_PAGE}`, () => {
      fetchFirstPagination(`${API_URL}/customer/count?${currentRequestForm}&page=1&size=${ITEMS_ON_PAGE}`, hideLoading);
    });
  }

  fetchData();

  $('#btn_search').click(() => {
    currentRequestForm = $('#customer_form').serialize();
    fetchData();
  })


  $("#dynamic-table").on("click", "button[id^='btn_assign']", function () {
    $.LoadingOverlay("show");
    var tbody =
      document.getElementById("tBody");
    let id = $(this).attr('id');
    let customerId = id.substr(id.indexOf("_code") + 5);
    $('#assign_customerId').val(customerId);
    var data = "";
    fetch(`${API_URL}/staff/assign-customer?id=${customerId}`)
      .then(res => res.json())
      .then(res => {
        res.map(e => {
          data += `<tr> <td><input type="hidden" id="assignstaff_code${e.id}"> <input type="checkbox"  ${e.checked} ></td> <td> ${normalizeData(e.fullname)} </td> </tr>`;
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
    $('.modal-title')[0].innerHTML = "Cập nhật Khách hàng";

    let id = $(this).attr('id');
    let customerId = id.substr(id.indexOf("_code") + 5);
    $('#modal_customerId').val(customerId);
    fetch(`${API_URL}/customer/find-by-id?id=${customerId}`)
      .then(res => res.json())
      .then(res => {
        $('#customerForm')[0].reset();
        binding(res);
        $.LoadingOverlay("hide");
      })
      .catch(e => {
        console.log(e);
        $.LoadingOverlay("hide");
      })
  })


  $("#btn-addCareNote").click(() => {
    addNoteAPI(0);
  })


  $("#btn-addTourNote").click(() => {
    addNoteAPI(1);
  })

  const addNoteAPI = (type) => {
    const customerId = $('#id-customer-trans').val();
    $.confirm({
      title: 'Thêm ghi chú',
      boxWidth: '600px',
      useBootstrap: false,
      content: '' +
        '<form action=""  class="formName">' +
        '<div class="form-group">' +
        '<textarea type="text" style="height:150px;" placeholder="Nhập ghi chú" class="cname form-control" required />' +
        '</div>' +
        '</form>',
      buttons: {
        formSubmit: {
          text: 'Thêm',
          btnClass: 'btn-success',
          action: function () {
            let note = this.$content.find('.cname').val();
            if (!!name) {
              $.alert('');
              return false;
            }
            $.LoadingOverlay("show");
            const data = {
              note, customerId, type
            }

            fetch(`${API_URL}/transaction`, {
              method: 'POST',
              body: JSON.stringify(data),
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(res => res.json())
              .then(res => {
                const tbody = $(`#tbody-customer${type == 0 ? 'Care' : 'Tour'}`)[0];
                tbody.innerHTML = transactionToTableRowHTML(res) + tbody.innerHTML;
                $.LoadingOverlay("hide");
                $.alert('Thao tác thành công');
              })
              .catch(e => {
                $.LoadingOverlay("hide");
                $.alert('Thất bại');
              })
          }
        },
        cancel: {
          text: 'Hủy'
        },
      },
      onContentReady: function () {
        // bind to events
        var jc = this;
        this.$content.find('form').on('submit', function (e) {
          // if the user submits the form by pressing enter in the field.
          e.preventDefault();
          jc.$$formSubmit.trigger('click'); // reference the button and click it
        });
      }
    });
  }


  $("#dynamic-table").on("click", "button[id^='btn_care']", function () {

    let id = $(this).attr('id');
    let customerId = id.substr(id.indexOf("_code") + 5);
    $('#id-customer-trans').val(customerId);
    loadTransaction();
  })
  const loadTransaction = () => {
    $.LoadingOverlay("show");
    currentCareLoadMoreIndex = 0;
    currentTourLoadMoreIndex = 0;

    $(`#customerCare > tbody`)[0].innerHTML = "";
    $(`#customerTour > tbody`)[0].innerHTML = "";
    loadMoreTransaction(0, () => {
      loadMoreTransaction(1, () => {
        $.LoadingOverlay("hide");
      });
    });
  }

  $("#btn-loadMoreCareNote").click(() => {
    $.LoadingOverlay("show");
    loadMoreTransaction(0, () => $.LoadingOverlay("hide"));
  }
  )

  $("#btn-loadMoreTourNote").click(() => {
    $.LoadingOverlay("show");
    loadMoreTransaction(1, () => $.LoadingOverlay("hide"));
  }
  )

  const loadMoreTransaction = (type, callback) => {
    const customerId = $('#id-customer-trans').val();
    const table = $(`#customer${type == 0 ? 'Care' : 'Tour'} > tbody`)[0];
    let tableData = "";
    let page = null;
    if (type == 0) {
      currentCareLoadMoreIndex += 1;
      page = currentCareLoadMoreIndex;
    }
    else if (type == 1) {
      currentTourLoadMoreIndex += 1;
      page = currentTourLoadMoreIndex;
    }
    fetch(`${API_URL}/transaction/list?customerId=${customerId}&type=${type}&page=${page}&size=${ITEMS_ON_PAGE}`)
      .then(res => res.json())
      .then(res => {
        res.map(e => {
          const row = transactionToTableRowHTML(e);
          tableData += row;
        })
        table.innerHTML += tableData;
        callback();
      })
      .catch(e => {
        console.log(e);
      })
  }


  $("#btn_add_customer").click(() => {
    $('#submit_save')[0].innerHTML = 'Thêm mới';
    $('.modal-title')[0].innerHTML = "Thêm mới Khách hàng";
    $('#modal_customerId').val('');
    $('#customerForm')[0].reset();
  })


  function binding(obj) {
    const map = new Map(Object.entries(obj));
    var inputList = $("#customerForm .z-field");
    for (let i = 0; i < inputList.length; i++) {
      const data = map.get(inputList[i]['name']);
      if (!!data) {
          inputList[i]['value'] = data;
      }
    }
  }



  $("#delete-selected-customer").click(() => {
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
            fetch(`${API_URL}/customer`, {
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
    let customerId = id.substr(id.indexOf("_code") + 5);
    let ids = [parseInt(customerId)];
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
            fetch(`${API_URL}/customer`, {
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
                }
                else{
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
    var customerId = [];
    $.each(x, function (i, field) {
      if ($(field).find('input[type=checkbox]').is(':checked')) {
        let id = $(field).find("input[id^='assignstaff_code']").attr('id');
        let getStaffId = id.substr(id.indexOf("_code") + 5);
        staffId.push(parseInt(getStaffId));
      };
    });
    customerId = (parseInt($('#assign_customerId').attr('value')));
    let data = { staffId, customerId };
    
    $.confirm({
      title: false,
      content: 'Bạn có muốn thực hiện các thay đổi!',
      buttons: {
        confirm: {
          text: 'Đồng ý',
          btnClass: 'btn-danger',
          action: () => {
            $.LoadingOverlay("show");
            fetch(`${API_URL}/staff/assign-customer`, {
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
    var x = $("#customerForm").serializeArray();
    var type = [];
    var data = {};
    $.each(x, function (i, field) {
      data[field.name] = field.value;
    });
    let method = 'POST';
    if ((!!$('#modal_customerId')[0].value)) {
      method = 'PUT';
    }
    console.log(JSON.stringify(data));
    $.confirm({
      title: false,
      content: 'Bạn có muốn thực hiện các thay đổi!',
      buttons: {
        confirm: {
          text: 'Đồng ý',
          btnClass: 'btn-danger',
          action: () => {
            $.LoadingOverlay("show");
            fetch(`${API_URL}/customer`, {
              method: method,
              body: JSON.stringify(data), // data can be `string` or {object}!
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(res => res.json())
              .then(res => {
                $('#customerForm')[0].reset();
                $('#myModal').modal('hide');
                if (method == 'PUT') {
                  $.LoadingOverlay("hide");
                  $(`#checkbox-row-${res.id}`).html(customerToTableRowHTML(res));
                  $.alert('Thực hiện thành công');
                } else {
                  const pageString = $('#pagination-container .active > span')[0].innerHTML;
                  const pageNumber = parseInt(pageString);
                  loadData(`${API_URL}/customer/list?${currentRequestForm}&page=${pageNumber}&size=${ITEMS_ON_PAGE}`, () => {
                    hideLoading();
                    $.alert('Thực hiện thành công');
                  });
                }
              })
              .catch(e => {
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





});