alter table NEWTASK_CONTRACT add constraint FK_NEWTASK_CONTRACT_STATUS foreign key (STATUS_ID) references NEWTASK_STATUS(ID);
