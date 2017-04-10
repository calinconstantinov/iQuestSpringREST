package com.iquestgroup.demo.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.iquestgroup.demo.persistence.model.ShopOrderModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopOrderRepository extends PagingAndSortingRepository<ShopOrderModel, Integer> {

  List<ShopOrderModel> findByClientModelId(int id);

  List<ShopOrderModel> findByClientModelPhone(String phone);

}
