package com.company.newtask.service;

import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(UniqueNumbersCustomService.NAME)
public class UniqueNumbersCustomServiceBean implements UniqueNumbersCustomService {

    @Inject
    UniqueNumbersAPI uniqueNumbersAPI;

    @Override
    public long getNextNumber(String domain) {
        return uniqueNumbersAPI.getNextNumber(domain);
    }

    @Override
    public long getCurrentNumber(String domain) {
        return uniqueNumbersAPI.getCurrentNumber(domain);
    }

    @Override
    public void setCurrentNumber(String domain, long value) {
        uniqueNumbersAPI.setCurrentNumber(domain,value);
    }
}