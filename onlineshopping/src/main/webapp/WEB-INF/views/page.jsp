<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- for Ajax Call Spring Security -->
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">


<title>Shop Home-${title}</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap 3.x version glyphicons CSS -->
<link href="${css}/glyphicon.css" rel="stylesheet">

<!-- Bootstrap SandStone these  -->
<link href="${css}/bootstrap.sandstone.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<!-- jquery dataTable bootstrap-->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@ include file="./shared/navigation.jsp"%>


		<!-- Page Content -->
		<div class="content">
			<!-- Loading the home content -->
			<c:if test="${userClickHome == true}">
				<%@ include file="./home.jsp"%>
			</c:if>

			<!-- load only when user click on about -->
			<c:if test="${userClickAbout == true}">
				<%@ include file="./about.jsp"%>
			</c:if>

			<!-- load only when user click on contact -->
			<c:if test="${userClickContact == true}">
				<%@ include file="./contact.jsp"%>
			</c:if>
			<!-- load only when user click on listProducts -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProduct == true}">
				<%@ include file="./listProducts.jsp"%>
			</c:if>
			
			<!-- load only when user click on single Product -->
			<c:if test="${userClickSingleProduct == true}">
			
				<!-- <script type="text/javascript">
					var prodImage = '${product.productImages}';
					
					window.productsImages = [] ;
					
					var i;
					for (i = 0; i < prodImage.length; i++) { 
						window.productsImages.push(prodImage[i].imgName);
					}
				</script> -->
				
				<%@ include file="./product.jsp"%>
			</c:if>
			
			<!-- load only when user click on Manage Products -->
			<c:if test="${userClickmanageProducts == true}">
				<%@ include file="./manageProducts.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		
		<!-- bootbox js file -->
		<script type="text/javascript" src="${js}/bootbox.min.js"></script>
		
		<!-- Jquery Datatalbe -->
		<script type="text/javascript" src="${js}/jquery.dataTables.js"></script>
		
		<!-- Jquery Datable Bootstrap js-->
		<script type="text/javascript" src="${js}/dataTables.bootstrap4.js"></script>
		
		<!-- Jquery Validator js-->
		<script type="text/javascript" src="${js}/jquery.validate.js"></script>

		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>
		
		
		
		
		
	</div>
</body>

</html>
