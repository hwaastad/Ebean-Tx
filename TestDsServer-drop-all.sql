alter table t_contact drop constraint if exists fk_t_contact_customer_id;
drop index if exists ix_t_contact_customer_id;

drop table if exists t_contact;

drop table if exists t_customer;

