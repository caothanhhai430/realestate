<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/web-components/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="../common/template/login/images/icons/favicon.ico" />
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/vendor/bootstrap/css/bootstrap.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/vendor/animate/animate.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/vendor/css-hamburgers/hamburgers.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/vendor/animsition/css/animsition.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/vendor/select2/select2.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/vendor/daterangepicker/daterangepicker.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" href="../common/template/login/css/util.css">
	<link rel="stylesheet" href="../common/template/login/css/main.css">
	<!--===============================================================================================-->
</head>

<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
				<form class="login100-form validate-form" method="POST" action="login">
					<span class="login100-form-title p-b-33">
						Account Login
					</span>
					<c:if test="${error!=null}">
						<span style="color: red;font-size: 14px;">Username or password not correct</span>
					</c:if>

					<div class="wrap-input100 validate-input" data-validate="Valid Username is required">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="container-login100-form-btn m-t-20">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>

					<div class="text-center p-t-45 p-b-4">
						<span class="txt1">
							Forgot
						</span>

						<a href="#" class="txt2 hov1">
							Username / Password?
						</a>
					</div>

					<div class="text-center">
						<span class="txt1">
							Create an account?
						</span>

						<a href="#" class="txt2 hov1">
							Sign up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>



	<!--===============================================================================================-->
	<script src="../common/template/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="../common/template/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="../common/template/login/vendor/bootstrap/js/popper.js"></script>
	<script src="../common/template/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="../common/template/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="../common/template/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="../common/template/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="../common/template/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="../common/template/login/js/main.js"></script>

</body>

</html>