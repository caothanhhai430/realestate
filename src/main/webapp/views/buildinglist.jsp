<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
	<body>

	
			<div class="main-content">
			
				<div class="main-content-inner">

					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->

					

					</div>
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
										<form id="building_form">
									
									<div class="form-group">
											<div class="col-sm-4">
													<label for="form-field-8">Tên tòa nhà</label>
			
													<textarea class="form-control" name="name" id="form-field-8" placeholder=""></textarea>
												</div>
											<div class="col-sm-4">
													<label for="form-field-8">Diện tích sàn</label>
			
													<textarea class="form-control" name="rentArea" id="form-field-8" placeholder=""></textarea>
											</div>
											<div class="col-sm-4">
												<label for="form-field-8">Số tầng hầm</label>
		
												<textarea class="form-control" name="numberOfBasement" id="form-field-8" placeholder=""></textarea>
										</div>
		
									</div>
									<div class="form-group">
										<div class="col-sm-4">
												<label for="form-field-8">Quận,Huyện</label>
		
												<select class="form-control" name="district" id="form-field-8">
													<option value=""></option>
													<option value="QUAN_1">Quận 1</option>
													<option value="QUAN_2">Quận 2</option>
													<option value="QUAN_3">Quận 3</option>
													<option value="QUAN_4">Quận 4</option>
													<option value="QUAN_5">Quận 5</option>
													<option value="QUAN_6">Quận 6</option>
													<option value="QUAN_7">Quận 7</option>
													<option value="QUAN_8">Quận 8</option>
													<option value="QUAN_9">Quận 9</option>
													<option value="QUAN_10">Quận 10</option>
													<option value="QUAN_11">Quận 11</option>
													<option value="QUAN_12">Quận 12</option>
													<option value="QUAN_THU_DUC">Quận Thủ Đức</option>
													<option value="QUAN_GO_VAP">Quận Gò Vấp</option>
													<option value="QUAN_BINH_THANH">Quận Bình Thạnh</option>
													<option value="QUAN_TAN_BINH">Quận Tân Bình</option>
													<option value="QUAN_TAN_PHU">Quận Tân Phú</option>
													<option value="QUAN_PHU_NHUAN">Quận Phú Nhuận</option>
													<option value="QUAN_BINH_TAN">Quận Bình Tân</option>
													<option value="QUAN_CU_CHI">Quận Củ Chi</option>
													<option value="QUAN_HOC_MON">Quận Hóc Môn</option>
													<option value="QUAN_BINH_CHANH">Quận Bình Chánh</option>
													<option value="QUAN_NHA_BE">Quận Nhà Bè</option>
													<option value="QUAN_CAN_GIO">Quận Cần Giờ</option>
												  </select>
												</div>
										<div class="col-sm-4">
												<label for="form-field-8">Phường</label>
		
												<textarea class="form-control" name="ward" id="form-field-8" placeholder=""></textarea>
										</div>
										<div class="col-sm-4">
											<label for="form-field-8">Đường</label>
	
											<textarea class="form-control" name="street" id="form-field-8" placeholder=""></textarea>
									</div>
	
								</div>
								
									<div class="form-group">
											<div class="col-sm-3">
													<label for="form-field-8">Diện tích từ</label>
			
													<textarea class="form-control" name="rentAreaFrom" id="form-field-8" placeholder=""></textarea>
												</div>
											<div class="col-sm-3">
													<label for="form-field-8">Diện tích đến</label>
			
													<textarea class="form-control" name="rentAreaTo" id="form-field-8" placeholder=""></textarea>
												</div>
												<div class="col-sm-3">
														<label for="form-field-8">Giá thuê từ</label>
				
														<textarea class="form-control" name="costRentFrom" id="form-field-8" placeholder=""></textarea>
													</div>
												<div class="col-sm-3">
														<label for="form-field-8">Giá thuê đến</label>
				
														<textarea class="form-control" name="costRentTo" id="form-field-8" placeholder=""></textarea>
													</div>
		
									</div>

									<div>
										<input type="checkbox" name="buildingType" value="NOI_THAT"> Nội thất
										<input type="checkbox" name="buildingType" value="TANG_TRET"> Tầng trệt
										<input type="checkbox" name="buildingType" value="NGUYEN_CAN"> Nguyên căn
									</div>


										<div id="form-field-11" class="autosize-transition form-control" style="overflow: hidden; padding: 0px;border: 0px; height: 0px;"></div>
										<button type="submit" class="btn btn-purple btn-sm">
											<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
											Search
										</button>
									
								</form>
								</div>
							</div>
						</div>
					</div>
					


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
          <table style="width:100%">
  <tr>
    <th>Chọn nhân viên</th>
    <th>Tên nhân viên</th> 
      </tr>
  <tr>
    <td><input type="checkbox" name="staffId" value=""></td>
    <td>Smith</td>
      </tr>
