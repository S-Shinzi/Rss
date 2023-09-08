create table sites (
	id int auto_increment primary key,
	name varchar(100) not null,
	uq_rss_link varchar(100) not null unique,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table article_categories (
	id int auto_increment primary key,
	name varchar(50) not null,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table parses (
	id int auto_increment primary key,
	site_id int not null,
	foreign key (site_id) references sites (id) on delete cascade on update cascade,
	element_parse varchar(100) not null,
	attribute_parse varchar(10) not null,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table articles (
	id int auto_increment primary key,
	title varchar(100) not null,
	uq_link varchar(100) not null unique,
	posted_at DATETIME NOT NULL,
	site_id int not null,
	foreign key (site_id) references sites (id) on delete cascade on update cascade,
	article_category_id int not null,
	foreign key (article_category_id) references article_categories (id) on delete cascade on update cascade,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table tag_groups (
	id int auto_increment primary key,
	uq_name varchar(100) not null unique,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table tags (
	id int auto_increment primary key,
	uq_name varchar(100) not null unique,
	kana varchar(100) not null,
	tag_group_id int not null,
	foreign key (tag_group_id) references tag_groups (id) on delete cascade on update cascade,
	parent_tag_id int,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table tag_search_words (
	id int auto_increment primary key,
	uq_serch_name varchar(50) not null unique,
	tag_id int not null,
	foreign key (tag_id) references tags (id) on delete cascade on update cascade,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table article_categories_tags (
	article_category_id int not null,
	foreign key (article_category_id) references article_categories (id) on delete cascade on update cascade,
	tag_id int not null,
	foreign key (tag_id) references tags (id) on delete cascade on update cascade,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table articles_tags (
	article_id int not null,
	foreign key (article_id) references articles (id) on delete cascade on update cascade,
	tag_id int not null,
	foreign key (tag_id) references tags (id) on delete cascade on update cascade,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);