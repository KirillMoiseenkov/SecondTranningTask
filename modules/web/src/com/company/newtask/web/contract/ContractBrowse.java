package com.company.newtask.web.contract;

import com.company.newtask.entity.Contract;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class ContractBrowse extends AbstractLookup {

    @Inject
    private PieChart pieChart;

    @Inject
    private GroupDatasource<Contract, UUID> contractsDs;

    @Override
    public void initLookupLayout() {
        super.initLookupLayout();
    }
}