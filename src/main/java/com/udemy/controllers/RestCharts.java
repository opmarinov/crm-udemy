package com.udemy.controllers;


import com.udemy.daos.ChartInfoDao;
import com.udemy.entity.CustomerEntity;
import com.udemy.repositories.CustomerRepository;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCharts {

  @Autowired
  private CustomerRepository customerRepository;

  @ResponseBody
  @GetMapping("/retrieve/contribution")
  public List<ChartInfoDao> values() {

    List<ChartInfoDao> chartInfo = new ArrayList<>();

    int n = 1000;


    for (CustomerEntity customerEntity : customerRepository.findAll()) {
      n += 3000;

      BigInteger nn = new BigInteger(String.valueOf(n));
      chartInfo.add(new ChartInfoDao(
          customerEntity.getFirstname() + " " + customerEntity.getLastname(),
          customerEntity.getContribution().getValue().multiply(nn)
      ));
    }

    return chartInfo;
  }
}