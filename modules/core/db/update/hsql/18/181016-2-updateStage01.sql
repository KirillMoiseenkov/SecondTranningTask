alter table NEWTASK_STAGE add constraint FK_NEWTASK_STAGE_CONTRACT foreign key (CONTRACT_ID) references NEWTASK_CONTRACT(ID);
create index IDX_NEWTASK_STAGE_CONTRACT on NEWTASK_STAGE (CONTRACT_ID);