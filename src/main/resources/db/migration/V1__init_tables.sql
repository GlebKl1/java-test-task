create table tariffs (
    id              uuid not null,
    creation_date   date not null,
    name            character varying(128),
    is_archived     boolean default false,
    is_deleted      boolean default false,
    primary key (id)
);

create table package_services (
    id              uuid not null,
    creation_date   date not null,
    name            character varying(128),
    category        character varying(20),
    value           integer,
    tariff_id       uuid,
    is_deleted      boolean default false,
    primary key (id),
    foreign key (tariff_id) references tariffs(id)
);