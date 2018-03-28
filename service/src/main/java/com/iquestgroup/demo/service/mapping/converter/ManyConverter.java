package com.iquestgroup.demo.service.mapping.converter;

import com.google.common.collect.Iterables;
import com.iquestgroup.demo.persistence.model.Model;
import com.iquestgroup.demo.service.data.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManyConverter {

  public <T1 extends Model, T2 extends Data> List<T2> convert(Iterable<T1> modelList, Converter<T1, T2> converter) {
    List<T2> dataList = new ArrayList<>(Iterables.size(modelList));
    for(T1 model : modelList) {
      T2 data = converter.convertToData(model);
      dataList.add(data);
    }
    return dataList;
  }

}
