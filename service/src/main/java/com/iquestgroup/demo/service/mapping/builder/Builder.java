package com.iquestgroup.demo.service.mapping.builder;

import com.iquestgroup.demo.persistence.model.Model;
import com.iquestgroup.demo.service.data.Data;

public interface Builder<T2 extends Data, T1 extends Model> {

  T1 buildModel(T2 data);
  
}
