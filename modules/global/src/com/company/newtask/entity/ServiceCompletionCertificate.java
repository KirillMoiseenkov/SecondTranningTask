package com.company.newtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import com.haulmont.cuba.core.entity.FileDescriptor;
import javax.persistence.ManyToOne;

@NamePattern("%s|number")
@Table(name = "NEWTASK_SERVICE_COMPLETION_CERTIFICATE")
@Entity(name = "newtask$ServiceCompletionCertificate")
public class ServiceCompletionCertificate extends StandardEntity {
    private static final long serialVersionUID = -2103616631949319803L;

    @Column(name = "NUMBER_")
    protected Integer number;

    @JoinTable(name = "NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK",
        joinColumns = @JoinColumn(name = "SERVICE_COMPLETION_CERTIFICATE_ID"),
        inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @ManyToMany
    protected List<FileDescriptor> file;

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


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STAGE_ID")
    protected Stage stage;



    public void setFile(List<FileDescriptor> file) {
        this.file = file;
    }

    public List<FileDescriptor> getFile() {
        return file;
    }


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


}