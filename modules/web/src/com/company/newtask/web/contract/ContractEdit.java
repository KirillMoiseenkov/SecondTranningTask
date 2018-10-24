package com.company.newtask.web.contract;

import com.company.newtask.entity.Contract;
import com.company.newtask.entity.Invoice;
import com.company.newtask.entity.ServiceCompletionCertificate;
import com.company.newtask.entity.Stage;
import com.company.newtask.service.UniqueNumbersCustomService;
import com.company.newtask.service.VatService;
import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.KeyValueEntity;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Inject
    private UniqueNumbersCustomService uniqueNumbersCustomService;

    @Inject
    private CollectionDatasource<Invoice, UUID> invoicesDs;

    @Inject
    private CollectionDatasource<ServiceCompletionCertificate, UUID> serviceCompletionCertificatesDs;



    @Inject
    DataManager dataManager;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        contractDs.addItemPropertyChangeListener(e -> {
            if (e.getProperty().equals("amount") && getItem().getVat() != null && getItem().getVat()) {
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

        if (getItem().getStage() == null) {
            Stage stage = metadata.create(Stage.class);
            stage.setName("Дефолтный этап");
            stage.setContract(getItem());
            stageDs.addItem(stage);
        }

        return super.preCommit();
    }


    public void generateDoc() {

        Stage stage = stageTable.getSelected().iterator().next();

        ServiceCompletionCertificate serviceCompletionCertificate = metadata.create(ServiceCompletionCertificate.class);
        serviceCompletionCertificate.setNumber((int) uniqueNumbersCustomService.getNextNumber("ser"));
        serviceCompletionCertificate.setStage(stage);

        Invoice invoice = metadata.create(Invoice.class);
        invoice.setNumber((int) uniqueNumbersCustomService.getNextNumber("invoice"));
        invoice.setStage(stage);



        if(stage.getDescription()!=null)
        {
            invoice.setDescription(stage.getDescription());
            serviceCompletionCertificate.setDescription(stage.getDescription());
        }
        if (stage.getAmount()!=null)
        {
            invoice.setAmount(stage.getAmount());
            serviceCompletionCertificate.setAmount(stage.getAmount());
        }

        stage.setServiceCompletionCertificate(serviceCompletionCertificate);
        stage.setInvoice(invoice);

        CommitContext commitContext = new CommitContext();

        commitContext.getCommitInstances().add(serviceCompletionCertificate);

        commitContext.getCommitInstances().add(invoice);

        getDsContext().getDataSupplier().commit(commitContext);
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

    @Override
    protected boolean postCommit(boolean committed, boolean close) {

   //     stageDs.getItems().iterator().next().setAmount(2000);


        return super.postCommit(committed, close);
    }
}