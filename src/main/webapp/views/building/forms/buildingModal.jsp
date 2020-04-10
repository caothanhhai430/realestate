<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">

			<form id="buildingForm">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Thêm mới tòa nhà</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<div class="col-sm-4">
							<label for="form-field-8">Tên tòa nhà</label>

							<input class="form-control z-field" name="name" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Diện tích sàn</label>

							<input class="form-control z-field" name="buildingArea" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Số tầng hầm</label>

							<input class="form-control z-field" name="numberOfBasement" placeholder="" />
						</div>

					</div>
					<div class="form-group">
						<div class="col-sm-4">
							<label for="form-field-8">Quận,Huyện</label>

							<select class="form-control z-field" name="district">
								<option value="">--- Select ---</option>
								<c:forEach items="${districtsMap}" var="district">
									<option value="${district.key}">${district.value}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Phường</label>

							<input class="form-control z-field" name="ward" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Đường</label>

							<input class="form-control z-field" name="street" placeholder="" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-3">
							<label for="form-field-8">Kết cấu</label>

							<input class="form-control z-field" name="structure" placeholder="" />
						</div>
						<div class="col-sm-3">
							<label for="form-field-8">Diện tích thuê</label>

							<input class="form-control z-field" name="rentArea" placeholder="" />
						</div>

					</div>


					<div class="form-group">
						<div class="col-sm-4">
							<label for="form-field-8">Giá thuê</label>

							<input class="form-control z-field" name="rentCost" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Mô tả giá</label>

							<input class="form-control z-field" name="costDescription" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Phí dịch vụ</label>

							<input class="form-control z-field" name="serviceCost" placeholder="" />
						</div>

					</div>


					<div class="form-group">
						<div class="col-sm-4">
							<label for="form-field-8">Phí xe hơi</label>

							<input class="form-control z-field" name="carCost" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">Phí mô tô</label>

							<input class="form-control z-field" name="motorbikeCost" placeholder="" />
						</div>
						<div class="col-sm-4">
							<label for="form-field-8">phí ngoài giờ</label>

							<input class="form-control z-field" name="overtimeCost" id=" form-field-8" placeholder="" />
						</div>

					</div>


					<div class="form-group">

						<div class="col-sm-3">
							<label for="form-field-8">Phí môi giới</label>

							<input class="form-control z-field" placeholder="" />
						</div>
						<div class="col-sm-3">
							<label for="form-field-8">Tiền điện</label>

							<input class="form-control z-field" name="electricityCost" placeholder="" />
						</div>
						<div class="col-sm-3">
							<label for="form-field-8">Đặt cọc</label>

							<input class="form-control z-field" name="deposit" placeholder="" />
						</div>
						<div class="col-sm-3">
							<label for="form-field-8">Thanh toán</label>

							<input class="form-control z-field" name="payment" placeholder="" />
						</div>

					</div>


					<div class="form-group">
						<div class="col-sm-3">
							<label for="form-field-8">Thời gian thuê</label>

							<input class="form-control z-field" name="rentTime" placeholder="" />
						</div>
						<div class="col-sm-3">
							<label for="form-field-8">Thời gian trang trí</label>

							<input class="form-control z-field" name="decoratorTime" placeholder="" />
						</div>
						<div class="col-sm-3">
							<label for="form-field-8">Tên quản lý</label>

							<input class="form-control z-field" name="managerName" placeholder="" />
						</div>

						<div class="col-sm-3">
							<label for="form-field-8">SĐT quản lý</label>

							<input class="form-control z-field" name="managerPhone" placeholder="" />
						</div>

					</div>



					<div class="form-group building-type-checkbox">

						<div class="col-sm-12">
                            <c:forEach var="item" items="${buildingTypesMap}">
                                <input class="z-field" type="checkbox" name="buildingType" value="${item.key}" /> ${item.value}
                            </c:forEach>
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

				<input id="modal_buildingId" name="id" type="hidden" value="">
			</form>
		</div>

	</div>
</div>