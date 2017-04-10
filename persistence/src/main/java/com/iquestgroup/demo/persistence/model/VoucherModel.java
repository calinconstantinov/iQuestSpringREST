package com.iquestgroup.demo.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "voucher")
public class VoucherModel extends Model {

  private String code;

  private double value;

  @ManyToOne(optional = false)
  @JoinColumn(name = "clientid")
  private ClientModel clientModel;

  public VoucherModel() {

  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public ClientModel getClientModel() {
    return clientModel;
  }

  public void setClientModel(ClientModel clientModel) {
    this.clientModel = clientModel;
  }

}
