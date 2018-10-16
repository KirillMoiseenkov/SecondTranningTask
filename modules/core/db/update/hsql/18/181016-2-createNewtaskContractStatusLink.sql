alter table NEWTASK_CONTRACT_STATUS_LINK add constraint FK_CONSTA_CONTRACT foreign key (CONTRACT_ID) references NEWTASK_CONTRACT(ID);
alter table NEWTASK_CONTRACT_STATUS_LINK add constraint FK_CONSTA_STATUS foreign key (STATUS_ID) references NEWTASK_STATUS(ID);
