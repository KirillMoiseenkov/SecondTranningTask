alter table NEWTASK_INVOICE add constraint FK_NEWTASK_INVOICE_FILE foreign key (FILE_ID) references SYS_FILE(ID);
create index IDX_NEWTASK_INVOICE_FILE on NEWTASK_INVOICE (FILE_ID);
