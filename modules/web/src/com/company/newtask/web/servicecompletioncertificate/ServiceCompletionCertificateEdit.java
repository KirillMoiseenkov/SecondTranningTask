package com.company.newtask.web.servicecompletioncertificate;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.newtask.entity.ServiceCompletionCertificate;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class ServiceCompletionCertificateEdit extends AbstractEditor<ServiceCompletionCertificate> {

    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

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
}