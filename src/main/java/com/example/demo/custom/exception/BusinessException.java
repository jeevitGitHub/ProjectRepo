package com.example.demo.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMEssage;
	
	public BusinessException() {
		
	}
		
	public BusinessException(String errorCode, String errorMEssage) {
		super();
		this.errorCode = errorCode;
		this.errorMEssage = errorMEssage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMEssage() {
		return errorMEssage;
	}
	public void setErrorMEssage(String errorMEssage) {
		this.errorMEssage = errorMEssage;
	}

}
