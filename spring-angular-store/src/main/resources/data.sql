insert into role(
    id, altered_by, created_by, created_date, updated_date, name, removible
) values
(1, 'initial_data_system', 'initial_data_system', now(), now(), 'CREATE_PERSON', false),
(2, 'initial_data_system', 'initial_data_system', now(), now(), 'UPDATE_PERSON', false),
(3, 'initial_data_system', 'initial_data_system', now(), now(), 'DELETE_PERSON', false),
(4, 'initial_data_system', 'initial_data_system', now(), now(), 'RETRIEVE_ALL_PERSON', false),
(5, 'initial_data_system', 'initial_data_system', now(), now(), 'RETRIEVE_PERSON', false);

insert into profile(
    id, altered_by, created_by, created_date, updated_date, profile
) values
(1, 'initial_data_system', 'initial_data_system', now(), now(), 'ADMIN');

insert into profile_roles
select p.id, r.id from role r, profile p where p.id = 1;

insert into person(
    id, altered_by, created_by, created_date, updated_date,
    birthday, email, identity, login, name, password, profile_id
) values
(1, 'initial_data_system', 'initial_data_system', now(), now(), now(), 'admin@email.com', '000.000.000-00',
'system', 'system', '$2a$10$u7IdzbkYN3G3E1scByqVuu6oTzABVVID1YKKBjfJsV4/cAGPEssSS', 1);