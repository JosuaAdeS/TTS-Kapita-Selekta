/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.services;

import com.example.Framework2ConsumeAPI.entities.rest.LoginInput;
import com.example.Framework2ConsumeAPI.entities.rest.LoginOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acer
 */
@Service
public class LoginRestService {
    @Autowired
    RestTemplate restTemplate;
    
    public LoginOutput login(LoginInput input){
        HttpEntity<LoginInput> request = new HttpEntity<>(input,null);
        ResponseEntity<LoginOutput> responseEntity = restTemplate.exchange("http://116.254.101.228:8080/ma_test/login", 
                HttpMethod.POST, 
                request, 
                new ParameterizedTypeReference<LoginOutput>(){
                }
        );
        return responseEntity.getBody();
    }
    
}
