create table NEWTASK_CONTRACT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CUSTOMER varchar(255),
    STATE varchar(255),
    ORGANIZATION_ID uuid,
    PERFORMER varchar(255),
    NUMBER_ integer,
    SINGLE_DATE date,
    DATE_FROM date,
    DATE_TO date,
    AMOUNT integer,
    VAT boolean,
    TOTAL_AMOUNT integer,
    CUSTOMER_SINGLE varchar(255),
    PERFORMER_SINGLE varchar(255),
    STATUS_ID uuid,
    --
    primary key (ID)
);
