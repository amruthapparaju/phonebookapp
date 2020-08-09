package com.miniproject.one.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PhoneExceptionHandler {
	
	
	@ExceptionHandler(value=PhoneBookApplicationExcepyion.class)
	public  String PhoneBookException() {
		
		return "error";
	}

}
