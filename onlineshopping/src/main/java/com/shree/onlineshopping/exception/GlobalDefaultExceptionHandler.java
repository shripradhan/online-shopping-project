package com.shree.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handerNoHandlerFoundException() {
		ModelAndView mav = new ModelAndView("error");
		
		mav.addObject("errorMsg","404 - Page Not Found ! ");
		
		mav.addObject("errorTitle","The Page is not constructed ! ");
		
		mav.addObject("errorDescription","The page you are looking for is not available now ! ");
		
		mav.addObject("title", "404 Error Page");
		
		return mav;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handerProductNotFoundException() {
		ModelAndView mav = new ModelAndView("error");
		
		mav.addObject("errorMsg","Product not Available");
		
		mav.addObject("errorTitle","Sorry Product Not Found ! ");
		
		mav.addObject("errorDescription","The Product you are looking for is not available right now ! ");
		
		mav.addObject("title", "Product Unavailable");
		
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handerException(Exception ex) {
		ModelAndView mav = new ModelAndView("error");
		
		mav.addObject("errorMsg","Contact You Administrator");
		
		//mav.addObject("errorTitle","Sorry Product Not Found ! ");
		
		/*
		 * only for debugging our application
		 * 
		*/
		
		StringWriter sw =  new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mav.addObject("errorDescription",sw.toString());
		
		mav.addObject("title", "Error");
		
		return mav;
	}
}
