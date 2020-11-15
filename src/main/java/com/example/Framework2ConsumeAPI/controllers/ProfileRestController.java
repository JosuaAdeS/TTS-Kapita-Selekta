/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.controllers;

import com.example.Framework2ConsumeAPI.services.ProfileRestService;
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
public class ProfileRestController {
    @Autowired
    ProfileRestService service;
    
    @GetMapping("basic")
    public String profileBasic(Model model){
        model.addAttribute("profile", service.getProfileBasic(getId.id));
        System.out.println(service.getProfileBasic(getId.id));
        return "profileBasic";
    }
    
    @GetMapping("/profileAddress/")
    public String profileAddress(Model model){
        model.addAttribute("address", service.getProfileAddress(getId.id));
        System.out.println(service.getProfileAddress(getId.id));
        return "profileAddress";
    }
    
    @GetMapping("/profileContact/")
    public String profileContact(Model model){
        model.addAttribute("contact", service.getProfileContact(getId.id));
        System.out.println(service.getProfileContact(getId.id));
        return "profileContact";
    }
    
    @GetMapping("/profileOccupation/")
    public String profileOccupation(Model model){
        model.addAttribute("occupation", service.getProfileOccupation(getId.id));
        System.out.println(service.getProfileOccupation(getId.id));
        return "profileOccupation";
    }
    
    @GetMapping("/profileEducation/")
    public String profileEducation(Model model){
        model.addAttribute("education", service.getProfileEducation(getId.id));
        System.out.println(service.getProfileEducation(getId.id));
        return "profileEducation";
    }
}
