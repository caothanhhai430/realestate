<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="transactionModal">
	<div class="modal-dialog modal-lg">
		<input type="hidden" id="id-customer-trans">
		<!-- Modal content-->
		<div class="modal-content" style="overflow-wrap: break-word;">
			<div>
				<span style="font-size: 35px;">Quá trình CSKH
					<button id="btn-addCareNote"
						class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
							<i class="fa fa-plus"></i></span></button>
				</span>
				<table id="customerCare"
					class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable"
					role="grid">
					<thead>
						<tr>
							<th>Ngày tạo</th>
							<th style="width: 300px;">Ghi chú</th>
							<th>Người nhập</th>
						</tr>
					</thead>
					<tbody id="tbody-customerCare"></tbody>
				</table>
				<button id="btn-loadMoreCareNote" style="float:right;margin-top:7px;margin-right:10px;" class="btn btn-info">Xem thêm</button>
			</div>
			<div style="height: 100px;"></div>
			<div>
				<span style="font-size: 35px;">Dẫn đi ăn
					<button id="btn-addTourNote"
						class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
							<i class="fa fa-plus"></i></span></button>
				</span>
				<table id="customerTour"
					class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable"
					role="grid">
					<thead>
						<tr>
							<th>Ngày tạo</th>
							<th style="width: 300px;">Ghi chú</th>
							<th>Người nhập</th>
						</tr>
					</thead>
					<tbody id="tbody-customerTour"></tbody>
				</table>
				<button id="btn-loadMoreTourNote" style="float:right;margin-top:7px;margin-right:10px;" class="btn btn-info">Xem thêm</button>
			
			</div>
			<div style="height: 200px;"></div>
			
		</div>

	</div>
</div>