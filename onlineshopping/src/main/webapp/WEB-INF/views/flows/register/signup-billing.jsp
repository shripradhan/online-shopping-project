<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="../shared/flows-header.jsp"%>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<div class="container d-flex justify-content-center">

	<div class="card" style="width: 50rem;">

		<div class="card-header bg-primary text-white text-center">
			<h4 class="card-title">Billing Address</h4>
		</div>

		<div class="card-body">
			<div class="container-fluid">
				<form:form action="" method="POST"  modelAttribute="address" cssClass="">
					
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Address Line 1</label>
						<div class="col-sm-5">
							<form:input type="text" path="addressLineOne" class="form-control" id="inputEmail3" placeholder="Enter Address Line 1"/>
							<form:errors path="addressLineOne" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Address Line 2</label>
						<div class="col-sm-5">
							<form:input type="text" path="addressLineTwo" class="form-control" id="inputEmail3" placeholder="Enter Address Line 2"/>
						</div>
					</div>
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">City</label>
						<div class="col-sm-5">
							<form:input type="text" path="city" class="form-control" id="inputEmail3" placeholder="Enter City"/>
							<form:errors path="city" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Postal Code</label>
						<div class="col-sm-5">
							<form:input type="text" path="postalCode" class="form-control" id="inputEmail3" placeholder="Enter Postal Code"/>
							<form:errors path="postalCode" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">State</label>
						<div class="col-sm-5">
							<form:input type="text" path="state" class="form-control" id="inputEmail3" placeholder="Enter State"/>
							<form:errors path="state" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row  d-flex justify-content-center">
						<label for="inputEmail3" class="col-sm-3 col-form-label">Country</label>
						<div class="col-sm-5">
							<form:input type="text" path="country" class="form-control" id="inputEmail3" placeholder="Enter Country"/>
							<form:errors path="country" cssClass="help-block" element="em" />
						</div>
					</div>
					
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
							<!-- Submit Button for Moving Persional Details Page -->
								<button type="submit" class="btn btn-primary" name="_eventId_personal">
									<i class='fas fa-arrow-left' style='font-size:15px'></i>  &nbsp; Previous - Personal
								</button>
							
							<!-- Submit Button for Moving Persional Details Page -->
								<button type="submit" class="btn btn-primary" name="_eventId_confirm">
									Next - Confirm &nbsp; <i class='fas fa-arrow-right' style='font-size:15px'></i>
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
