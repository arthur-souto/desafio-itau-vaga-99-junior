package com.arthur_souto.desafio_itau.domain;

import java.math.BigDecimal;

public class MetricasTransacoesResponseDomain {

    long count;
    BigDecimal sum;
    BigDecimal avg;
    BigDecimal min;
    BigDecimal max;

  public MetricasTransacoesResponseDomain(long count, BigDecimal sum, BigDecimal avg, BigDecimal min, BigDecimal max) {
    this.count = count;
    this.sum = sum;
    this.avg = avg;
    this.min = min;
    this.max = max;
  }

  public BigDecimal getAvg() {
    return avg;
  }

  public void setAvg(BigDecimal avg) {
    this.avg = avg;
  }

  public BigDecimal getMax() {
    return max;
  }

  public void setMax(BigDecimal max) {
    this.max = max;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public BigDecimal getSum() {
    return sum;
  }

  public void setSum(BigDecimal sum) {
    this.sum = sum;
  }

  public BigDecimal getMin() {
    return min;
  }

  public void setMin(BigDecimal min) {
    this.min = min;
  }
}
