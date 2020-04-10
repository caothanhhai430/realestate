<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">

			<form id="customerForm">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Thêm mới khách hàng</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<div class="col-sm-4">
							<label for="form-field-8">Tên khách hàng</label>

							<input class="form-control z-field" name="name" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Số điện thoại</label>

							<input class="form-control z-field" name="phone" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Email</label>

							<input class="form-control z-field" name="email" placeholder="" />
						</div>

					</div>


					<div class="form-group">
						<div class="col-sm-4">
							<label for="form-field-8">Tên công ty</label>

							<input class="form-control z-field" name="company" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Nhu cầu</label>

							<input class="form-control z-field" name="demand" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Ghi chú</label>

							<input class="form-control z-field" name="note" placeholder="" />
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

				<input id="modal_customerId" name="id" type="hidden" value="">
			</form>
		</div>

	</div>
</div>