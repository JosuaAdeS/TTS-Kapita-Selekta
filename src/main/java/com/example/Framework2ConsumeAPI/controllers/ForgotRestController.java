/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.controllers;

import com.example.Framework2ConsumeAPI.services.ForgotRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author acer
 */
@Controller
public class ForgotRestController {
    @Autowired
    ForgotRestService service;
    
    @GetMapping("email")
    public String getEmail(Model model, @PathVariable("email") String email) {
        model.addAttribute("email", service.getEmail(email));
        System.out.println(service.getEmail(email));
        return "resetPassword";
    }
}
