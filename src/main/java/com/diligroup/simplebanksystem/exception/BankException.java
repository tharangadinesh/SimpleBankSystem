package com.diligroup.simplebanksystem.exception;

import org.springframework.http.HttpStatus;

public class BankException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	private final HttpStatus status;
	private final  Exception exception;

	public BankException(String message, HttpStatus status) {
		super(message);
		this.exception = new Exception();
		this.message = message;
		this.status = status;
	}

	public BankException(String message, Exception exception) {
		super(message);
		this.message = message;
		this.exception = exception;
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Exception getException() {
		return exception;
	}

}
