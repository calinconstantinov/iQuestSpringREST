package com.iquestgroup.demo.service.mapping.converter.impl;

import com.iquestgroup.demo.persistence.model.VoucherModel;
import com.iquestgroup.demo.service.data.VoucherData;
import com.iquestgroup.demo.service.mapping.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VoucherConverter implements Converter<VoucherModel, VoucherData> {

  @Override
  public VoucherData convertToData(VoucherModel model) {
    VoucherData voucherData = new VoucherData();
    voucherData.setId(model.getId());
    voucherData.setCode(model.getCode());
    voucherData.setValue(model.getValue());
    voucherData.setClientId(model.getClientModel().getId());
    return voucherData;
  }

}
