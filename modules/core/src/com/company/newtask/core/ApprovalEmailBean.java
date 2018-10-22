package com.company.newtask.core;

import com.company.newtask.core.config.EmailConfig;
import com.haulmont.bpm.entity.ProcActor;
import com.haulmont.bpm.entity.ProcDefinition;
import com.haulmont.bpm.entity.ProcInstance;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Set;
import java.util.UUID;

@Component("NewTask_ApprovalEmailBean")
public class ApprovalEmailBean {

    @Inject
    protected EmailService emailService;

    @Inject
    protected EmailConfig emailConfig;

    @Inject
    private Persistence persistence;

    public void sayGaf(UUID entityId){

        ProcInstance procInstance;
        try (Transaction tx = persistence.getTransaction()) {
         Query query = persistence.getEntityManager()
                 .createQuery("select procIn from bpm$ProcInstance procIn where procIn.entityId = :entityId")
                    .setParameter("entityId",entityId);

            procInstance = (ProcInstance) query.getFirstResult();

            tx.commit();
        }

       procInstance.getProcActors().forEach(procActor -> {
         String toEmail = procActor.getUser().getEmail();
           EmailInfo emailInfo = new EmailInfo("moiseenkov@haulmont.com" /*should be toEmail*/, "Change status",
                   emailConfig.getExFromAddress(), "Change status");

           emailService.sendEmailAsync(emailInfo);
       });

    }

    }

