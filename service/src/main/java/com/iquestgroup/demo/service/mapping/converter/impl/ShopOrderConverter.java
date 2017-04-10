package com.iquestgroup.demo.service.mapping.converter.impl;

import com.iquestgroup.demo.service.mapping.converter.Converter;
import com.iquestgroup.demo.persistence.model.ShopOrderModel;
import com.iquestgroup.demo.service.data.ShopOrderData;
import org.springframework.stereotype.Component;

@Component
public class ShopOrderConverter implements Converter<ShopOrderModel, ShopOrderData> {

  public ShopOrderData convertToData(ShopOrderModel model) {
    ShopOrderData shopOrderData = new ShopOrderData();
    shopOrderData.setId(model.getId());
    shopOrderData.setTotal(model.getTotal());
    shopOrderData.setClientId(model.getClientModel().getId());
    return shopOrderData;
  }

}
