package com.udemy.controllers;

import com.udemy.entity.CustomerEntity;
import com.udemy.repositories.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSuggestionDropdownController {

  @Autowired
  private CustomerRepository customerRepository;

  @ResponseBody
  @GetMapping("/list/please")
  public List<CustomerEntity> getCustomerListsPleaseJQUERY(@RequestParam String searchQuery) {
    searchQuery = searchQuery.trim();

    String firstname = "";
    String lastname = "";

    if(searchQuery.split(" ").length > 1)
    {
      firstname = searchQuery.split(" ")[0];
      lastname = searchQuery.split(" ")[1];
    }

    else{
      firstname = searchQuery;
      lastname = searchQuery;
    }

    List<CustomerEntity> customerEntities;

    if(!searchQuery.isEmpty()){

      if (customerRepository.findCustomersEntitiesByFirstnameOrLastname(firstname, lastname) != null){
        customerEntities = customerRepository.findCustomersEntitiesByFirstnameOrLastname(firstname, lastname);
      }

      else customerEntities = new ArrayList<>();
    }

    else customerEntities = new ArrayList<>();

    return customerEntities;
  }


  @ResponseBody
  @GetMapping("/recieve/image")
  public String responseFromImageRetrivial(@RequestParam String imageSource) {
    String src = imageSource;
    return "yes baby !";
  }
}
