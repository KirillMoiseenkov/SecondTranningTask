package com.company.newtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%s|name")
@Table(name = "NEWTASK_ORGANIZATION")
@Entity(name = "newtask$Organization")
public class Organization extends StandardEntity {
    private static final long serialVersionUID = 102816412721984869L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "TAX_NUMBER")
    protected Integer taxNumber;

    @Column(name = "REGISTRATION_NUMBER")
    protected Integer registrationNumber;

    @Column(name = "ESCAPE_VAT")
    protected Integer escapeVAT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACT_ID")
    protected Contract contract;

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTaxNumber(Integer taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Integer getTaxNumber() {
        return taxNumber;
    }

    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public void setEscapeVAT(Integer escapeVAT) {
        this.escapeVAT = escapeVAT;
    }

    public Integer getEscapeVAT() {
        return escapeVAT;
    }


}