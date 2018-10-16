package com.company.newtask.web.contract;

import com.company.newtask.entity.Stage;
import com.company.newtask.service.VatService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.newtask.entity.Contract;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ContractEdit extends AbstractEditor<Contract> {

    @Inject
    private Datasource<Contract> contractDs;

    @Inject
    private VatService vatService;

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
    protected boolean postCommit(boolean committed, boolean close) {



        if(getItem().getStage().isEmpty()){
            ArrayList<Stage> stages = new ArrayList<>();

            Stage stage = new Stage();
            stage.setName("Дефолтный этап");

            stage.setDateFrom(getItem().getDateFrom());
            stage.setDateTo(getItem().getDateTo());
            stage.setAmount(getItem().getAmount());
            stages.add(stage);
            getItem().setStage(stages);
        }

        return super.postCommit(committed, close);
    }
}