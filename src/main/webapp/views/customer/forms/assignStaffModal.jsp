<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="modalStaff" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <table id="myTable" class="table table-striped">
          <input id="assign_customerId" type="hidden" value="">
          <thead>
            <th>Chọn nhân viên</th>
            <th>Tên nhân viên</th>

          </thead>
          <tbody id="tBody">

          </tbody>

        </table>
      </div>
      <div class="modal-footer">
        <button id="saveAssignmentStaff" type="button" class="btn btn-success" data-dismiss="modal">Lưu thay
          đổi</button>
      </div>
    </div>

  </div>
</div>