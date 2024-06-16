package com.isoceles.hypothenus.events.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class HypothenusEvent<T> extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private T entity;
	private OperationEnum operation;

	public HypothenusEvent(Object source, T entity, OperationEnum operation) {
		super(source);

		this.entity = entity;
		this.operation = operation;
	}
}
