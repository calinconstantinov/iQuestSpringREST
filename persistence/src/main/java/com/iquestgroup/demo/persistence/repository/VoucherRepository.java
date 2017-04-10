package com.iquestgroup.demo.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.iquestgroup.demo.persistence.model.VoucherModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends PagingAndSortingRepository<VoucherModel, Integer> {

  List<VoucherModel> findByClientModelId(int id);

}
