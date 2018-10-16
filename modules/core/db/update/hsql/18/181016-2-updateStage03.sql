alter table NEWTASK_STAGE add constraint FK_NEWTASK_STAGE_INVOICE foreign key (INVOICE_ID) references NEWTASK_INVOICE(ID);
