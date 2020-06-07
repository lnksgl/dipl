create sequence hibernate_sequence start 1 increment 1;

create table users (
    id int8 not null,
    username varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
	scanUser varchar(255),
	scanDocument varchar(255),
    primary key (id)
);

create table groups (
    id int8 not null,
    name varchar(255) not null,
    content text not null,
    average varchar(255) default '0',
    primary key (id)
);

create table enquiry (
	id int8 not null,
	idUsers int8 not null,
	idGroups int8 not null,
	created_on timestamp,
	constraint enquiry_users_id_fk FOREIGN KEY (idUsers) references users (id),
	constraint enquiry_groups_id_fk FOREIGN KEY (idGroups) references groups (id),
    primary key (id)
);
