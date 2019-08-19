<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
      <a class="navbar-brand text-primary" href="${contextRoot}/home">Online Shop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive"> 
        <ul class="navbar-nav mr-auto"> <!-- mr-auto for right navbar and ml-auto for left navbar-->
          <li class="nav-item" id="home">
            <a class="nav-link text-primary" href="${contextRoot}/home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
           <li class="nav-item" id="viewProducts">
            <a class="nav-link text-primary" href="${contextRoot}/show/all/products">View Products</a>
          </li>
          
           <li class="nav-item" id="manageProducts">
            <a class="nav-link text-primary" href="${contextRoot}/manage/products">Manage Products</a>
          </li>
          
          <li class="nav-item" id="about">
            <a class="nav-link text-primary" href="${contextRoot}/about">About</a>
          </li>
          
          <li class="nav-item" id="contact">
            <a class="nav-link text-primary" href="${contextRoot}/contact">Contact</a>
          </li>
          
        </ul>
        
        <ul class="navbar-nav ml-auto"> <!-- mr-auto for right navbar and ml-auto for left navbar-->
          
          <li class="nav-item" id="register">
            <a class="nav-link text-primary" href="${contextRoot}/register">Sign Up</a>
          </li>
          
          <li class="nav-item" id="login">
            <a class="nav-link text-primary" href="${contextRoot}/login">Login</a>
          </li>
          
           <li class="nav-item dropdown" id="login">
            <a class="nav-link text-primary dropdown-toggle" id="dropdownMenu1" href="javascript:void(0)" data-toggle="dropdown">
		    <c:choose>
			    <c:when test="${not empty userModel.fullName}">
			        ${userModel.fullName}
			    </c:when>
		    <c:otherwise>
		        Account
		    </c:otherwise>
</c:choose>
            </a>
            
            <ul class="dropdown-menu">
            	<!-- <li class="dropdown-header">User Info</li> -->
            	<li class="dropdown-item">
					<a href="${contextRoot}/cart" style="">
						<span class="glyphicon glyphicon-shopping-cart"></span>
						<span class="badge">${userModel.cart.cartLines}</span>
						: &nbsp; &#8377; ${userModel.cart.grandTotal}
					</a>
				</li>
				
				  <div class="dropdown-divider"></div>
				
            	<li class="dropdown-item">
					<a href="${contextRoot}/logout">Logout</a>
				</li>
            </ul>
          </li>
          
        </ul>
        
      </div>
    </div>
  </nav>