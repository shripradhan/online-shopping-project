package com.shree.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shree.onlineshopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;

	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(value = "result", required = false) String result) {
		
		ModelAndView mav = new ModelAndView("page");
		
		if(result != null) {
			
			switch(result) {
			
			case "updated" :
				mav.addObject("message","Cart Product has been updated Successfully!");
				break;
			case "deleted" :
				mav.addObject("message", "Cart Product has been removed Successfully!");
				break;
			case "added" :
				mav.addObject("message", "Product has been added to Cart Successfully!");
				break;
			case "maximum" :
				mav.addObject("message", "Cart Line has reached to maximum count!");
				break;
			case "unavailable" :
				mav.addObject("message", "Product quantity is not available!");
				break;
			case "error" :
				mav.addObject("message", "Something went wrong!");
				break;
			}
			
			
		}
		
		mav.addObject("title","User Cart");
		mav.addObject("userClickShowCart", true);
		mav.addObject("cartLines", cartService.getCartLine());
		
		return mav;
	}
	
	/*@RequestMapping(value = "/getCartLine",method = RequestMethod.GET)
	@ResponseBody
	public List<CartLine> getCartLine(){
		return cartService.getCartLine();
	}*/
	
	@RequestMapping(value = "/{cartLineId}/update", method = RequestMethod.GET)
	public String refreshCart(@PathVariable("cartLineId") int cartLineId,@RequestParam(name = "productCount") int productCount) {
		
		String response = cartService.manageCartLine(cartLineId, productCount);
		
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping(value = "/{cartLineId}/delete", method = RequestMethod.GET)
	public String refreshCart(@PathVariable("cartLineId") int cartLineId) {
		
		String response = cartService.deleteCartLine(cartLineId);
		
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping(value = "/add/{productId}/product", method = RequestMethod.GET)
	public String addCartLine(@PathVariable("productId") int productId) {
		
		String response = cartService.addCartLine(productId);
		
		return "redirect:/cart/show?"+response;
	}
	
	
}
