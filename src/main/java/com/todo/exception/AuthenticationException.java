package com.todo.exception;

public class AuthenticationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2804246317103877851L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}