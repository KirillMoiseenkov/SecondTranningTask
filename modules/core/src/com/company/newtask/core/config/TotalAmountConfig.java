package com.company.newtask.core.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

@Source(type = SourceType.DATABASE)
public interface TotalAmountConfig extends Config{

    @Property("cuba.VAT")
    @Default("0")
    public Integer getVat();

}
