package com.iquestgroup.demo.web.controller.rest;

import com.iquestgroup.demo.service.VoucherService;
import com.iquestgroup.demo.service.data.VoucherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vouchers")
public class VoucherController {

  @Autowired
  private VoucherService voucherService;

  @GetMapping
  public List<VoucherData> getVouchers() {
    return voucherService.retrieveVouchers();
  }

  @GetMapping(params = {"clientId"})
  public List<VoucherData> getVouchersByClientId(@RequestParam(name = "clientId") int clientId) {
    return voucherService.retrieveVouchersByClient(clientId);
  }

  @GetMapping("/{id}")
  public VoucherData getVoucher(@PathVariable("id") int id) {
    return voucherService.retrieveVoucher(id);
  }

}
