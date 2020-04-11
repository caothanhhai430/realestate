<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="page-content">

    <div class="widget-box">
        <div class="widget-header">
            <h4 class="widget-title">Tìm kiếm</h4>

            <div class="widget-toolbar">
                <a href="#" data-action="collapse">
                    <i class="ace-icon fa fa-chevron-up"></i>
                </a>
                <!-- 
                <a href="#" data-action="close">
                    <i class="ace-icon fa fa-times"></i>
                </a> -->
            </div>
        </div>

        <div class="widget-body" style="display: block;">


            <div class="widget-main">
                <form id="customer_form"  method="GET">
                    <div class="form-group">
                        <div class="col-sm-4">
                            <label for="form-field-8">Tên khách hàng</label>

                            <input class="form-control" name="name" />
                        </div>
                        <div class="col-sm-4">
                            <label for="form-field-8">Di động</label>

                            <input class="form-control" name="phone" />
                        </div>
                        <div class="col-sm-4">
                            <label for="form-field-8">Email</label>

                            <input class="form-control" name="email" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4">
                                <label for="form-field-8">Nhân viên vụ trách</label>

                                <select class="form-control" name="staffId">
                                    <option value="">--- Select ---</option>
                                    <c:forEach var="item" items="${staffMap}">
                                        <option value="${item.id}">${item.fullname}</option>
                                    </c:forEach>
                                    <select>
                        
                        </div>

                    </div>



                    <div id="form-field-11" class="autosize-transition form-control"
                        style="overflow: hidden; padding: 0px;border: 0px; height: 0px;"></div>
                    <button id="btn_search" type="button" style="margin-top: 25px;" class="btn btn-purple btn-sm">
                        <span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
                        Tìm kiếm
                    </button>


                </form>
            </div>

        </div>
    </div>
</div>