package com.company.newtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamePattern("%s|customer")
@Table(name = "NEWTASK_CONTRACT")
@Entity(name = "newtask$Contract")
public class Contract extends StandardEntity {
    private static final long serialVersionUID = 8102210473979905237L;

    @Column(name = "CUSTOMER")
    protected String customer;

    @Column(name = "STATE")
    protected String state;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "contract")
    protected List<Stage> stage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    protected Organization organization;

    @Column(name = "PERFORMER")
    protected String performer;

    @Column(name = "NUMBER_")
    protected Integer number;

    @Temporal(TemporalType.DATE)
    @Column(name = "SINGLE_DATE")
    protected Date singleDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FROM")
    protected Date dateFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_TO")
    protected Date dateTo;

    @Column(name = "AMOUNT")
    protected Integer amount;

    @Column(name = "VAT")
    protected Boolean vat;

    @Column(name = "TOTAL_AMOUNT")
    protected Integer totalAmount;

    @Column(name = "CUSTOMER_SINGLE")
    protected String customerSingle;

    @Column(name = "PERFORMER_SINGLE")
    protected String performerSingle;

    @Column(name = "FILE_")
    protected String file;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    protected Status status;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


    public Boolean getVat() {
        return vat;
    }

    public void setVat(Boolean vat) {
        this.vat = vat;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }


    public List<Stage> getStage() {
        return stage;
    }

    public void setStage(List<Stage> stage) {
        this.stage = stage;
    }




    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getOrganization() {
        return organization;
    }


    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getPerformer() {
        return performer;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setSingleDate(Date singleDate) {
        this.singleDate = singleDate;
    }

    public Date getSingleDate() {
        return singleDate;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setCustomerSingle(String customerSingle) {
        this.customerSingle = customerSingle;
    }

    public String getCustomerSingle() {
        return customerSingle;
    }

    public void setPerformerSingle(String performerSingle) {
        this.performerSingle = performerSingle;
    }

    public String getPerformerSingle() {
        return performerSingle;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }


}