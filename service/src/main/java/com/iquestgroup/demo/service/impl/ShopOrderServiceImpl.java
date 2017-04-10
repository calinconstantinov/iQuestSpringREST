package com.iquestgroup.demo.service.impl;

import com.iquestgroup.demo.persistence.model.ShopOrderModel;
import com.iquestgroup.demo.persistence.model.VoucherModel;
import com.iquestgroup.demo.persistence.repository.ShopOrderRepository;
import com.iquestgroup.demo.persistence.repository.VoucherRepository;
import com.iquestgroup.demo.service.ShopOrderService;
import com.iquestgroup.demo.service.business.VoucherGenerator;
import com.iquestgroup.demo.service.data.ShopOrderData;
import com.iquestgroup.demo.service.data.ShopOrderNewData;
import com.iquestgroup.demo.service.mapping.builder.Builder;
import com.iquestgroup.demo.service.mapping.converter.Converter;
import com.iquestgroup.demo.service.mapping.converter.ManyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

  @Autowired
  private ShopOrderRepository shopOrderRepository;

  @Autowired
  private Converter<ShopOrderModel, ShopOrderData> shopOrderDataConverter;

  @Autowired
  private ManyConverter manyConverter;

  @Autowired
  private Builder<ShopOrderNewData, ShopOrderModel> shopOrderModelBuilder;

  @Autowired
  private VoucherRepository voucherRepository;

  @Autowired
  private VoucherGenerator voucherGenerator;

  @Override
  public List<ShopOrderData> retrieveShopOrders() {
    return manyConverter.convert(shopOrderRepository.findAll(), shopOrderDataConverter);
  }

  @Override
  public ShopOrderData retrieveShopOrder(int id) {
    ShopOrderModel shopOrderModel = shopOrderRepository.findOne(id);
    return shopOrderDataConverter.convertToData(shopOrderModel);
  }

  @Override
  public List<ShopOrderData> retrieveShopOrdersByClient(int clientId) {
    return manyConverter.convert(shopOrderRepository.findByClientModelId(clientId), shopOrderDataConverter);
  }

  @Override
  public List<ShopOrderData> retrieveShopOrdersByClientPhone(String clientPhone) {
    return manyConverter.convert(shopOrderRepository.findByClientModelPhone(clientPhone), shopOrderDataConverter);
  }

  @Override
  @Transactional
  public ShopOrderData placeShopOrder(ShopOrderNewData shopOrderNewData) {
    ShopOrderModel shopOrderModel = shopOrderModelBuilder.buildModel(shopOrderNewData);

    VoucherModel voucherModel = voucherGenerator.generateVoucher(shopOrderModel);
    voucherRepository.save(voucherModel);

    shopOrderModel = shopOrderRepository.save(shopOrderModel);
    return shopOrderDataConverter.convertToData(shopOrderModel);
  }

}
