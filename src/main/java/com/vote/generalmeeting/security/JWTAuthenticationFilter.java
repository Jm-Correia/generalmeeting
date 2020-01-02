package com.vote.generalmeeting.security;


import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vote.generalmeeting.DTO.CredenciasDTO;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)	{
	Authentication auth = null;
		try {
			CredenciasDTO cred = new ObjectMapper()
					.readValue(req.getInputStream(), CredenciasDTO.class);
			UsernamePasswordAuthenticationToken authToken = new 
					UsernamePasswordAuthenticationToken(cred.getLogin(), cred.getSenha());
			
		  auth = authenticationManager.authenticate(authToken);
		}catch (IOException io) {
			throw new RuntimeException(io);
		}
		return auth;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((UserSS)authResult.getPrincipal()).getUsername();
		String token = jwtUtil.genetareToken(username);
		response.addHeader("Authorization", "Bearer " + token);
	}
	
}
