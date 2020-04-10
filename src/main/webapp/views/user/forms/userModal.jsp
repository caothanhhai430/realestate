<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">

			<form id="userForm">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Thêm mới người dùng</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<div class="col-sm-6">
							<label for="form-field-8">Họ và tên</label>

							<input class="form-control z-field" name="fullname" placeholder="" />
						</div>

						<div class="col-sm-6">
							<label for="form-field-8">Vai trò</label>

							<select class="form-control z-field" name="role">
								<option value="0">Nhân viên</option>
								<option value="1">Quản trị viên</option>
							</select>
						</div>



					</div>
					<div class="form-group">

						<div class="col-sm-6">
							<label for="form-field-8">Tên tài khoản</label>

							<input class="form-control z-field" name="username" placeholder="" />
						</div>
						<div class="col-sm-6">
							<label for="form-field-8">Mật khẩu</label>

							<input class="form-control z-field" type="password" name="password" placeholder="" />
						</div>

					</div>
					<div class="form-group">
						<div class="col-sm-6">
							<label for="form-field-8">Trạng thái</label>
							<select class="form-control z-field" name="status">
								<option value="1">Hoạt động</option>
								<option value="0">Ngưng hoạt động</option>
							</select>

						</div>
						<div class="col-sm-6">
							<label for="form-field-8">SĐT</label>
							<input class="form-control z-field" name="phone" placeholder="" />
						</div>
					</div>

					<div id="form-field-11" class="autosize-transition form-control"
						style="overflow: hidden; padding: 0px;border: 0px; height: 0px;"></div>



				</div>
				<div class="modal-footer">
					<button id="submit_save" type="button" class="btn btn-success">
						Thêm mới
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>

				<input id="modal_userId" name="id" type="hidden" value="">
			</form>
		</div>

	</div>
</div>