package com.iquestgroup.demo.service.mapping.builder.impl;

import com.iquestgroup.demo.service.mapping.builder.Builder;
import com.iquestgroup.demo.persistence.model.ClientModel;
import com.iquestgroup.demo.service.data.ClientNewData;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClientBuilder implements Builder<ClientNewData, ClientModel> {

  public ClientModel buildModel(ClientNewData data) {
    ClientModel clientModel = new ClientModel();
    clientModel.setFirstName(data.getFirstName());
    clientModel.setLastName(data.getLastName());
    clientModel.setEmail(data.getEmail());
    clientModel.setPhone(data.getPhone());

    clientModel.setJoinDate(new Date());
    return clientModel;
  }

}
