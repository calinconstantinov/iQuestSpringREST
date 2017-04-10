package com.iquestgroup.demo.service.impl;

import com.iquestgroup.demo.persistence.model.ClientModel;
import com.iquestgroup.demo.persistence.repository.ClientRepository;
import com.iquestgroup.demo.service.ClientService;
import com.iquestgroup.demo.service.data.ClientBasicData;
import com.iquestgroup.demo.service.data.ClientData;
import com.iquestgroup.demo.service.data.ClientNewData;
import com.iquestgroup.demo.service.mapping.builder.Builder;
import com.iquestgroup.demo.service.mapping.converter.Converter;
import com.iquestgroup.demo.service.mapping.converter.ManyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private Converter<ClientModel, ClientData> clientDataConverter;

  @Autowired
  private Converter<ClientModel, ClientBasicData> clientBasicDataConverter;

  @Autowired
  private Builder<ClientNewData, ClientModel> clientModelBuilder;

  @Autowired
  private ManyConverter manyConverter;

  @Override
  public List<ClientBasicData> retrieveClients() {
    return manyConverter.convert(clientRepository.findAll(), clientBasicDataConverter);
  }

  @Override
  public ClientData retrieveClient(int id) {
    ClientModel clientModel = clientRepository.findOne(id);
    return clientDataConverter.convertToData(clientModel);
  }

  @Override
  public ClientData retrieveClientByPhone(String phone) {
    ClientModel clientModel = clientRepository.findByPhone(phone);
    return clientDataConverter.convertToData(clientModel);
  }

  @Override
  public ClientData registerClient(ClientNewData clientNewData) {
    ClientModel clientModel = clientModelBuilder.buildModel(clientNewData);
    clientModel = clientRepository.save(clientModel);
    return clientDataConverter.convertToData(clientModel);
  }

}
