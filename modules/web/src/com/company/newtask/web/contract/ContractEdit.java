package com.company.newtask.web.contract;

import com.company.newtask.entity.Invoice;
import com.company.newtask.entity.ServiceCompletionCertificate;
import com.company.newtask.entity.Stage;
import com.company.newtask.service.VatService;
import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.*;
import com.company.newtask.entity.Contract;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ContractEdit extends AbstractEditor<Contract> {

    private static final String PROCESS_CODE = "copyOfApproval";

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

    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        contractDs.addItemPropertyChangeListener(e -> {
            if(e.getProperty().equals("amount") && getItem().getVat()){
                getItem().setTotalAmount(vatService.getTotalAmount(getItem().getAmount()));
            }
        });

        multiUploadField.addQueueUploadCompleteListener(() -> {
            for (Map.Entry<UUID, String> entry : multiUploadField.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                // save file to FileStorage
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    new RuntimeException("Error saving file to FileStorage", e);
                }
                // save file descriptor to database
                dataSupplier.commit(fd);
            }
            showNotification("Uploaded files: " + multiUploadField.getUploadsMap().values(), NotificationType.HUMANIZED);
            multiUploadField.clearUploads();
        });

        multiUploadField.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));


    }

    @Override
    protected void initNewItem(Contract item) {
        super.initNewItem(item);

        item.setState("New");
    }

    @Override
    protected void postInit() {
        super.postInit();
        initProcActionsFrame();
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

        Stage stage = stageTable.getSelected().iterator().next();

        ServiceCompletionCertificate serviceCompletionCertificate = metadata.create(ServiceCompletionCertificate.class);
        serviceCompletionCertificate.setNumber(123);
        serviceCompletionCertificate.setStage(stage);

        Invoice invoice = metadata.create(Invoice.class);
        invoice.setNumber(123);
        invoice.setStage(stage);


       stage.setServiceCompletionCertificate(serviceCompletionCertificate);
       stage.setInvoice(invoice);


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