<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/web-components/taglib.jsp" %>

<head>
    <link rel="stylesheet" href='<c:url value="/common/custom/profile/profile.css" />' />
</head>

<body>
    <div class="container-profile">
        <div class="view-account">
            <section class="module">
                <div class="module-inner">
                    <div class="content-panel">
                        <h1 class="title">Thông tin cá nhân</h1>
                        <form id="form-profile" class="form-horizontal">
                            <fieldset class="fieldset">

                                <div class="form-group avatar" style="display:inline-block;">
                                    <figure style="display:inline-block;">
                                        <img id="image-preview" src="/common/template/sidebar/images/logo.jpg" alt="">
                                    </figure>
                                    <span style="display: inline-block;" class="pull-right">
                                        <input id="file-preview" type="file">
                                    </span>

                                </div>
                                <input class="form-control z-field" type="hidden" name="id" value=<sec:authentication
                                    property="principal.id" /> placeholder="" />
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label for="form-field-8">Họ và tên</label>

                                        <input class="form-control z-field" name="fullname" placeholder="" />
                                    </div>
                                    <sec:authorize access="hasAuthority('ADMIN')">

                                        <div class="col-sm-12">
                                            <label for="form-field-8">Vai trò</label>
                                            <select class="form-control z-field" name="role">
                                                <option value="0">Nhân viên</option>
                                                <option value="1">Quản trị viên</option>
                                            </select>
                                        </div>
                                    </sec:authorize>

                                </div>
                                <div class="form-group">

                                    <div class="col-sm-12">
                                        <label for="form-field-8">Tên tài khoản</label>

                                        <input class="form-control z-field" name="username" readonly placeholder="" />
                                    </div>
                                    <div class="col-sm-12">
                                        <label for="form-field-8">Mật khẩu</label>

                                        <input class="form-control z-field" type="password" name="password"
                                            placeholder="" />
                                    </div>

                                </div>
                                <div class="form-group">

                                    <div class="col-sm-12">
                                        <label for="form-field-8">SĐT</label>
                                        <input class="form-control z-field" name="phone" placeholder="" />
                                    </div>
                                </div>

                                <hr>
                                <div class="form-group">
                                    <div class="col-md-10 col-sm-9 col-xs-12 col-md-push-2 col-sm-push-3 col-xs-push-0">
                                        <input id="btn-submit" class="btn btn-primary" type="button" value="Cập nhật">
                                    </div>
                                </div>
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </div>


    <%@ include file = "../../common/web-components/lib.jsp"%>

    <script src='<c:url value="/common/custom/profile/profile.js" />'></script>

</body>