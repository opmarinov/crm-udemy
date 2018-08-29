package com.udemy.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {

  @Id
  @GeneratedValue
  public Integer id;

  @Column
  public String firstname;

  @Column
  public String lastname;

  @Column
  public String position;

  @Column
  public String email;
}
