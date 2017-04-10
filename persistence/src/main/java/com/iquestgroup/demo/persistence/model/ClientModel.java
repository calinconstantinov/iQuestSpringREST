package com.iquestgroup.demo.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientModel extends Model {

  @Column(unique = true, nullable = false)
  private String phone;

  @Column(unique = true, nullable = false)
  private String email;

  private String firstName;

  private String lastName;

  private Date joinDate;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientModel")
  private List<ShopOrderModel> shopOrderModels;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientModel")
  private List<VoucherModel> voucherModels;

  public ClientModel() {

  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<ShopOrderModel> getShopOrderModels() {
    return shopOrderModels;
  }

  public void setShopOrderModels(List<ShopOrderModel> shopOrderModels) {
    this.shopOrderModels = shopOrderModels;
  }

  public List<VoucherModel> getVoucherModels() {
    return voucherModels;
  }

  public void setVoucherModels(List<VoucherModel> voucherModels) {
    this.voucherModels = voucherModels;
  }

}
