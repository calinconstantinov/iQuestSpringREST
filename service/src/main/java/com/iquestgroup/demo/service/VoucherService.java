package com.iquestgroup.demo.service;

import com.iquestgroup.demo.service.data.VoucherData;

import java.util.List;

public interface VoucherService {

  List<VoucherData> retrieveVouchers();

  VoucherData retrieveVoucher(int id);

  List<VoucherData> retrieveVouchersByClient(int clientId);

}
