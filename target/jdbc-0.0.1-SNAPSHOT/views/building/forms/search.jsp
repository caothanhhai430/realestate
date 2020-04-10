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
                <form id="building_form" method="GET">


                    <div class="form-group row">
                        <div class="col-sm-4">
                            <label for="form-field-8">Tên tòa nhà</label>

                            <input class="form-control" name="name" />
                        </div>
                        <div class="col-sm-4">
                            <label for="form-field-8">Diện tích sàn</label>

                            <input class="form-control" name="buildingArea" />
                        </div>
                        <div class="col-sm-4">
                            <label for="form-field-8">Số tầng hầm</label>

                            <input class="form-control" name="numberOfBasement" />
                        </div>

                    </div>
                    <div class="form-group row">
                        <div class="col-sm-4">
                            <label for="form-field-8">Quận,Huyện</label>


                            <select class="form-control" name="district">
                                <option value="">--- Select ---</option>
                                <c:forEach var="item" items="${districtsMap}">
                                    <option value="${item.key}">${item.value}</option>
                                </c:forEach>
                                <select>
                        </div>
                        <div class="col-sm-4">
                            <label for="form-field-8">Phường</label>

                            <input class="form-control" name="ward" />
                        </div>
                        <div class="col-sm-4">
                            <label for="form-field-8">Đường</label>

                            <input class="form-control" name="street" />
                        </div>

                    </div>

                    <div class="form-group row">
                        <div class="col-sm-3">
                            <label for="form-field-8">Diện tích từ</label>

                            <input class="form-control" name="rentAreaFrom" />
                        </div>
                        <div class="col-sm-3">
                            <label for="form-field-8">Diện tích đến</label>

                            <input class="form-control" name="rentAreaTo" />
                        </div>
                        <div class="col-sm-3">
                            <label for="form-field-8">Giá thuê từ</label>

                            <input class="form-control" name="rentCostFrom" />
                        </div>
                        <div class="col-sm-3">
                            <label for="form-field-8">Giá thuê đến</label>

                            <input class="form-control" name="rentCostTo" />
                        </div>

                    </div>

                    <div class="form-group row">
                        <div class="col-sm-4">
                            <label for="form-field-8">Tên quản lý</label>

                            <input class="form-control" name="managerName" />
                        </div>
                        <div class="col-sm-4">
                            <label for="form-field-8">SĐT quản lý</label>

                            <input class="form-control" name="managerPhone" />
                        </div>
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

                    <div class="form-group row">

                        <div class="col-sm-8">
                            <c:forEach var="item" items="${buildingTypesMap}">
                                <input class="z-field" type="checkbox" name="buildingType" value="${item.key}" /> ${item.value}
                            </c:forEach>
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