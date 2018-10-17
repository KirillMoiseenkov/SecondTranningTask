package com.company.newtask.web.stage;

import com.company.newtask.entity.ServiceCompletionCertificate;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.newtask.entity.Stage;
import org.hibernate.validator.internal.metadata.aggregated.MetaDataBuilder;

import javax.inject.Inject;

public class StageEdit extends AbstractEditor<Stage> {

    @Inject
    private Metadata metadata;

    @Inject
    private DataManager dataManager;

    public void generateDoc() {


        ServiceCompletionCertificate serviceCompletionCertificate = metadata.create(ServiceCompletionCertificate.class);
        serviceCompletionCertificate.setDescription(getItem().getDescription());
        serviceCompletionCertificate.setStage(getItem());
        serviceCompletionCertificate.setNumber(111);
        getItem().setServiceCompletionCertificate (serviceCompletionCertificate);

    }
}