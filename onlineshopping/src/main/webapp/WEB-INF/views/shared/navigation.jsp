
 <nav class="navbar navbar-expand-lg navbar-light bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand text-white" href="${contextRoot}/home">Online Shop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive"> 
        <ul class="navbar-nav mr-auto"> <!-- mr-auto for right navbar and ml-auto for left navbar-->
          <li class="nav-item" id="home">
            <a class="nav-link text-white" href="${contextRoot}/home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
           <li class="nav-item" id="viewProducts">
            <a class="nav-link text-white" href="${contextRoot}/show/all/products">View Products</a>
          </li>
          
           <li class="nav-item" id="manageProducts">
            <a class="nav-link text-white" href="${contextRoot}/manage/products">Manage Products</a>
          </li>
          
          <li class="nav-item" id="about">
            <a class="nav-link text-white" href="${contextRoot}/about">About</a>
          </li>
          
          <li class="nav-item" id="contact">
            <a class="nav-link text-white" href="${contextRoot}/contact">Contact</a>
          </li>
          
        </ul>
        
        <ul class="navbar-nav ml-auto"> <!-- mr-auto for right navbar and ml-auto for left navbar-->
          
          <li class="nav-item" id="register">
            <a class="nav-link text-white" href="${contextRoot}/register">Sign Up</a>
          </li>
          
          <li class="nav-item" id="login">
            <a class="nav-link text-white" href="${contextRoot}/login">Login</a>
          </li>
          
        </ul>
        
      </div>
    </div>
  </nav>