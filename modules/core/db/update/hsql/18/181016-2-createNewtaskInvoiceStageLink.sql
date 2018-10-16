alter table NEWTASK_INVOICE_STAGE_LINK add constraint FK_INVSTA_INVOICE foreign key (INVOICE_ID) references NEWTASK_INVOICE(ID);
alter table NEWTASK_INVOICE_STAGE_LINK add constraint FK_INVSTA_STAGE foreign key (STAGE_ID) references NEWTASK_STAGE(ID);
