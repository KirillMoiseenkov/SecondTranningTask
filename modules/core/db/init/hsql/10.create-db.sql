-- begin NEWTASK_ORGANIZATION
create table NEWTASK_ORGANIZATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TAX_NUMBER integer,
    REGISTRATION_NUMBER integer,
    ESCAPE_VAT integer,
    CONTRACT_ID varchar(36),
    --
    primary key (ID)
)^
-- end NEWTASK_ORGANIZATION
-- begin NEWTASK_STATUS
create table NEWTASK_STATUS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE integer,
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end NEWTASK_STATUS
-- begin NEWTASK_CONTRACT
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
    STATE varchar(255),
    ORGANIZATION_ID varchar(36),
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
    STATUS_ID varchar(36),
    --
    primary key (ID)
)^
-- end NEWTASK_CONTRACT
-- begin NEWTASK_STAGE
create table NEWTASK_STAGE (
    ID varchar(36) not null,
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
    CONTRACT_ID varchar(36),
    INVOICE_ID varchar(36),
    --
    primary key (ID)
)^
-- end NEWTASK_STAGE
-- begin NEWTASK_SERVICE_COMPLETION_CERTIFICATE
create table NEWTASK_SERVICE_COMPLETION_CERTIFICATE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ integer,
    DATE_ date,
    AMOUNT integer,
    VAT integer,
    TOTAL_AMOUNT integer,
    DESCRIPTION varchar(255),
    STAGE_ID varchar(36),
    --
    primary key (ID)
)^
-- end NEWTASK_SERVICE_COMPLETION_CERTIFICATE
-- begin NEWTASK_INVOICE
create table NEWTASK_INVOICE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ integer,
    DATE_ date,
    AMOUNT integer,
    VAT integer,
    TOTAL_AMOUNT integer,
    DESCRIPTION varchar(255),
    STAGE_ID varchar(36),
    --
    primary key (ID)
)^
-- end NEWTASK_INVOICE
-- begin NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK
create table NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK (
    CONTRACT_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (CONTRACT_ID, FILE_DESCRIPTOR_ID)
)^
-- end NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK
-- begin NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK
create table NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK (
    SERVICE_COMPLETION_CERTIFICATE_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (SERVICE_COMPLETION_CERTIFICATE_ID, FILE_DESCRIPTOR_ID)
)^
-- end NEWTASK_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK
-- begin NEWTASK_INVOICE_FILE_DESCRIPTOR_LINK
create table NEWTASK_INVOICE_FILE_DESCRIPTOR_LINK (
    INVOICE_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (INVOICE_ID, FILE_DESCRIPTOR_ID)
)^
-- end NEWTASK_INVOICE_FILE_DESCRIPTOR_LINK
