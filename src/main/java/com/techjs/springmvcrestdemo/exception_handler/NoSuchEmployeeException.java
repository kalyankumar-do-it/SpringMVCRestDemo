package com.techjs.springmvcrestdemo.exception_handler;


public class NoSuchEmployeeException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1240928048296325258L;

	public NoSuchEmployeeException(String message) 
	{
        super(message);
    }
}
