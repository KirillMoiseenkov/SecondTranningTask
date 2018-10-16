package com.company.newtask.service;

import com.company.newtask.core.config.TotalAmountConfig;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;

@Service(VatService.NAME)
public class VatServiceBean implements VatService {

    @Inject
    TotalAmountConfig totalAmountConfig;


    @Override
    public Integer getTotalAmount(Integer amount) {
      return amount * totalAmountConfig.getVat();
    }
}