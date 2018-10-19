package com.company.newtask.core.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

@Source(type = SourceType.DATABASE)
public interface EmailConfig extends Config {

    @Property("cuba.email.ExfromAddress")
    @Default("do-not-reply-please@company.com")
    String getExFromAddress();

    String setExFromAddress(String address);

}
