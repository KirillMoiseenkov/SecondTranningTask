alter table NEWTASK_CONTRACT add constraint FK_NEWTASK_CONTRACT_STAGE foreign key (STAGE_ID) references NEWTASK_STAGE(ID);
