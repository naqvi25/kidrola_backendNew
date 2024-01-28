package com.kidrola.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({"http://localhost:4020","http://localhost:4021"})
@RestController
public class BasicAuthenticationController {
	@GetMapping(path = "/basicauth")
	public AuthenticationBean authBean()  {
		return new AuthenticationBean("You are authenticated");
	}
}
