create table NEWTASK_INVOICE (
    ID uuid,
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
    STAGE_ID uuid,
    --
    primary key (ID)
);
