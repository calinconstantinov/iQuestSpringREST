package com.iquestgroup.demo.service;

import com.iquestgroup.demo.service.data.ClientBasicData;
import com.iquestgroup.demo.service.data.ClientData;
import com.iquestgroup.demo.service.data.ClientNewData;

import java.util.List;

public interface ClientService {

  List<ClientBasicData> retrieveClients();

  ClientData retrieveClient(int id);

  ClientData retrieveClientByPhone(String phone);

  ClientData registerClient(ClientNewData clientNewData);

}
