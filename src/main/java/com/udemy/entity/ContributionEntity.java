package com.udemy.entity;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_contribution")
public class ContributionEntity {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "contribution_value")
    public BigInteger value;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public CustomerEntity customerEntity;
}
