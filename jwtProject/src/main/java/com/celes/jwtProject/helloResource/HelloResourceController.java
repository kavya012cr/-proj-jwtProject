package com.celes.jwtProject.helloResource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celes.jwtProject.models.AuthenticationRequest;
import com.celes.jwtProject.models.AuthenticationResponse;
import com.celes.jwtProject.service.MyUserDetailsService;
import com.celes.jwtProject.util.JwtUtil;

@RestController
public class HelloResourceController {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private MyUserDetailsService userdetailsService;
	
	@Autowired
	private AuthenticationManager authenticationmanager;

	@RequestMapping("/login")
	public String hello() {
		return "Logged In ";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPass()));

		} catch (BadCredentialsException e) {
			throw new Exception("incorrect username or password", e);
		}
		final UserDetails userDetails = userdetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
