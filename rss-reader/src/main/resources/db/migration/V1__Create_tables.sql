create table site_types (
	id int auto_increment primary key,
	type varchar(20) not null,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table sites (
	id int auto_increment primary key,
	name varchar(100) not null,
	uq_rss_link varchar(100) not null unique,
	type_id int not null,
	foreign key (type_id) references site_types (id) on delete cascade on update cascade,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);