package com.iquestgroup.demo.service.mapping.builder.impl;

import com.iquestgroup.demo.persistence.model.ClientModel;
import com.iquestgroup.demo.persistence.model.ShopOrderModel;
import com.iquestgroup.demo.persistence.repository.ClientRepository;
import com.iquestgroup.demo.service.data.ShopOrderNewData;
import com.iquestgroup.demo.service.mapping.builder.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopOrderBuilder implements Builder<ShopOrderNewData, ShopOrderModel> {

  @Autowired
  private ClientRepository clientRepository;

  public ShopOrderModel buildModel(ShopOrderNewData data) {
    ShopOrderModel shopOrderModel = new ShopOrderModel();
    shopOrderModel.setTotal(data.getTotal());
    shopOrderModel.setClientModel(retrieveClient(data));
    return shopOrderModel;
  }

  private ClientModel retrieveClient(ShopOrderNewData data) {
    return clientRepository.findOne(data.getClientId());
  }

}
