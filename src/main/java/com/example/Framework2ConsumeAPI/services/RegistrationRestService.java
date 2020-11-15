package com.example.Framework2ConsumeAPI.services;

import com.example.Framework2ConsumeAPI.entities.rest.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acer
 */
@Service
public class RegistrationRestService {
    @Autowired
    RestTemplate restTemplate;
    
    public void register(RegisterUser user){
        restTemplate.postForObject("http://116.254.101.228:8080/ma_test/register", user, RegisterUser.class);
    }
}
