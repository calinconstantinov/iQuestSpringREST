package com.iquestgroup.demo.persistence.model;

import com.iquestgroup.demo.persistence.model.Model;

import javax.persistence.*;

@Entity
@Table(name = "shoporder")
public class ShopOrderModel extends Model {

  private double total;

  @ManyToOne(optional = false)
  @JoinColumn(name = "clientid")
  private ClientModel clientModel;

  public ShopOrderModel() {

  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public ClientModel getClientModel() {
    return clientModel;
  }

  public void setClientModel(ClientModel clientModel) {
    this.clientModel = clientModel;
  }

}
