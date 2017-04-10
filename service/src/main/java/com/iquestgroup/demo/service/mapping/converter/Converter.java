package com.iquestgroup.demo.service.mapping.converter;

import com.iquestgroup.demo.persistence.model.Model;
import com.iquestgroup.demo.service.data.Data;

public interface Converter<T1 extends Model, T2 extends Data> {

  T2 convertToData(T1 model);

}
