package com.iquestgroup.demo.service.business;

import com.iquestgroup.demo.persistence.model.ShopOrderModel;
import com.iquestgroup.demo.persistence.model.VoucherModel;
import org.springframework.stereotype.Service;;

import java.util.UUID;

@Service
public class VoucherGenerator {

  public VoucherModel generateVoucher(ShopOrderModel shopOrderModel) {
    VoucherModel voucherModel = new VoucherModel();
    voucherModel.setCode(UUID.randomUUID().toString());
    voucherModel.setValue(computeVoucherValue(shopOrderModel));
    voucherModel.setClientModel(shopOrderModel.getClientModel());
    return voucherModel;
  }

  private double computeVoucherValue(ShopOrderModel shopOrderModel) {
    return shopOrderModel.getTotal()/10;
  }

}
