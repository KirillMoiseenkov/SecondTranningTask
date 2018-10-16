package com.company.newtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@NamePattern("%s|name")
@Table(name = "NEWTASK_STATUS")
@Entity(name = "newtask$Status")
public class Status extends StandardEntity {
    private static final long serialVersionUID = 5723181030734924599L;

    @Column(name = "CODE")
    protected Integer code;

    @Column(name = "NAME")
    protected String name;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "status")
    protected Contract contract;

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}