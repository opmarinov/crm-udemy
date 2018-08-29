package com.udemy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping("/login")
  public String login(){
    return "login";
  }

  @RequestMapping("/access-denied")
  public String access(){
    return "access-denied";
  }
}
