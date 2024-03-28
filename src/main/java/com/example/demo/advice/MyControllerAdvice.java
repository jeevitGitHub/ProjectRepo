package com.example.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.custom.exception.BusinessException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusinessException(BusinessException be) {
		return new ResponseEntity<String>("Bsuiness exception occured", HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementExcep(NoSuchElementException ne){
		return new ResponseEntity<String>("No Such Element Exception", HttpStatus.NOT_FOUND);
	}
}
