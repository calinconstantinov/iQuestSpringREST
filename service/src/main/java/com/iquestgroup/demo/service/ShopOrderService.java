package com.iquestgroup.demo.service;

import com.iquestgroup.demo.service.data.ShopOrderData;
import com.iquestgroup.demo.service.data.ShopOrderNewData;

import java.util.List;

public interface ShopOrderService {

  List<ShopOrderData> retrieveShopOrders();

  ShopOrderData retrieveShopOrder(int id);

  List<ShopOrderData> retrieveShopOrdersByClient(int clientId);

  List<ShopOrderData> retrieveShopOrdersByClientPhone(String clientPhone);

  ShopOrderData placeShopOrder(ShopOrderNewData shopOrderNewData);

}
