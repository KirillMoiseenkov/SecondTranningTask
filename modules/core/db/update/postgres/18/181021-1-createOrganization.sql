create table NEWTASK_ORGANIZATION (
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
    TAX_NUMBER integer,
    REGISTRATION_NUMBER integer,
    ESCAPE_VAT integer,
    --
    primary key (ID)
);
