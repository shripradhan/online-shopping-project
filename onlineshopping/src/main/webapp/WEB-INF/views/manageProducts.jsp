<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- <div class="container">

	<div class="row">
	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="card">
			
				<div class="card-heading bg-primary text-white">
				
					<h5>Product Management</h5>
				
				</div>
				
				<div class="card-body">
				
					Form Elementsdfd
				
				</div>
			
			</div>
		
		</div>
	
	</div>

</div> -->

<div class="container">

	<c:if test="${not empty msg}">
	
		<div class="col-xs-12">
		
			<div class="alert alert-success alert-dismissible">
			
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				
				<strong>Product Added Successfully...</strong>
			.
			</div>
		
		</div>
	</c:if>
	

	<div class="card">

		<div class="card-header bg-info text-white">

			<h3>Product Management</h3>

		</div>

		<div class="card-body">

			<!-- Form Elements -->


			<!-- <div class="form-horizontal">
    	
    		<div class="form-group">
    		
    			<label class="control-label col-md-4" for="name">Enter Product Name : </label>
    			<div class="col-md-8">
    			
					<input type="text" name="name" id="name" placeholder="Product Name" class="form-control"/>  
					  
					<em class="help-block">Please Enter Product Name</em> 			
    			</div>
    			
    		
    		</div>
    	
    	</div> -->
			<!-- <div class="my-container"> -->
		<form:form action="${contextRoot}/manage/products" method="POST" modelAttribute="newProduct" enctype="multipart/form-data">
				<div class="form-group row justify-content-center">
					<!-- <div class="col-sm-2"></div> -->
					<label for="name" class="col-sm-3 col-form-label">Product Name : </label>
					<div class="col-sm-4">
					
						<form:input type="text" path="name" id="name" class="form-control" placeholder="Enter Product Name"/>
						<form:errors path="name" cssClass="help-block" element="em"/>
						
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>
				
				<div class="form-group row justify-content-center">
					<!-- <div class="col-sm-2"></div> -->
					<label for="brand" class="col-sm-3 col-form-label">Brand Name : </label>
					<div class="col-sm-4">
					
						<form:input type="text" path="brand" id="brand" class="form-control" placeholder="Enter Brand Name"/>
						<form:errors path="brand" cssClass="help-block" element="em"/>
							
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>
				
				<div class="form-group row justify-content-center">
					<!-- <div class="col-sm-2"></div> -->
					<label for="description" class="col-sm-3 col-form-label">Description : </label>
					<div class="col-sm-4">
					
						<form:textarea  path="description" id="description" class="form-control" placeholder="Enter Description"/>
						<form:errors path="description" cssClass="help-block" element="em"/>
							
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>
				
				<div class="form-group row justify-content-center">
					<!-- <div class="col-sm-2"></div> -->
					<label for="unitPrice" class="col-sm-3 col-form-label">Product Unit Price : </label>
					<div class="col-sm-4">
					
						<form:input type="text"  path="unitPrice" id="unitPrice" class="form-control" placeholder="Enter Unit Price"/>
						<form:errors path="unitPrice" cssClass="help-block" element="em"/>
	
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>
				
				
				<div class="form-group row justify-content-center">
					<!-- <div class="col-sm-2"></div> -->
					<label for="quantity" class="col-sm-3 col-form-label">Quantity Available : </label>
					<div class="col-sm-4">
					
						<form:input type="number"  path="quantity" id="quantity" class="form-control" placeholder="Enter Quantity"/>
						<form:errors path="quantity" cssClass="help-block" element="em"/>
						
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>
				
				
				<!-- Product Image Uploading -->
				<div class="form-group row justify-content-center">
					<!-- <div class="col-sm-2"></div> -->
					<label for="imgFiles" class="col-sm-3 col-form-label">Select Photos : </label>
					<div class="col-sm-4">
					
						<input type="file"  name="imgFiles" id="imgFiles" multiple="multiple" class="form-control" placeholder="Select Photo's"/>
						<form:errors path="imgFiles" cssClass="help-block" element="em"/>
						
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>
				
				<div class="form-group row justify-content-center">
					<!-- <div class="col-sm-2"></div> -->
					<label for="categoryId" class="col-sm-3 col-form-label">Product Category : </label>
					<div class="col-sm-4">
					
						<form:select id="categoryId" path="categoryId" class="form-control select selectpicker" data-live-search="true">
							<form:options items="${categories}" itemLabel="name" itemValue="id"/>
						</form:select>
							
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>
				
				
				<div class="form-group row"></div>
				
				<div class="form-group row justify-content-center">
					<div class="col-sm-2"></div>
					<div class="col-md-8 justify-content-center">
						<input type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-primary" value="Save Product">
					
						<!-- Hidden Properties -->
						<form:hidden path="id"/>
						<form:hidden path="code"/>
						<form:hidden path="active"/>
						<form:hidden path="supplierId"/>
						<form:hidden path="purchases"/>
						<form:hidden path="views"/>
					</div>
					<!-- <div class="col-sm-2"></div> -->
				</div>

			</div>

		</form:form>
		<!-- </div> -->

	</div>

</div>