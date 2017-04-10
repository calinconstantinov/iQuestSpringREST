package com.iquestgroup.demo.service.data;

public class ShopOrderData extends Data {

  private int id;

  private double total;

  private int clientId;

  public ShopOrderData() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
