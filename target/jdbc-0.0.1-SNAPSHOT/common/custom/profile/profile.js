const API_URL = `${CONST_HOST_URL}/api-server`;

$('#file-preview').change(() => {
    previewImage($('#file-preview')[0])
})

function previewImage(input) {
    return new Promise((resolve, reject) => {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.readAsDataURL(input.files[0]);

            reader.onload = function (e) {
                $('#image-preview').attr('src', e.target.result);
                resolve(e.target.result);
            };
            reader.onerror = function (e) {
                reject('reject');
            }
        } else reject('reject');
    })

}

function binding(obj) {
    const map = new Map(Object.entries(obj));
    var inputList = $(".z-field");
    for (let i = 0; i < inputList.length; i++) {
        const data = map.get(inputList[i]['name']);
        if (data != undefined && data != null) {
            inputList[i]['value'] = data;
        }
    }
    if (!!map.get('avatar') && map.get('avatar') != 'null') {
        $('#image-sidebar').css('background-image', 'url(' + map.get('avatar') + ')');
        $('#image-preview').attr('src',map.get('avatar'));
        sessionStorage.setItem('avatar', map.get('avatar'));
    }
    if (!!map.get('fullname') && map.get('fullname') != 'null') {
        $('#fullname-sidebar')[0].innerHTML = map.get('fullname');
        sessionStorage.setItem('fullname', map.get('fullname'));
    }
}

fetchData();

function fetchData() {
    $.LoadingOverlay("show");
    let userId = $('#form-profile input[name="id"]').val();
    fetch(`${API_URL}/staff?id=${userId}`)
        .then(res => res.json())
        .then(res => {
            binding(res);
            $.LoadingOverlay("hide");
        })
        .catch(e => {
            $.LoadingOverlay("hide");
        })
}



$("#btn-submit").click(async function () {
    let base64_image = "";
    try {
        base64_image = await previewImage($('#file-preview')[0]);
    } catch (error) {
        console.log(error);
    }

    var x = $("#form-profile").serializeArray();
    var data = {};
    data['avatar'] = base64_image;
    $.each(x, function (i, field) {
        data[field.name] = field.value;
    });
    let method = 'PUT';


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
                            binding(res);
                            $.LoadingOverlay("hide");
                            $.alert('Thực hiện thành công');
                        })
                        .catch(e => {
                            $.LoadingOverlay("hide");
                            $.alert('Thực hiện thất bại');
                        })
                },
            },
            cancel: {
                text: 'Hủy'
            }
        }
    });

});
