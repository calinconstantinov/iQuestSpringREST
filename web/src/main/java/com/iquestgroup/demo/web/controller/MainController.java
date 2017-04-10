package com.iquestgroup.demo.web.controller;

import com.iquestgroup.demo.persistence.repository.ClientRepository;
import com.iquestgroup.demo.persistence.repository.ShopOrderRepository;
import com.iquestgroup.demo.persistence.repository.VoucherRepository;
import com.iquestgroup.demo.service.ClientService;
import com.iquestgroup.demo.service.ShopOrderService;
import com.iquestgroup.demo.service.data.ClientData;
import com.iquestgroup.demo.service.data.ClientNewData;
import com.iquestgroup.demo.service.data.ShopOrderNewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private ShopOrderRepository shopOrderRepository;

  @Autowired
  private VoucherRepository voucherRepository;

  @Autowired
  private ClientService clientService;

  @Autowired
  private ShopOrderService shopOrderService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    clientRepository.deleteAll();
    shopOrderRepository.deleteAll();
    voucherRepository.deleteAll();

    ClientNewData clientNewData = new ClientNewData();
    clientNewData.setFirstName("John");
    clientNewData.setLastName("Doe");
    clientNewData.setPhone("12345678");
    clientNewData.setEmail("john.doe@mail.com");
    clientService.registerClient(clientNewData);

    clientNewData = new ClientNewData();
    clientNewData.setFirstName("Foo");
    clientNewData.setLastName("Bar");
    clientNewData.setPhone("87654321");
    clientNewData.setEmail("foe.bar@mail.com");
    clientService.registerClient(clientNewData);

    clientNewData = new ClientNewData();
    clientNewData.setFirstName("Alice");
    clientNewData.setLastName("Bob");
    clientNewData.setPhone("00000000");
    clientNewData.setEmail("alice.bob@mail.com");
    ClientData clientData = clientService.registerClient(clientNewData);

    ShopOrderNewData shopOrderNewData = new ShopOrderNewData();
    shopOrderNewData.setTotal(123);
    shopOrderNewData.setClientId(clientData.getId());
    shopOrderService.placeShopOrder(shopOrderNewData);

    return "index";
  }

}
