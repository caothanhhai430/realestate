<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="col-xs-12">

    <div style="display:inline-block;width:100%;">
        <h2 style="display:inline-block;" class="bigger lighter blue">Danh sách người dùng</h2>
        <div class="pull-right tableTools-container">
            <sec:authorize access="hasAuthority('ADMIN')">

                <div class="btn-group btn-overlap">
                    <div class="ColVis btn-group" title="" data-original-title="Show/hide columns">
                        <button id="btn_add_user" data-toggle="modal" data-target="#myModal"
                            class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
                                <i class="fa fa-plus"></i></span></button></div>                  
                </div>
        </div>
        </sec:authorize>

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
                            aria-label="">username</th>

                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">Họ và tên</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">SĐT</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">vai trò</th>
                        <th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"
                            aria-label="">trạng thái</th>
                        <th class="sorting" style="width: 210px;" tabindex="0" aria-controls="dynamic-table" rowspan="1"
                            colspan="1" aria-label="">Thao tác</th>
                </thead>

                <tbody id="data-user-list">
                </tbody>
            </table>
            <div id="pagination-container" style="margin-top: 25px;"></div>

        </div>
    </div>
</div>