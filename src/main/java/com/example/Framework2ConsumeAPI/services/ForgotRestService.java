/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.services;

import com.example.Framework2ConsumeAPI.entities.rest.Email;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acer
 */
@Service
public class ForgotRestService {
    @Autowired
    RestTemplate restTemplate;
    
    public Email getEmail(String email){
        
        Email result;
        Map<String, String> param = new HashMap<>();
        // hasil > []
        param.put("email", email);
        // hasil > ["id" : "P01"]
        result = restTemplate.getForObject("http://116.254.101.228:8080/ma_test/forgotpassword/{email}", Email.class, param);
        return result;
    }
}
