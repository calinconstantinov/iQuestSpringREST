package com.iquestgroup.demo.persistence.repository;

import com.iquestgroup.demo.persistence.model.ClientModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<ClientModel, Integer> {

  ClientModel findByEmail(String email);

  ClientModel findByPhone(String phone);

  @Query("SELECT client FROM ClientModel client WHERE client.joinDate > :earliestJoinDate")
  List<ClientModel> findNewClients(@Param("earliestJoinDate") Date earliestJoinDate);

}
