
<div class="container">

	<div class="row">

		<!-- to display category side bar  -->
		<div class="col-lg-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>


		<!-- to display actual products -->
		<div class="col-lg-9">

			<!-- Adding breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">

						<script type="text/javascript">
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProduct == true}">

						<script type="text/javascript">
							window.categoryId = ${category.id};
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>

				</div>

			</div>

			<!-- <div class="row"> -->

			<!-- <div class="col-xs-12"> -->

			<table id="productListTable"
				class="table table-striped">
				<thead>
					<tr>
						<th></th>
						<th>Name</th>
						<th>Brand</th>
						<th>Price</th>
						<th>Qty Available</th>
						<th></th>
					</tr>
				</thead>
			</table>

			<!-- </div> -->

			<!-- </div> -->
		</div>

	</div>
</div>
