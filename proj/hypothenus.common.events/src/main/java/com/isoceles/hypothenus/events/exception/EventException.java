package com.isoceles.hypothenus.events.exception;

import lombok.Getter;

@Getter
public class EventException extends Exception {
		
	//public static final String EVENT_ERROR = "404";
	
	private static final long serialVersionUID = 1L;
	private String code;
	
    public EventException(String code, String message) {
    	super(message);
    	this.code = code;
    } 

}