</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Lưu thay đổi</button>
        </div>
      </div>
      
    </div>
  </div>


  <!-- Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
      
			<form id="form_save">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Thêm mới tòa nhà</h4>
        </div>
        <div class="modal-body">
									
									<div class="form-group">
											<div class="col-sm-4">
													<label for="form-field-8">Tên tòa nhà</label>
			
													<textarea class="form-control" name="name" id="form-field-8" placeholder=""></textarea>
												</div>
											<div class="col-sm-4">
													<label for="form-field-8">Diện tích sàn</label>
			
													<textarea class="form-control" name="" id="form-field-8" placeholder=""></textarea>
											</div>
											<div class="col-sm-4">
												<label for="form-field-8">Số tầng hầm</label>
		
												<textarea class="form-control" name="numberOfBasement" id="form-field-8" placeholder=""></textarea>
										</div>
		
									</div>
									<div class="form-group">
										<div class="col-sm-4">
												<label for="form-field-8">Quận,Huyện</label>
		
												<select class="form-control" name="district" id="form-field-8">
													<option value=""></option>
													<option value="QUAN_1">Quận 1</option>
													<option value="QUAN_2">Quận 2</option>
													<option value="QUAN_3">Quận 3</option>
													<option value="QUAN_4">Quận 4</option>
													<option value="QUAN_5">Quận 5</option>
													<option value="QUAN_6">Quận 6</option>
													<option value="QUAN_7">Quận 7</option>
													<option value="QUAN_8">Quận 8</option>
													<option value="QUAN_9">Quận 9</option>
													<option value="QUAN_10">Quận 10</option>
													<option value="QUAN_11">Quận 11</option>
													<option value="QUAN_12">Quận 12</option>
													<option value="QUAN_THU_DUC">Quận Thủ Đức</option>
													<option value="QUAN_GO_VAP">Quận Gò Vấp</option>
													<option value="QUAN_BINH_THANH">Quận Bình Thạnh</option>
													<option value="QUAN_TAN_BINH">Quận Tân Bình</option>
													<option value="QUAN_TAN_PHU">Quận Tân Phú</option>
													<option value="QUAN_PHU_NHUAN">Quận Phú Nhuận</option>
													<option value="QUAN_BINH_TAN">Quận Bình Tân</option>
													<option value="QUAN_CU_CHI">Huyện Củ Chi</option>
													<option value="QUAN_HOC_MON">Huyện Hóc Môn</option>
													<option value="QUAN_BINH_CHANH">Huyện Bình Chánh</option>
													<option value="QUAN_NHA_BE">Huyện Nhà Bè</option>
													<option value="QUAN_CAN_GIO">Huyện Cần Giờ</option>
												  </select>
												</div>
										<div class="col-sm-4">
												<label for="form-field-8">Phường</label>
		
												<textarea class="form-control" name="ward" id="form-field-8" placeholder=""></textarea>
										</div>
										<div class="col-sm-4">
											<label for="form-field-8">Đường</label>
	
											<textarea class="form-control" name="street" id="form-field-8" placeholder=""></textarea>
									</div>
	
								</div>

								<div class="form-group">
									<div class="col-sm-4">
											<label for="form-field-8">Kết cấu</label>
	
											<textarea class="form-control" name="structure" id="form-field-8" placeholder=""></textarea>
										</div>
									<div class="col-sm-4">
											<label for="form-field-8">Hướng</label>
	
											<textarea class="form-control" name="" id="form-field-8" placeholder=""></textarea>
									</div>
									<div class="col-sm-4">
										<label for="form-field-8">Hạng</label>

										<textarea class="form-control" name="" id="form-field-8" placeholder=""></textarea>
								</div>

							</div>

							
							<div class="form-group">
								<div class="col-sm-4">
										<label for="form-field-8">Giá thuê</label>

										<textarea class="form-control" name="costRent" id="form-field-8" placeholder=""></textarea>
									</div>
								<div class="col-sm-4">
										<label for="form-field-8">Mô tả giá</label>

										<textarea class="form-control" name="costDescription" id="form-field-8" placeholder=""></textarea>
								</div>
								<div class="col-sm-4">
									<label for="form-field-8">Phí dịch vụ</label>

									<textarea class="form-control" name="serviceCost" id="form-field-8" placeholder=""></textarea>
							</div>

						</div>
								
						
						<div class="form-group">
							<div class="col-sm-4">
									<label for="form-field-8">Phí xe hơi</label>

									<textarea class="form-control" name="carCost" id="form-field-8" placeholder=""></textarea>
								</div>
							<div class="col-sm-4">
									<label for="form-field-8">Phí mô tô</label>

									<textarea class="form-control" name="motorbikeCost" id="form-field-8" placeholder=""></textarea>
							</div>
							<div class="col-sm-4">
								<label for="form-field-8">phí ngoài giờ</label>

								<textarea class="form-control" name="overtimeCost"" id="form-field-8" placeholder=""></textarea>
						</div>

					</div>

					
					<div class="form-group">
						
							<div class="col-sm-3">
									<label for="form-field-8">Phí môi giới</label>
	
									<textarea class="form-control" name="" id="form-field-8" placeholder=""></textarea>
								</div>
						<div class="col-sm-3">
								<label for="form-field-8">Tiền điện</label>

								<textarea class="form-control" name="electricityCost" id="form-field-8" placeholder=""></textarea>
							</div>
						<div class="col-sm-3">
								<label for="form-field-8">Đặt cọc</label>

								<textarea class="form-control" name="deposit" id="form-field-8" placeholder=""></textarea>
						</div>
						<div class="col-sm-3">
							<label for="form-field-8">Thanh toán</label>

							<textarea class="form-control" name="payment" id="form-field-8" placeholder=""></textarea>
					</div>

				</div>

				
				<div class="form-group">
					<div class="col-sm-3">
							<label for="form-field-8">Thời gian thuê</label>

							<textarea class="form-control" name="timeRent" id="form-field-8" placeholder=""></textarea>
						</div>
					<div class="col-sm-3">
							<label for="form-field-8">Thời gian trang trí</label>

							<textarea class="form-control" name="timeDecorator" id="form-field-8" placeholder=""></textarea>
					</div>
					<div class="col-sm-3">
						<label for="form-field-8">Tên quản lý</label>

						<textarea class="form-control" name="managerName" id="form-field-8" placeholder=""></textarea>
				</div>
				
				<div class="col-sm-3">
					<label for="form-field-8">SĐT quản lý</label>

					<textarea class="form-control" name="managerPhone" id="form-field-8" placeholder=""></textarea>
			</div>

			</div>
									

									<div>
										<input type="checkbox" name="buildingType" value="NOI_THAT"> Nội thất
										<input type="checkbox" name="buildingType" value="TANG_TRET"> Tầng trệt
										<input type="checkbox" name="buildingType" value="NGUYEN_CAN"> Nguyên căn
									</div>


										<div id="form-field-11" class="autosize-transition form-control" style="overflow: hidden; padding: 0px;border: 0px; height: 0px;"></div>
										
									
			
        </div>
        <div class="modal-footer">
        <button id="submit_save" type="button" class="btn btn-default">
											<span"></span>
											Thêm mới
										</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
        </div>
        
								</form>
      </div>
      
    </div>
  </div>
  
					<div class="col-xs-12">
							<h3 class="header smaller lighter blue">Danh sách tòa nhà</h3>

							<div class="clearfix">
								<div class="pull-right tableTools-container"><div class="btn-group btn-overlap"><div class="ColVis btn-group" title="" data-original-title="Show/hide columns">
								<button data-toggle="modal" data-target="#myModal" class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
								<i class="fa fa-plus"></i></span></button></div>
								<a class="DTTT_button btn btn-white btn-primary  btn-bold" id="ToolTables_dynamic-table_3" title="" tabindex="0" aria-controls="dynamic-table" data-original-title="Print view"><span>
								<i class="fa fa-trash bigger-110 grey"></i></span></a></div></div>
							</div>
							<div class="table-header">
							</div>

							<div>
								<div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer"><div class="row"><div class="col-xs-6"><div class="dataTables_length" id="dynamic-table_length"><label>Display <select name="dynamic-table_length" aria-controls="dynamic-table" class="form-control input-sm"><option value="10">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> records</label></div></div><div class="col-xs-6"><div id="dynamic-table_filter" class="dataTables_filter"><label>Search:<input type="search" class="form-control input-sm" placeholder="" aria-controls="dynamic-table"></label></div></div></div><table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable" role="grid" aria-describedby="dynamic-table_info">
									<thead>
										<tr role="row"><th class="center sorting_disabled" rowspan="1" colspan="1" aria-label=">">
												<label class="pos-rel">
													<input type="checkbox" class="ace">
													<span class="lbl"></span>
												</label>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Tên sản phẩm</th>
									
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Địa chỉ</th>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Tên quản lý</th>
											
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Số điện thoại</th>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Diện tích sàn</th>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Giá thuê</th>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Phí dịch vụ</th>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Loại tòa nhà</th>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Diện tích thuê</th>
											<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="">Thao tác</th>
										</thead>

									<tbody>
										
									<c:forEach var="building" items="${buildingList}">
									
									<tr>
											<td class="center">
												<label class="pos-rel">
													<input type="checkbox" class="ace">
													<span class="lbl"></span>
												</label>
											</td>

											<td>
												<a href="#">${building.name}</a>
											</td>
											<td>${building.district}</td>
											
											<td>${building.managerName}</td>
											<td>${building.managerPhone}</td>

											<td>${building.buildingArea}</td>
											<td >${building.costRent}</td>
											
											<td >${building.serviceCost}</td>
	
											<td ></td>
											<td ></td>
			
											<td>
												<div class="hidden-sm hidden-xs action-buttons">
												
													<button data-toggle="modal" data-target="#modalStaff" class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
								
														<i class="ace-icon glyphicon glyphicon-user"></i></span></button>
													 
													 
													<button data-toggle="modal" data-target="#myModal" class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
								
														<i class="ace-icon fa fa-pencil bigger-130"></i></span></button>
													 <button  class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span>
								
														
														<i class="ace-icon fa fa-trash-o bigger-130"></i></span></button>
													 
															</div>

											</td>
										</tr>
										
									</c:forEach>

										
									</tbody>
								</table>
								<div class="row"><div class="col-xs-6"><div class="dataTables_info" id="dynamic-table_info" role="status" aria-live="polite">Showing 1 to 10 of 23 entries</div></div><div class="col-xs-6"><div class="dataTables_paginate paging_simple_numbers" id="dynamic-table_paginate"><ul class="pagination"><li class="paginate_button previous disabled" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_previous"><a href="#">Previous</a></li><li class="paginate_button active" aria-controls="dynamic-table" tabindex="0"><a href="#">1</a></li><li class="paginate_button " aria-controls="dynamic-table" tabindex="0"><a href="#">2</a></li><li class="paginate_button " aria-controls="dynamic-table" tabindex="0"><a href="#">3</a></li><li class="paginate_button next" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_next"><a href="#">Next</a></li></ul></div></div></div></div>
							</div>
						</div>
				</div>
				
				
			</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script >

	$(document).ready(function(){
	$("#submit_save").click(function(){
	    var x = $("#form_save").serializeArray();
	    var type = [];
	    var data = {};
	    $.each(x, function(i, field){
	      data[field.name] =  field.value;
	      if(field.name == 'buildingType'){
	    	  type.push(field.value);
	      }
	    });
	    data['buildingType'] = type;
	    console.log(JSON.stringify(data));
	    console.log('new');
	    fetch('http://localhost:8080/api-server/building', {
	        method: 'POST', // or 'PUT'
	        body: JSON.stringify(data), // data can be `string` or {object}!
	        headers: {
	          'Content-Type': 'application/json'
	        }
	      }).then(res => res.json())
	      .then(res =>	{
	    	console.log(res);  
	      });
	    
	  });
	  });
	</script>

	</body>
