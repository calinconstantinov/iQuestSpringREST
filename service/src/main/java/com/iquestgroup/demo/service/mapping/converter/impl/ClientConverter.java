package com.iquestgroup.demo.service.mapping.converter.impl;

import com.iquestgroup.demo.service.mapping.converter.Converter;
import com.iquestgroup.demo.persistence.model.ClientModel;
import com.iquestgroup.demo.service.data.ClientData;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class ClientConverter implements Converter<ClientModel, ClientData> {

  private static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

  public ClientData convertToData(ClientModel model) {
    ClientData clientData = new ClientData();
    clientData.setId(model.getId());
    clientData.setEmail(model.getEmail());
    clientData.setPhone(model.getPhone());
    clientData.setJoinDate(df.format(model.getJoinDate()));
    clientData.setFirstName(model.getFirstName());
    clientData.setLastName(model.getLastName());
    return clientData;
  }

}
