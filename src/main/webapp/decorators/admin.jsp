<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">

   <%@ include file="/common/head.jsp" %>
	<body>
			<%@ include file="/common/header.jsp" %>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			
				<%@ include file="/common/sidebar.jsp" %>


				<dec:body/>
	
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
