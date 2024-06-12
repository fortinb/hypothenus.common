package com.isoceles.hypothenus.events.event;

import org.springframework.context.ApplicationEvent;

public class HypothenusEvent<T> extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public HypothenusEvent(Object source) {
		super(source);
	}

}
