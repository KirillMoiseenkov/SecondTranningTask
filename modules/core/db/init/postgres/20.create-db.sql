-- begin NEWTASK_CONTRACT
alter table NEWTASK_CONTRACT add constraint FK_NEWTASK_CONTRACT_ORGANIZATION foreign key (ORGANIZATION_ID) references NEWTASK_ORGANIZATION(ID)^
alter table NEWTASK_CONTRACT add constraint FK_NEWTASK_CONTRACT_STATUS foreign key (STATUS_ID) references NEWTASK_STATUS(ID)^
create index IDX_NEWTASK_CONTRACT_ORGANIZATION on NEWTASK_CONTRACT (ORGANIZATION_ID)^
-- end NEWTASK_CONTRACT
-- begin NEWTASK_STAGE
alter table NEWTASK_STAGE add constraint FK_NEWTASK_STAGE_CONTRACT foreign key (CONTRACT_ID) references NEWTASK_CONTRACT(ID)^
alter table NEWTASK_STAGE add constraint FK_NEWTASK_STAGE_INVOICE foreign key (INVOICE_ID) references NEWTASK_INVOICE(ID)^
alter table NEWTASK_STAGE add constraint FK_NEWTASK_STAGE_SERVICE_COMPLETION_CERTIFICATE foreign key (SERVICE_COMPLETION_CERTIFICATE_ID) references NEWTASK_SERVICE_COMPLETION_CERTIFICATE(ID)^
create index IDX_NEWTASK_STAGE_CONTRACT on NEWTASK_STAGE (CONTRACT_ID)^
-- end NEWTASK_STAGE
-- begin NEWTASK_SERVICE_COMPLETION_CERTIFICATE
alter table NEWTASK_SERVICE_COMPLETION_CERTIFICATE add constraint FK_NEWTASK_SERVICE_COMPLETION_CERTIFICATE_STAGE foreign key (STAGE_ID) references NEWTASK_STAGE(ID)^
-- end NEWTASK_SERVICE_COMPLETION_CERTIFICATE
-- begin NEWTASK_INVOICE
alter table NEWTASK_INVOICE add constraint FK_NEWTASK_INVOICE_STAGE foreign key (STAGE_ID) references NEWTASK_STAGE(ID)^
-- end NEWTASK_INVOICE
-- begin NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK
alter table NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK add constraint FK_SERCOMCERFILDES_SERVICE_COMPLETION_CERTIFICATE foreign key (SERVICE_COMPLETION_CERTIFICATE_ID) references NEWTASK_SERVICE_COMPLETION_CERTIFICATE(ID)^
alter table NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK add constraint FK_SERCOMCERFILDES_FILE_DESCRIPTOR foreign key (FILE_DESCRIPTOR_ID) references SYS_FILE(ID)^
-- end NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK
-- begin NEWTASK_INVOICE_FILE_DESCRIPTOR_LINK
alter table NEWTASK_INVOICE_FILE_DESCRIPTOR_LINK add constraint FK_INVFILDES_INVOICE foreign key (INVOICE_ID) references NEWTASK_INVOICE(ID)^
alter table NEWTASK_INVOICE_FILE_DESCRIPTOR_LINK add constraint FK_INVFILDES_FILE_DESCRIPTOR foreign key (FILE_DESCRIPTOR_ID) references SYS_FILE(ID)^
-- end NEWTASK_INVOICE_FILE_DESCRIPTOR_LINK
-- begin NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK
alter table NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK add constraint FK_CONFILDES_CONTRACT foreign key (CONTRACT_ID) references NEWTASK_CONTRACT(ID)^
alter table NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK add constraint FK_CONFILDES_FILE_DESCRIPTOR foreign key (FILE_DESCRIPTOR_ID) references SYS_FILE(ID)^
-- end NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK
