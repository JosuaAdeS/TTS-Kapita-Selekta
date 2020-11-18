/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.configuration;

import com.example.Framework2ConsumeAPI.controllers.getId;
import com.example.Framework2ConsumeAPI.entities.rest.LoginInput;
import com.example.Framework2ConsumeAPI.entities.rest.LoginOutput;
import com.example.Framework2ConsumeAPI.services.LoginRestService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	boolean shouldAuthenticateAgainstThirdPartySystem = true;
        
        LoginInput loginIn = new LoginInput();
        LoginOutput loginOut = new LoginOutput();
        
        @Autowired
        LoginRestService service;
        
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
                
                loginIn.setEmail(name);
                loginIn.setPassword(password);
                
                loginOut = service.login(loginIn);

		if (loginOut.getStatus().equalsIgnoreCase("Verified")) {
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final UserDetails principal = new User(name, password, grantedAuths);
			final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
			
                        getId.id=loginOut.getUser().getId();
                        System.out.println(getId.id);
                        return auth;
		} else {
			return null;
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}