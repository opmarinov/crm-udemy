package com.udemy.daos;

import java.math.BigInteger;
import lombok.Data;

@Data
public class ChartInfoDao {

  public String label;
  public BigInteger y;

  public ChartInfoDao(String label, BigInteger y) {
    this.label = label;
    this.y = y;
  }
}
