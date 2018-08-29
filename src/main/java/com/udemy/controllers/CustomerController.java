package com.udemy.controllers;

import com.udemy.entity.CustomerEntity;
import com.udemy.repositories.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class CustomerController {
  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/customers")
  public String getCustomers(Model model){
    model.addAttribute("customers", customerRepository.findAll());
    return "customer-view";
  }

  @RequestMapping("/add")
  public String addCustomers(){
    return "add-customer-view";
  }

  @PostMapping("/customers")
  public String addNewCustomer(@RequestParam String firstname
      ,@RequestParam String lastname, @RequestParam String position, @RequestParam String email){

    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setFirstname(firstname);
    customerEntity.setLastname(lastname);
    customerEntity.setPosition(position);
    customerEntity.setEmail(email);

    customerRepository.save(customerEntity);

    return "redirect:/customer/list";
  }

  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam Integer id){
    customerRepository.delete(id);
    return "redirect:/api/customers";
  }

  @GetMapping("/edit")
  public String editCustomer(Model model, @RequestParam Integer id){

    model.addAttribute("customer", customerRepository.getOne(id));
    return "edit-customer-view";
  }

  @GetMapping("/edit/save")
  public String editCustomer(@ModelAttribute(name = "customer") CustomerEntity customer){
    customerRepository.save(customer);

    return "redirect:/api/customers";
  }

  @GetMapping("/search")
  public String editCustomer(Model model, @RequestParam String name){
    name = name.trim();

    String firstname = "";
    String lastname = "";

    if(name.split(" ").length > 1)
    {
      firstname = name.split(" ")[0];
      lastname = name.split(" ")[1];
    }

    else{
      firstname = name;
      lastname = name;
    }

    List<CustomerEntity> customerEntities;

    if(!name.isEmpty()){
      customerEntities = customerRepository.findCustomersEntitiesByFirstnameOrLastname(firstname, lastname);
    }

    else customerEntities = customerRepository.findAll();

    model.addAttribute("customers", customerEntities);
    return "customer-view";
  }
}
