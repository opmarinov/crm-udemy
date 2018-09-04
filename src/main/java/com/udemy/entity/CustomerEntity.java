package com.udemy.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "contribution_id")
  private ContributionEntity contribution;
}
