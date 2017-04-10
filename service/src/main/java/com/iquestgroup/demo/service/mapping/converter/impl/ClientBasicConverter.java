package com.iquestgroup.demo.service.mapping.converter.impl;

import com.iquestgroup.demo.service.mapping.converter.Converter;
import com.iquestgroup.demo.persistence.model.ClientModel;
import com.iquestgroup.demo.service.data.ClientBasicData;
import org.springframework.stereotype.Component;

@Component
public class ClientBasicConverter implements Converter<ClientModel, ClientBasicData> {

  public ClientBasicData convertToData(ClientModel model) {
    ClientBasicData clientBasicData = new ClientBasicData();
    clientBasicData.setId(model.getId());
    clientBasicData.setName(model.getFirstName());
    return clientBasicData;
  }

}
