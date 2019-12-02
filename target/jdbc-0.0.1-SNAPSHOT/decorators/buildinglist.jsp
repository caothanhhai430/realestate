<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">

   <%@ include file="/common/head.jsp" %>
	<body class="no-skin">
			<%@ include file="/common/header.jsp" %>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			
				<%@ include file="/common/sidebar.jsp" %>


	
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
												<label for="form-field-8">Quận</label>
		
												<select class="form-control" name="district" id="form-field-8">
													<option value="QUAN_1">Quận 1</option>
													<option value="QUAN_2">Quận 2</option>
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
										<button type="button" class="btn btn-purple btn-sm">
											<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
											Search
										</button>
								</div>
							</div>
						</div>
					</div>




					<div class="col-xs-12">
							<h3 class="header smaller lighter blue">Danh sách tòa nhà</h3>

							<div class="clearfix">
								<div class="pull-right tableTools-container"><div class="btn-group btn-overlap"><div class="ColVis btn-group" title="" data-original-title="Show/hide columns"><button class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold"><span><i class="fa fa-plus"></i></span></button></div><a class="DTTT_button btn btn-white btn-primary  btn-bold" id="ToolTables_dynamic-table_3" title="" tabindex="0" aria-controls="dynamic-table" data-original-title="Print view"><span><i class="fa fa-trash bigger-110 grey"></i></span></a></div></div>
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
										
										

										
									<tr role="row" class="odd">
											<td class="center">
												<label class="pos-rel">
													<input type="checkbox" class="ace">
													<span class="lbl"></span>
												</label>
											</td>

											<td>
												<a href="#">app.com</a>
											</td>
											<td>$45</td>
											<td class="hidden-480">3,330</td>
											<td>Feb 12</td>

											<td class="hidden-480">
												<span class="label label-sm label-warning">Expiring</span>
											</td>
											<td class="hidden-480">
												<span class="label label-sm label-warning">Expiring</span>
											</td>
											<td class="hidden-480">
												<span class="label label-sm label-warning">Expiring</span>
											</td>
											<td class="hidden-480">
												<span class="label label-sm label-warning">Expiring</span>
											</td>
											<td class="hidden-480">
												<span class="label label-sm label-warning">Expiring</span>
											</td>
			
											<td>
												<div class="hidden-sm hidden-xs action-buttons">
													<a class="blue" href="#">
														<i class="ace-icon glyphicon glyphicon-user"></i>
													</a>

													<a class="green" href="#">
														<i class="ace-icon fa fa-pencil bigger-130"></i>
													</a>

													<a class="red" href="#">
														<i class="ace-icon fa fa-trash-o bigger-130"></i>
													</a>
												</div>

											</td>
										</tr>
										
									</tbody>
								</table><div class="row"><div class="col-xs-6"><div class="dataTables_info" id="dynamic-table_info" role="status" aria-live="polite">Showing 1 to 10 of 23 entries</div></div><div class="col-xs-6"><div class="dataTables_paginate paging_simple_numbers" id="dynamic-table_paginate"><ul class="pagination"><li class="paginate_button previous disabled" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_previous"><a href="#">Previous</a></li><li class="paginate_button active" aria-controls="dynamic-table" tabindex="0"><a href="#">1</a></li><li class="paginate_button " aria-controls="dynamic-table" tabindex="0"><a href="#">2</a></li><li class="paginate_button " aria-controls="dynamic-table" tabindex="0"><a href="#">3</a></li><li class="paginate_button next" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_next"><a href="#">Next</a></li></ul></div></div></div></div>
							</div>
						</div>
				</div>
				
				
			</div>
				<!-- footer -->
				<%@ include file="/common/footer.jsp" %>

		
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->
			<!-- lib -->

			<%@ include file="/common/lib.jsp" %>

	</body>
</html>
