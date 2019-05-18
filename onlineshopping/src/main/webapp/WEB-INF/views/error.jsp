<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Home-${title}</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
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
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home">Online Shop</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</nav>


		<!-- Page Content -->
		<div class="content">
			<div class="container">

				<div class="row">

					<div class="col-sm jumbotronCenter" >

						<%-- 	<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
							
							<blockquote>
							
								${errorDescription}
								
							</blockquote>
							
						</div> --%>


						<div class="jumbotron">
							<h1 class="display-4">${errorMsg}</h1>
							<c:if test="${errorTitle != null}">
								<p class="lead">${errorTitle}</p>
							</c:if>
							<hr class="my-4">
							<blockquote style="word-wrap:break-word">
							
								${errorDescription}
								
							</blockquote>

						</div>

					</div>

				</div>

			</div>

		</div>

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

	</div>
</body>

</html>
