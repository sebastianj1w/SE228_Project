create schema dbo
go

create table t_booklist
(
	title varchar(50) not null,
	author varchar(50) not null,
	publisher varchar(50) not null,
	price numeric(8,2) not null,
	ID varchar(15) not null,
	stock int,
	ISBN nchar(13) not null
)
go

create table t_bookdetail
(
	ID varchar(15) not null
		constraint t_bookdetail_t_booklist_ID_fk
			references t_booklist (ID),
	rate float,
	publishDate varchar(11),
	words float,
	abstraction text,
	catalogue text
)
go

create unique index t_booklist_ID_uindex
	on t_booklist (ID)
go

create unique index t_booklist_ISBN_uindex
	on t_booklist (ISBN)
go

create table t_items
(
	orderID varchar(20) not null,
	bookID varchar(15) not null
		constraint t_items_t_booklist_ID_fk
			references t_booklist (ID),
	amount int not null,
	value money not null
)
go

create table t_userinfo
(
	id varchar(50) not null,
	iden varchar(10) not null,
	password varchar(50) not null,
	ban bit not null,
	mail varchar(50)
)
go

create table t_order
(
	orderID varchar(20) not null,
	total money not null,
	userID varchar(50)
		constraint t_order_t_userinfo_id_fk
			references t_userinfo (id)
)
go

create unique index t_order_orderID_uindex
	on t_order (orderID)
go

create unique index t_userinfo_id_uindex
	on t_userinfo (id)
go

