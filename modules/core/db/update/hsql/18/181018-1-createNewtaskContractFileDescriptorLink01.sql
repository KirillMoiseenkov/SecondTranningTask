create table NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK (
    CONTRACT_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (CONTRACT_ID, FILE_DESCRIPTOR_ID)
);
