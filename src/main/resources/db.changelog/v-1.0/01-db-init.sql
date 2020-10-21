CREATE TYPE type AS ENUM ('event', 'warning', 'error');

GO

create table IF NOT EXISTS projects
(
    id int not null generated always
        as identity primary key,
    name varchar(50) not null
);

GO

create table IF NOT EXISTS devices
(
    id int not null generated always
        as identity primary key,
    project_id int not null ,
    serial_number varchar(50),
    foreign key (project_id) references projects(id)
);

GO

create table IF NOT EXISTS events
(
    id int not null generated always
        as identity primary key,
    device_id int not null,
    date date not null,
    type type,
    is_read boolean not null,
    foreign key (device_id) references devices(id)
);

GO