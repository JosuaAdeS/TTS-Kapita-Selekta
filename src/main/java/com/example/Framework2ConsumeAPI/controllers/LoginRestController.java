/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.controllers;

import com.example.Framework2ConsumeAPI.entities.rest.LoginInput;
import com.example.Framework2ConsumeAPI.services.LoginRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author acer
 */
@Controller
public class LoginRestController {
    @Autowired 
    LoginRestService service;
    
    @GetMapping("")
    public String index(){
        LoginInput input = new LoginInput();
        input.setEmail("josua5ade@gmail.com");
        input.setPassword("11qwerty");
        System.out.println(service.login(input));
        
        return "redirect:/person";
    }
}
