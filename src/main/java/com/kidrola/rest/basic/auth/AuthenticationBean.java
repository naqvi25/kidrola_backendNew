package com.kidrola.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({"http://localhost:4020","http://localhost:4021"})
@RestController
public class AuthenticationBean {
	
	private String message;
	
//	public AuthenticationBean(String message) {
//		this.message = message;
//	}
	
	public AuthenticationBean(String message) {
		this.message = message;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}
	
	public String getMessage(String message) {
		return message;
	}

	@Override
	public String toString() {
		return "AuthenticationBean [message=" + message + "]";
	}
}
