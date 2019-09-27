$(function(){
	
		//solving active menu problem
		switch(menu){
			case  'About Us':
				$('#about').addClass('active');
				break;
			case  'Contact Us':
				$('#contact').addClass('active');
				break;
			case 'All Products' : 
				$('#viewProducts').addClass('active');
				break;
			case 'Manage Products' : 
				$('#manageProducts').addClass('active');
			case 'User Cart' : 
				$('#login').addClass('active');
			default :
				if(menu == 'Home')
					$('#home').addClass('active');
					break;
				$('#viewProducts').addClass('active');
				$('#a_'+menu).addClass('active');
				break;
	}	
		
		
	$('[data-toggle="tooltip"]').tooltip();
	
	 $('#passShowHide').tooltip();

	
	$('#passShowHide').click(function(){
		$('#password').attr('type',$(this).is(':checked') ? 'text' : 'password');
	});
	
	

	
	
	var $table = $('#productListTable');
	//execute the below code only where we have this table
	
	

	if($table.length){
		//console.log('Inside the Table');
		
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products'
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}
		
		$table.DataTable({
		
			lengthMenu : [[3,5,10,-1],['3 Record','5 Record', '10 Record', 'All Record']],
			pageLength : 5,
			ajax : {
				'url' : jsonUrl,
				'dataSrc' : '',
			},
			columns : [
				
				{
					//href="/w3images/lights.jpg" target="_blank"
					data : 'productImages.0.imgName',
					bSortable : false,
					mRender : function(data, type, row){
						return '<a href="'+window.contextRoot+'/resources/images/product_images/'+data+'.jpg" target="_blank" ><img src="'+window.contextRoot+'/resources/images/product_images/'+data+'.jpg" class="dataTableImg"/></a>';
					},
					
				},
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row){
						return "&#8377; " + data;
					}
				},
				{
					data : 'quantity',
					mRender : function(data, type, row){
						if(row.quantity < 1){
							return '<span style="color:red"> Out Of Stock !</span>';
						}
						return data;
					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row){
						var strButtons = '';
					
						strButtons += '<a href="' + window.contextRoot + '/show/'+ data +'/product" class="btn btn-primary" data-toggle="tooltip" title="View Product"><span class="glyphicon glyphicon-eye-open" ></span></a> &#160;';
						
						if(userRole == 'ADMIN'){
							strButtons += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>'
						}
						else{
							if(row.quantity < 1){
								strButtons += '<a  href="javascript:void(0)" class="btn btn-success disabled" data-toggle="tooltip" title="Add to Cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
							}else{
								strButtons += '<a  href="' + window.contextRoot + '/cart/add/'+data+'/product" class="btn btn-success" data-toggle="tooltip" title="Add to Cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
							}
						}
						return strButtons;
					}
				},
			]
			
		});
	}
	
	//dismissing the alert after 4 seconds
	var $alert = $('.alert');
	
	if($alert.length){
		
		setTimeout(function(){
			
			$alert.fadeOut('slow');
			
		},4000);
		
	}
	
	//Displaying the image gallary in single product image view
	console.log(window.productsImages);
	
	$('#divContainer img').on({
		mouseover : function(){
			$(this).css({
				'cursor' :  'pointer',
				'border-color' : 'pink'
			});
		},
		mouseout : function(){
			$(this).css({
				'cursor' : 'default',
				'border-color' : 'white'
			});
		},
		click : function(){
			var imageUrl = $(this).attr('src');
			$('#mainImage').fadeOut(200,function(){
				$(this).attr('src',imageUrl);
			}).fadeIn(200);
		}
		
	});
	
	
	
	//to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0){
		//set the token header for the ajax request
		$(document).ajaxSend(function(event,xhr,options){
			xhr.setRequestHeader(header,token)
		});
	}
	
	//code for password field checkbox event
	$('#passShowHide').change(function() {
        if($(this).is(":checked")) {
            $(this).attr("data-original-title", "Hide Password");
        }else{
        	$(this).attr("data-original-title", "Show Password");
        }
    	
    });
	
	
	
	
	//Jquery Data Table for Admin
	//-----------------------------------------------------------
	
	
	var $adminProductsTable = $('#adminProductTable');
	//execute the below code only where we have this table
	

	if($adminProductsTable.length){
		//console.log('Inside the Table');
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		
		$adminProductsTable.DataTable({
		
			lengthMenu : [[10, 30, 50, -1],['10 Records','30 Records', '50 Records', "All Record"]],
			pageLength : 10,
			ajax : {
				'url' : jsonUrl,
				'dataSrc' : '',
			},
			columns : [
				
				{
					data : 'id'
				},
				
				{
					//href="/w3images/lights.jpg" target="_blank"
					data : 'productImages.0.imgName',
					bSortable : false,
					mRender : function(data, type, row){
						return '<a href="'+window.contextRoot+'/resources/images/product_images/'+data+'.jpg" target="_blank" ><img src="'+window.contextRoot+'/resources/images/product_images/'+data+'.jpg" class="adminDataTableImg"/></a>';
					},
					
				},
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'quantity',
					mRender : function(data, type, row){
						if(data < 1){
							return '<span style="color:red"> Out Of Stock !</span>';
						}
						return data;
					}
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row){
						return "&#8377; " + data;
					}
				},
				
				{
					data : 'active',
					bSortable : false,
					mRender : function(data, type, row){
						var strToggleButton = '';
						strToggleButton += '<label class="switch">';
						if(data){
							strToggleButton += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
						}else{
							strToggleButton += '<input type="checkbox" value="'+row.id+'"/>';
						}
						strToggleButton += '<div class="slider"></div>';
						strToggleButton += '</label>';
							
						return strToggleButton;
					}
				},
				
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row){
						return '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">'+
									'<span class="glyphicon glyphicon-pencil"></span>'+
								'</a>';
					}
				},
			],
			
			initComplete : function(){
				
				var api = this.api();
				
				api.$('.switch input[type="checkbox"]').on('change',function(){
					
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked) ? 	'You want to Activate the Product..?' :
											'You want to Deactivate the Product..?';
					
					var value = checkbox.prop('value');
					
					bootbox.confirm({
						size : 'medium',
						title : 'Product Activation & Deactivation',
						message : dMsg,
						buttons: {
					        confirm: {
					            label: '<i class="glyphicon glyphicon-ok"></i>   Yes',
					            className: 'btn-success'
					        },
					        cancel: {
					            label: '<i class="glyphicon glyphicon-remove"></i>   No',
					            className: 'btn-danger'
					        }
					    },
						callback :  function(confirmed){
							
							if(confirmed){
								console.log(value);
								
								var activationUrl = window.contextRoot+'/manage/product/' + value + '/activation';
								
								$.post(activationUrl,function(data){
									bootbox.alert({
										size : 'medium',
										title : 'Information',
										message : data,
										buttons: {
									        ok: {
									            label: '<i class="glyphicon glyphicon-ok"></i>   Ok',
									            className: 'btn-success'
									        },
									    },
									});
									
								});
								
								
							}
							else{
								checkbox.prop('checked', !checked);
							}
						},
					})
					
				});
				
			}
			
		});
	}
	
	//------------------------------------------------------------
	
	
	//validation code for category form
	
	var $categoryForm = $('#categoryForm');
	
	$categoryForm.validate({
		
		rules : {
			
			name : {
				required : true,
				minlength : 2,
			},
	
			description : {
				required : true,
			}
		},
		
		messages : {
			
			name : {
				required : "Please Enter the category Name..!",
				minlength : "Category name should not be less than 2 character",
			},
	
			description : {
				required : "Please Enter the category Description..!",
			}
		},
		
		errorElement : 'em',
		
		errorPlacement : function(error,element){
			//add the class of help-block
			error.addClass('help-block');
			
			//add error element after the input
			error.insertAfter(element);
		}
		
	});
	
	
	//-----------------------------
	
	//validation code for Login form
	
	var $loginform = $('#loginform');
	
	$loginform.validate({
		
		rules : {
			
			userEmail : {
				required : true,
				email : true,
			},
	
			userPassword : {
				required : true,
			}
		},
		
		messages : {
			
			userEmail : {
				required : "Please Enter the Username..!",
				email : "Please enter valid email address",
			},
	
			userPassword : {
				required : "Please enter the Password",
			}
		},
		
		errorElement : 'em',
		
		errorPlacement : function(error,element){
			//add the class of help-block
			error.addClass('help-block');
			
			//add error element after the input
			error.insertAfter(element);
		}
		
	});
	
	//---------------------------------------------------------
	
	//handling the event of refresh cart button
	$('button[name="refreshCart"]').click(function(){

		//fetch the cartLine id
		let cartLineId = $(this).attr('value');
		let countElement = $('#cart_'+ cartLineId);
		
		let originalCount = $(countElement).attr('value');
		let currentCount = $(countElement).val();
		
		
		if(originalCount != currentCount ){
			
			//restrict to count must not be less than 1 and greater than 3
			if(currentCount < 1 || currentCount > 3){
				//revert back to original count
				countElement.val(originalCount);
				bootbox.alert({
					size : 'medium',
					title : 'Error',
					message : 'Product count should be minimum 1 or maxmum 3 !'
				});
			}else{
				
				//create request url to forwarding the request to controller
				var updateUrl = window.contextRoot + '/cart/' + cartLineId +'/update?productCount=' +currentCount
				
				window.location.href = updateUrl;
			}
		
		}
		
		
	});
	
	$('#cart_2502').change(function(){
		alert('hi there');
	});

	
		
});