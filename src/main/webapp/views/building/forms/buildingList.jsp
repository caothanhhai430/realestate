<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="col-xs-12">

    <div style="display:inline-block;width:100%;">
        <h2 style="display:inline-block;" class="bigger lighter blue">Danh sách tòa nhà</h2>
        <div class="pull-right tableTools-container">
         
                <div class="btn-group btn-overlap">
                    <div class="ColVis btn-group" title="" data-original-title="Show/hide columns">
                        <button id="btn_add_building" data-toggle="modal" data-target="#myModal"
                            class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
                                <i class="fa fa-plus"></i></span></button></div>
                    <a class="DTTT_button btn btn-white btn-primary  btn-bold" id="delete-selected-building" title=""
                        tabindex="0" aria-controls="dynamic-table" data-original-title="Print view"><span>
                            <i class="fa fa-trash bigger-110 grey"></i></span></a>
                </div>
        </div>
        
    </div>
    <div class="table-header">
    </div>

    <div>
        <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">

            <table id="dynamic-table"
                class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable" role="grid"
                aria-describedby="dynamic-table_info">
                <thead>
                    <tr role="row">
                        <th class="center sorting_disabled" rowspan="1" colspan="1" aria-label=">">
                            <label class="pos-rel">
                                <input type="checkbox" class="ace">
                                <span class="lbl"></span>
                            </label>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Tên sản phẩm</th>

                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Địa chỉ</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Tên quản lý</th>

                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Số điện thoại</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Diện tích sàn</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Giá thuê</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Loại tòa nhà</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Diện tích thuê</th>
                        <th class="sorting" style="width: 210px;" tabindex="0" aria-controls="dynamic-table" rowspan="1"
                            colspan="1" aria-label="">Thao tác</th>
                </thead>

                <tbody id="data-building-list">
                </tbody>
            </table>
            <div id="pagination-container" style="margin-top: 25px;"></div>

        </div>
    </div>
</div>