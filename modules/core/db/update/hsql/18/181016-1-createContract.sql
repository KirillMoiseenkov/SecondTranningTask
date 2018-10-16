create table NEWTASK_CONTRACT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CUSTOMER varchar(255),
    ORGANIZATION_ID varchar(36),
    PERFORMER varchar(255),
    NUMBER_ integer,
    SINGLE_DATE date,
    DATE_FROM date,
    DATE_TO date,
    AMOUNT integer,
    VAT integer,
    TOTAL_AMOUNT integer,
    CUSTOMER_SINGLE varchar(255),
    PERFORMER_SINGLE varchar(255),
    FILE_ varchar(255),
    --
    primary key (ID)
);
