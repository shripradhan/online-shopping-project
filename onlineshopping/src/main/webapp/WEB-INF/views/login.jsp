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
	
		<!-- Navigation -->
		<%@ include file="./shared/login_navigation.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<c:if test="${not empty errorMsg}">
					<div class="row d-flex justify-content-center">
						<div class="col-md-offset-3 col-md-6 ">
							<div class="alert alert-danger">
								<center>${errorMsg}</center>
							</div>
						</div>					
					</div>
				</c:if>
			</div>
			
			<%-- <div id="login">
				<div class="container">
					<h3 class="text-center text-info">Login Form</h3>
					<div id="login-row"
						class="row justify-content-center align-items-center">
						<div id="login-column" class="col-md-6">
							<div id="login-box" class="col-md-12">
								<form id="loginform" class="form" action="${contextRoot}/login" method="POST">
									<br><br>
									<div class="form-group">
										<label for="username" class="text-info">Username:</label><br>
										<input type="text" name="userEmail" id="username" class="form-control">
										
									</div>
									<div class="form-group">
										<label for="password" class="text-info">Password:</label><br>
										<input type="text" name="userPassword" id="password"
											class="form-control">
									</div>
									<div class="form-group">
										<label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me"
												type="checkbox"></span></label><br> 
										<input type="submit" name="submit" class="btn btn-info btn-md" value="Login">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									</div>
									<div id="register-link" class="text-right">
										<a href="#" class="text-info">Register here</a>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> --%>
		
		<div class="container d-flex align-items-center flex-column justify-content-center h-100" >
			<div class="card" style="width:500px">
  				<div class="card-header text-center bg-info text-white" >
    				Login
  				</div>
  			<div class="card-body">
  			<!--  <h5 class="card-title">Special title treatment</h5>-->
    			<form id="loginform" class="form" action="${contextRoot}/login" method="POST">
			  		<div class="form-group row">
			        	<div class="col-sm-1"></div>
			        	<label for="inputPassword" class="col-sm-3 col-form-label">Email</label>
			    		<div class="col-sm-7">
			      			<input type="email" name="userEmail" class="form-control" id="inputPassword" placeholder="Enter email as Username">
			                <div class="col-sm-1"></div>
			    		</div>
			  		</div>
			  		
			  		<div class="form-group row">
			        <div class="col-sm-1"></div>
			    		<label for="inputPassword" class="col-sm-3 col-form-label">Password</label>
			    		<div class="col-sm-7">
			      			<input type="password" name="userPassword" class="form-control" id="inputPassword" placeholder="Password">
			    		</div>
			            <div class="col-sm-1"></div>
			  		</div>
			  		
			  		<div class="form-group row">
			  			<div class="col-sm-5"></div>
						<!-- <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me"
												type="checkbox"></span></label><br>  -->
							<input type="submit" name="submit" class="btn btn-info btn-sm" value="Login">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<div class="col-sm-7"></div>	
					</div>
					<hr>
			  		<div id="register-link" class="text-right">
						New User -<a href="#" class="text-info">Register here</a>
					</div>
				</form>
			</div>
		</div>
	</div>
		
		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- bootbox js file -->
		<script type="text/javascript" src="${js}/bootbox.min.js"></script>


		<!-- Jquery Validator js-->
		<script type="text/javascript" src="${js}/jquery.validate.js"></script>

		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>





	</div>
</body>

</html>
