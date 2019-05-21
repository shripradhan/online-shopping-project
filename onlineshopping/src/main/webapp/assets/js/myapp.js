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
			default :
				if(menu == 'Home')
					$('#home').addClass('active');
					break;
				$('#viewProducts').addClass('active');
				$('#a_'+menu).addClass('active');
				break;
	}	
		
		
	$('[data-toggle="tooltip"]').tooltip();   
	
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
		
			lengthMenu : [[3,5,10,-1],['3 Record','5 Record', '10 Record', "All Record"]],
			pageLength : 5,
			ajax : {
				'url' : jsonUrl,
				'dataSrc' : '',
			},
			columns : [
				
				{
					//href="/w3images/lights.jpg" target="_blank"
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row){
						return '<a href="'+window.contextRoot+'/resources/images/'+data+'.jpg" target="_blank" ><img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/></a>';
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
						
						if(row.quantity < 1){
							strButtons += '<a  href="javascript:void(0)" class="btn btn-success disabled" data-toggle="tooltip" title="Add to Cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
						}else{
							strButtons += '<a  href="' + window.contextRoot + '/cart/add/'+data+'/product" class="btn btn-success" data-toggle="tooltip" title="Add to Cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
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
	
		
});