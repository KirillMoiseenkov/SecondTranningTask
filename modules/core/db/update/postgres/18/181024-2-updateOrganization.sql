alter table NEWTASK_ORGANIZATION rename column contract_id to contract_id__u11306 ;
drop index IDX_NEWTASK_ORGANIZATION_CONTRACT ;
alter table NEWTASK_ORGANIZATION drop constraint FK_NEWTASK_ORGANIZATION_CONTRACT ;
