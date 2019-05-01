<div class="container">

	<div class="row">

		<!-- to display category side bar  -->
		<div class="col-xs-9 col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>


		<!-- to display actual products -->
		<div class="col-xs-3 col-md-9">
			<div class="row">
				<!-- Adding breadcrumb component -->
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProduct == true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>

				</div>

			</div>
		</div>

	</div>
</div>