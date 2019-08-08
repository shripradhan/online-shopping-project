
<%@ include file="../shared/flows-header.jsp"%>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<div class="container">

	<div class="row">

		<div class="col-sm-6" style="height: 80%">

			<div class="card" >

				<div class="card-header bg-primary text-white text-center">
					<h4 class="card-title">Persional Info</h4>
				</div>

				<div class="card-body">
				
					<div class="text-center">
						
						<h4>${registerModel.user.firstName} &nbsp;&nbsp;  ${registerModel.user.lastName}</h4>
						
						<h5>Emil : ${registerModel.user.email}</h5>
						
						<h5>Contact No. :   ${registerModel.user.contactNumber}</h5>
						
						<h5>Role :   ${registerModel.user.role}</h5>
						
					</div>	
					
				</div>

				<div class="card-footer">
					<div class="form-group row">
						<div class="col-sm-10">
							<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-info" style="width: 80px;height: 40px"><strong>Edit</strong></a>
						</div>
					</div>
				</div>

			</div>

		</div>


		<div class="col-sm-6">

			<div class="card">

				<div class="card-header bg-primary text-white text-center">
					<h4 class="card-title">Billing Address</h4>
				</div>

				<div class="card-body">
					<div class="text-center">
						
						<h4>${registerModel.address.addressLineOne} </h4>
						
						<h4>${registerModel.address.addressLineTwo} </h4>
						
						<h4>${registerModel.address.city} - ${registerModel.address.postalCode}</h4>
						
						<h4>${registerModel.address.state} - ${registerModel.address.country} </h4>
						
					</div>				
				</div>

				<div class="card-footer">
					<div class="form-group row">
						<div class="col-sm-10">
							<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-info" style="width: 80px;height: 40px"><strong>Edit</strong></a>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>
	<br/><br/><br/><br/>
	<div class="row">
	
		<div class="col-sm-12 text-center">
			<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-success">Confirm</a>
		</div>
	
	</div>


</div>

<%@ include file="../shared/flows-footer.jsp"%>
