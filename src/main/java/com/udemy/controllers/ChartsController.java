package com.udemy.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartsController {

  @GetMapping("api/charts")
  public String getCharts(){
    return "charts-view";
  }
}
