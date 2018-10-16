create table NEWTASK_CONTRACT_STATUS_LINK (
    CONTRACT_ID varchar(36) not null,
    STATUS_ID varchar(36) not null,
    primary key (CONTRACT_ID, STATUS_ID)
);
