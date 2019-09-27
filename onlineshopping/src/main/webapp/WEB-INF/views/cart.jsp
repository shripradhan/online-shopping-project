<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
---- Include the above in your HEAD tag --------

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"> -->
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>


       
<div class="container">

	<c:if test="${not empty message}">
		<div class="alert alert-success">
			<h4 class="text-center">
				${message}
			</h4>
		</div>
	</c:if>

	<c:choose>
    	<c:when test="${not empty cartLines}">
				<table id="cart" class="table table-hover">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cartLine" items="${cartLines}">
							<tr>
								<td data-th="Product">
									<div class="row">
										<div class="col-sm-3"><img src="${product_images}/${cartLine.product.productImages[0].imgName}.jpg" alt="${cartLine.product.name}" style="width: 100px;height: 100px;" class="img-responsive"/></div>
										<div class="col-sm-9">
											<h4 class="nomargin">${cartLine.product.name}
												<c:if test="${cartLine.available == false }">
													<strong class="unavailable">(NOT AVAILABLE)</strong>
												</c:if>
											</h4>
											<p>Brand : ${cartLine.product.brand}</p>
											<p>Description : ${cartLine.product.description}</p>
										</div>
									</div>
								</td>
								<td data-th="Price">&#8377; ${cartLine.buyingPrice}</td>
								<td data-th="Quantity">
									<input type="number" id="cart_${cartLine.id}" min="1" max="3" class="form-control text-center" value="${cartLine.productCount}">
								</td>
								<td data-th="Subtotal" class="text-center">&#8377; ${cartLine.total}</td>
								<td class="actions" data-th="">
									<button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-refresh"></span></button>
									<a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>								
								</td>
							</tr>
						</c:forEach>
							
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total &#8377; ${userModel.cart.grandTotal}</strong></td>
						</tr>
						<tr>
							<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><i class='fas fa-arrow-left' style='font-size:15px'></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total &#8377; ${userModel.cart.grandTotal}</strong></td>
							<td><a href="#" class="btn btn-success btn-width1">Checkout <i class='fas fa-arrow-right' style='font-size:15px'></i></a></td>
						</tr>
					</tfoot>
				</table>
		</div>
       
    </c:when>
    <c:otherwise>
		<div class="container">
			 <div class="jumbotron text-center">
			    <h1>Your Cart is Empty!</h1>  
			    <i class="fas fa-abacus"></i>
			</div>
		</div>
    </c:otherwise>
</c:choose>



