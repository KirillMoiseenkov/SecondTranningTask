alter table NEWTASK_INVOICE add constraint FK_NEWTASK_INVOICE_STAGE foreign key (STAGE_ID) references NEWTASK_STAGE(ID);
