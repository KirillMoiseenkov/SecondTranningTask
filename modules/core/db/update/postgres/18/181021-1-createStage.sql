create table NEWTASK_STAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    DATE_FROM date,
    DATE_TO date,
    AMOUNT integer,
    VAT integer,
    TOTAL_AMOUNT integer,
    DESCRIPTION varchar(255),
    CONTRACT_ID uuid,
    INVOICE_ID uuid,
    --
    primary key (ID)
);
