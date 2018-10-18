package com.company.newtask.web.contract;

import com.company.newtask.entity.ServiceCompletionCertificate;
import com.company.newtask.entity.Stage;
import com.company.newtask.service.VatService;
import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.newtask.entity.Contract;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ContractEdit extends AbstractEditor<Contract> {

    private static final String PROCESS_CODE = "approval";

    @Inject
    private Datasource<Contract> contractDs;

    @Inject
    private CollectionDatasource<Stage, UUID> stageDs;

    @Inject
    private VatService vatService;

    @Inject
    private Metadata metadata;

    @Inject
    private Table<Stage> stageTable;

    @Inject
    private ProcActionsFrame procActionsFrame;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        contractDs.addItemPropertyChangeListener(e -> {
            if(e.getProperty().equals("amount") && getItem().getVat()){
                getItem().setTotalAmount(vatService.getTotalAmount(getItem().getAmount()));
            }
        });
    }


    @Override
    protected boolean preCommit() {

        if(getItem().getStage() == null){
            Stage stage = metadata.create(Stage.class);
            stage.setName("Дефолтный этап");
            stage.setContract(getItem());
            stageDs.addItem(stage);
        }

        return super.preCommit();
    }

    public void sayGAF(){

        ServiceCompletionCertificate serviceCompletionCertificate = metadata.create(ServiceCompletionCertificate.class);
        serviceCompletionCertificate.setNumber(123);
        serviceCompletionCertificate.setStage(stageTable.getSelected().iterator().next());
        stageTable.getSelected().iterator().next().setServiceCompletionCertificate(serviceCompletionCertificate);
    }

    @Override
    protected void postInit() {
        initProcActionsFrame();
    }

    private void initProcActionsFrame() {
        procActionsFrame.initializer()
                .setBeforeStartProcessPredicate(this::commit)
                .setAfterStartProcessListener(() -> {
                    showNotification(getMessage("processStarted"), NotificationType.HUMANIZED);
                    close(COMMIT_ACTION_ID);
                })
                .setBeforeCompleteTaskPredicate(this::commit)
                .setAfterCompleteTaskListener(() -> {
                    showNotification(getMessage("taskCompleted"), NotificationType.HUMANIZED);
                    close(COMMIT_ACTION_ID);
                })
                .init(PROCESS_CODE, getItem());
    }

}