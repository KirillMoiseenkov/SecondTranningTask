alter table NEWTASK_SERVICE_COMPLETION_CERTIFICATE add constraint FK_NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILES foreign key (FILES_ID) references SYS_FILE(ID);
create index IDX_NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILES on NEWTASK_SERVICE_COMPLETION_CERTIFICATE (FILES_ID);
