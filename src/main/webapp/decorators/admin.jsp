<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/web-components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">

<head>
	<%@ include file="/common/web-components/head.jsp" %>
	<dec:head />
</head>

<body>
	<%@ include file="/common/web-components/header.jsp" %>

	<div class="wrapper d-flex align-items-stretch">
		<%@ include file="/common/web-components/sidebar.jsp" %>

		<div style="max-width: 100%;min-width: 80%;">
			<div class="breadcrumbs" id="breadcrumbs">
				<button type="button" id="sb-collapse" class="btn btn-primary">
					<i id="collapse-arrow" class="fa fa-arrow-left"></i>
				</button>
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">Quản trị</a>
					</li>
					<li id="manage-title" class="active">Quản lý</li>
				</ul><!-- /.breadcrumb -->
			</div>

			<dec:body />

		</div>
	</div>
	<script>

		if (!!sessionStorage.getItem('avatar') && sessionStorage.getItem('avatar') != 'null') $('#image-sidebar').css('background-image', 'url(' + sessionStorage.getItem('avatar')) + ')';
		if (!!sessionStorage.getItem('fullname') && sessionStorage.getItem('fullname') != 'null') $('#fullname-sidebar')[0].innerHTML = sessionStorage.getItem('fullname');

		$('#sb-collapse').click(() => {
			$('#sidebar').toggleClass('active');
			const sb_class = $('#collapse-arrow').attr('class');
			if (sb_class.includes('right')) $('#collapse-arrow').attr('class', 'fa fa-arrow-left');
			else $('#collapse-arrow').attr('class', 'fa fa-arrow-right');
		});

		const current_url = window.location.href;

		if (current_url.includes('building')) {
			$('#act-building').attr('class', 'active');
			$('#manage-title')[0].innerHTML = "Quản lý tòa nhà";
		}
		else if (current_url.includes('customer')) {
			$('#act-customer').attr('class', 'active');
			$('#manage-title')[0].innerHTML = "Quản lý khách hàng";
		}
		else if (current_url.includes('user')) {
			$('#act-user').attr('class', 'active');
			$('#manage-title')[0].innerHTML = "Quản lý người dùng";
		}
		else if (current_url.includes('profile')) {
			$('#act-profile').attr('class', 'active');
			$('#manage-title')[0].innerHTML = "Quản lý tài khoản";
		}

		$('#act-logout').click(() => {
			$.confirm({
				title: false,
				content: 'Bạn có muốn đăng xuất?',
				buttons: {
					confirm: {
						text: 'Đồng ý',
						btnClass: 'btn-danger',
						action: () => {
							sessionStorage.clear();
							window.location.href = `${CONST_HOST_URL}/logout`;
						},
					},
					cancel: {
						text: 'Hủy'
					}
				}
			});
		})

	</script>

</body>

</html>