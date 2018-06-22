package com.abhi.atm.publisherSubscriber;

import org.springframework.context.ApplicationEvent;

/**
 * @author Abhishek Patel M N Jan 17, 2018
 */
public class AtmEvent extends ApplicationEvent {

	private String message = "Message from custom event..";

	public AtmEvent(Object source) {
		super(source);
	}

	public String getMessage() {
		return message;
	}
}
