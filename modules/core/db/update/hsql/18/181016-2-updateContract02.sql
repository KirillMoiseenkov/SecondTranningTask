alter table NEWTASK_CONTRACT add column STATUS_ID varchar(36) ;
alter table NEWTASK_CONTRACT drop column STAGE_ID cascade ;
