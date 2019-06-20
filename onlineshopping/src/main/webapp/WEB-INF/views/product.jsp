<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shree.shoppingbackend.dto.Product" %>

<%@ page import="com.shree.shoppingbackend.dto.ProductImage" %>

<style>
	
	.imgStyle{
		height:80px;
		width: 80px;
		border: 3px solid white; 
	}
</style>
<div class="container">
	
	<!-- Breadcrumb -->
	<div class="row">
		
		<div class="col-xs-12">
		
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				 <li class="breadcrumb-item active"><a href="${contextRoot}/show/all/products">All Products</a></li>
				 <li class="breadcrumb-item active">${product.name}</li>
			</ol>
			
		</div>
		
	</div>
	
	<div class="row">
		
		
		<!-- display the product image -->
		<%-- <div class="col-xs-12 col-sm-4">
			
			<c:forEach items="${product.productImages}" var="img">
			
			<div class="thumbnail">
			
				<img src="${images}/${img.imgName}.jpg" class="img img-responsive" align="left" width="100" height="70"/>
			
			</div>
			
			</c:forEach>
		
		</div> --%>
	<div class="col-xs-12 col-sm-4">
		<c:forEach items="${product.productImages}" var="img" varStatus="loop">
			<c:if test="${loop.index == 0}">
				<img id="mainImage" height="500" width="350" style="border: 3px solid white" src="${images}/${img.imgName}.jpg" >
				<br/>
				<br/>
			</c:if>
		</c:forEach>
		<c:forEach items="${product.productImages}" var="img" varStatus="loop">
			<span id="divContainer">
				<img id="mainImage" class="imgStyle" src="${images}/${img.imgName}.jpg" >
			</span>
		</c:forEach>
	</div> 
		
		

		
		<!-- display the product description -->
		<div class="col-xs-12 col-sm-8">
			
			<h3>${product.name }</h3>
			<hr/>
			
			<p>${product.description }</p>
			<hr/>
			
			<h4>Price : <strong> &#8377; ${product.unitPrice} /-</strong></h4>
			<hr/>
			
			<c:choose>
			
				<c:when test="${product.quantity < 1}">
					<h6>Quantity Available :<span style="color:red">  Out Of Stock !</span>  | People's Views : ${product.views}</h6>
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a>
				</c:when>
				
				<c:otherwise>
					<span><h6>Quantity Available : ${product.quantity}    |    People's Views : ${product.views}</h6></span>
					<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
				</c:otherwise>
			
			</c:choose>
			
			<%-- <span><h6>Quantity Available : ${product.quantity} | People's Views : ${product.views}</h6></span> --%>
			
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">All Products</a>
			
		</div>
		
	</div>
	
</div>