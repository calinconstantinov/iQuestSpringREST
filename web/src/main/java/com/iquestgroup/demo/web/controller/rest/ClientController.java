package com.iquestgroup.demo.web.controller.rest;

import com.iquestgroup.demo.service.ClientService;
import com.iquestgroup.demo.service.data.ClientBasicData;
import com.iquestgroup.demo.service.data.ClientData;
import com.iquestgroup.demo.service.data.ClientNewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping
  public List<ClientBasicData> getClients() {
    return clientService.retrieveClients();
  }

  @GetMapping("/{id}")
  public ClientData getClient(@PathVariable("id") int id) {
    return clientService.retrieveClient(id);
  }

  @GetMapping(params = {"phone"})
  public ClientData getClientByPhone(@RequestParam("phone") String phone) {
    return clientService.retrieveClientByPhone(phone);
  }

  @PostMapping
  public ClientData createClient(@RequestBody ClientNewData clientNewData) {
    return clientService.registerClient(clientNewData);
  }

}

