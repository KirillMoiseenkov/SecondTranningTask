alter table NEWTASK_CONTRACT add constraint FK_NEWTASK_CONTRACT_ORGANIZATION foreign key (ORGANIZATION_ID) references NEWTASK_ORGANIZATION(ID);
alter table NEWTASK_CONTRACT add constraint FK_NEWTASK_CONTRACT_STATUS foreign key (STATUS_ID) references NEWTASK_STATUS(ID);
create index IDX_NEWTASK_CONTRACT_ORGANIZATION on NEWTASK_CONTRACT (ORGANIZATION_ID);
