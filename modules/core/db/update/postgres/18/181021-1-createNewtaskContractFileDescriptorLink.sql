create table NEWTASK_CONTRACT_FILE_DESCRIPTOR_LINK (
    CONTRACT_ID uuid,
    FILE_DESCRIPTOR_ID uuid,
    primary key (CONTRACT_ID, FILE_DESCRIPTOR_ID)
);
