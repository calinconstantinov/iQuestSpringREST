package com.iquestgroup.demo.web.controller.rest;

import com.iquestgroup.demo.service.ShopOrderService;
import com.iquestgroup.demo.service.data.ShopOrderData;
import com.iquestgroup.demo.service.data.ShopOrderNewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/shoporders")
public class ShopOrderController {

  @Autowired
  private ShopOrderService shopOrderService;

  @GetMapping
  public List<ShopOrderData> getShopOrders() {
    return shopOrderService.retrieveShopOrders();
  }

  @GetMapping(params = {"clientId"})
  public List<ShopOrderData> getShopOrdersByClient(@RequestParam(name = "clientId") int clientId) {
    return shopOrderService.retrieveShopOrdersByClient(clientId);
  }

  @GetMapping(params = {"clientPhone"})
  public List<ShopOrderData> getShopOrdersByClient(@RequestParam(name = "clientPhone") String clientPhone) {
    return shopOrderService.retrieveShopOrdersByClientPhone(clientPhone);
  }

  @GetMapping("/{id}")
  public ShopOrderData getShopOrder(@PathVariable("id") int id) {
    return shopOrderService.retrieveShopOrder(id);
  }

  @PostMapping
  public ShopOrderData createShopOrder(@RequestBody ShopOrderNewData shopOrderNewData) {
    return shopOrderService.placeShopOrder(shopOrderNewData);
  }

}
