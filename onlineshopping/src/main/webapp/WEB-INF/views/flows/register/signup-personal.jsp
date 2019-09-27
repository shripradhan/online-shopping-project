<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="../shared/flows-header.jsp"%>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<div class="container d-flex justify-content-center">

	<div class="card" style="width: 50rem;">

		<div class="card-header bg-primary text-white text-center">
			<h4 class="card-title">Persional Details</h4>
		</div>

		<div class="card-body">
			<div class="container">
				<form:form action="" method="POST"  modelAttribute="user" cssClass="" >
					
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">First Name</label>
						<div class="col-sm-5">
							<form:input type="text" path="firstName" class="form-control" id="inputEmail3" placeholder="Enter First Name"/>
							<form:errors path="firstName" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Last Name</label>
						<div class="col-sm-5">
							<form:input type="text" path="lastName" class="form-control" id="inputEmail3" placeholder="Enter Last Name"/>
							<form:errors path="lastName" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Email</label>
						<div class="col-sm-5">
							<form:input type="email" path="email" class="form-control" id="inputEmail3" placeholder="Enter Email"/>
							<form:errors path="email" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Contact Number</label>
						<div class="col-sm-5">
							<form:input type="text" path="contactNumber" class="form-control" id="inputEmail3" placeholder="Enter Contact Number"/>
							<form:errors path="contactNumber" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Password</label>
						<div class="col-sm-5">
							<form:input type="password" path="password" class="form-control" id="password" placeholder="XXXXXXX"/>
							<form:errors path="password" cssClass="help-block" element="em" />
						</div>
						<div>
							<input type="checkbox" id="passShowHide" title="Show Password">
						</div>
					</div>
					
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Confirm Password</label>
						<div class="col-sm-5">
							<form:input type="password" path="confirmPassword" class="form-control" id="confirmPassword" placeholder="Re-Enter Password"/>
							<form:errors path="confirmPassword" cssClass="help-block" element="em" />
						</div>
					</div>
					
					<!-- Profile Image Uploading -->
					<!-- <div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Select Profile Photo :</label>
						<div class="col-sm-5">
							<input type="file"  name="profileImgFile" id="profileImgFile"  class="form-control" placeholder="Select Profile Photo"/>
							
						</div>
					</div> -->
					
					
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Role</label>
						<div class="col-sm-5">
						
        					<div class="form-check-inline">
						        <form:radiobutton path="role" class="form-check-input" id="user" value="USER" checked="checked"/>User
    						</div>
    						
						    <div class="form-check-inline">
						        <form:radiobutton path="role" class="form-check-input" id="supplier"  value="SUPPLIER"/>Supplier
						    </div>
      						
    					</div>
					</div>
					
					<!-- <fieldset class="form-group">
						<div class="row">
							<legend class="col-form-label col-sm-2 pt-0">Radios</legend>
							<div class="col-sm-10">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gridRadios"
										id="gridRadios1" value="option1" checked> <label
										class="form-check-label" for="gridRadios1"> First
										radio </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gridRadios"
										id="gridRadios2" value="option2"> <label
										class="form-check-label" for="gridRadios2"> Second
										radio </label>
								</div>
								<div class="form-check disabled">
									<input class="form-check-input" type="radio" name="gridRadios"
										id="gridRadios3" value="option3" disabled> <label
										class="form-check-label" for="gridRadios3"> Third
										disabled radio </label>
								</div>
							</div>
						</div>
					</fieldset> -->
					
					<!-- <div class="form-group row">
						<div class="col-sm-2">Checkbox</div>
						<div class="col-sm-10">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="gridCheck1">
								<label class="form-check-label" for="gridCheck1">
									Example checkbox </label>
							</div>
						</div>
					</div> -->

					<div class="form-group row "></div>
					
					<div class="form-group row d-flex justify-content-center">
						<div class="col-sm-10 text-center">
							<button type="submit" class="btn btn-primary" name="_eventId_billing">
								Next - Billing<!-- <span class="glyphicon ghyphicon-chevron-right"></span> --> &nbsp; <i class='fas fa-arrow-right' style='font-size:15px'></i>
							</button>
						</div>
					</div>
					


				</form:form>
			</div>
		</div>
		<!-- <div class="card-footer">
		</div> -->
	</div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>
