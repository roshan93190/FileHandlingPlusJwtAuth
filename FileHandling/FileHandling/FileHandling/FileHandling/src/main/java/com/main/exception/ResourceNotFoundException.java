package com.main.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

	private String msg;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
