package com.iquestgroup.demo.service.impl;

import com.iquestgroup.demo.persistence.model.VoucherModel;
import com.iquestgroup.demo.persistence.repository.VoucherRepository;
import com.iquestgroup.demo.service.VoucherService;
import com.iquestgroup.demo.service.data.VoucherData;
import com.iquestgroup.demo.service.mapping.converter.Converter;
import com.iquestgroup.demo.service.mapping.converter.ManyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

  @Autowired
  private VoucherRepository voucherRepository;

  @Autowired
  private Converter<VoucherModel, VoucherData> voucherDataConverter;

  @Autowired
  private ManyConverter manyConverter;

  @Override
  public List<VoucherData> retrieveVouchers() {
    return manyConverter.convert(voucherRepository.findAll(), voucherDataConverter);
  }

  @Override
  public VoucherData retrieveVoucher(int id) {
    VoucherModel voucherModel = voucherRepository.findOne(id);
    return voucherDataConverter.convertToData(voucherModel);
  }

  @Override
  public List<VoucherData> retrieveVouchersByClient(int clientId) {
    return manyConverter.convert(voucherRepository.findByClientModelId(clientId), voucherDataConverter);
  }

}
