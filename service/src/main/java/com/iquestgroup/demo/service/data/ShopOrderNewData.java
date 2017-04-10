package com.iquestgroup.demo.service.data;

public class ShopOrderNewData extends Data {

  private double total;

  private int clientId;

  public ShopOrderNewData() {

  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

}
