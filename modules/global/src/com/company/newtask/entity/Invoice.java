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
import javax.persistence.OneToOne;

@NamePattern("%s|number")
@Table(name = "NEWTASK_INVOICE")
@Entity(name = "newtask$Invoice")
public class Invoice extends StandardEntity {
    private static final long serialVersionUID = -4641328384057053543L;

    @Column(name = "NUMBER_")
    protected Integer number;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    protected Date date;

    @Column(name = "AMOUNT")
    protected Integer amount;

    @Column(name = "VAT")
    protected Integer vat;

    @Column(name = "TOTAL_AMOUNT")
    protected Integer totalAmount;

    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "FILE_")
    protected String file;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STAGE_ID")
    protected Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public Integer getVat() {
        return vat;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }


}