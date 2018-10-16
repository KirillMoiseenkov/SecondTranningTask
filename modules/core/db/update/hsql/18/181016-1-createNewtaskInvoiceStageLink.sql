create table NEWTASK_INVOICE_STAGE_LINK (
    INVOICE_ID varchar(36) not null,
    STAGE_ID varchar(36) not null,
    primary key (INVOICE_ID, STAGE_ID)
);
