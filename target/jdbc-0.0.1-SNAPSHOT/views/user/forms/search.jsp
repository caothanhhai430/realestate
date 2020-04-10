<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="page-content">

    <div class="widget-box">
        <div class="widget-header">
            <h4 class="widget-title">Tìm kiếm</h4>

            <div class="widget-toolbar">
                <a href="#" data-action="collapse">
                    <i class="ace-icon fa fa-chevron-up"></i>
                </a>

            </div>
        </div>

        <div class="widget-body" style="display: block;">


            <div class="widget-main">
                <form id="user_form">
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label for="form-field-8">Tên</label>
                            <input class="form-control" name="fullname" />
                        </div>
                        <div class="col-sm-6">
                            <label for="form-field-8">SĐT</label>
                            <input class="form-control" name="phone" />
                        </div>
                    </div>
                </form>
            </div>

            <div id="form-field-11" class="autosize-transition form-control"
                style="overflow: hidden; padding: 0px;border: 0px; height: 0px;"></div>
            <button id="btn_search" type="button" style="margin-top: 25px;" class="btn btn-purple btn-sm">
                <span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
                Tìm kiếm
            </button>
        </div>

    </div>
</div>