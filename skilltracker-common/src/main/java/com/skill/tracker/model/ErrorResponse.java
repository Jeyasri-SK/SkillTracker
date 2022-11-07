package com.skill.tracker.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ErrorResponse implements Serializable{
	
	private static final long serialVersionUID = 8564822694419337953L;
	
	private HttpStatus errorCode;
	private String errorMsg;	
	
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(HttpStatus badRequest) {
		this.errorCode = badRequest;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}