create database ebook collate Chinese_PRC_CI_AS
go

create table bookBasic
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

create unique index t_booklist_ID_uindex
	on bookBasic (ID)
go

create unique index t_booklist_ISBN_uindex
	on bookBasic (ISBN)
go

create table bookDetail
(
	ID varchar(15) not null
		constraint t_bookdetail_t_booklist_ID_fk
			references bookBasic (ID),
	rate float,
	publishDate varchar(11),
	words float,
	abstraction text,
	catalogue text
)
go

create table items
(
	orderID int not null
		constraint t_items_t_order_orderID_fk
			references t_order (orderID),
	bookID varchar(15) not null
		constraint t_items_t_booklist_ID_fk
			references booklist (ID),
	amount int not null,
	value money not null
)
go

create table orders
(
	total money not null,
	userID varchar(50)
		constraint t_order_t_userinfo_id_fk
			references [user] (id),
	orderID int identity
)
go

create unique index t_order_orderID_uindex
	on orders (orderID)
go

create table users
(
	id varchar(50) not null,
	iden varchar(10) not null,
	password varchar(50) not null,
	ban bit not null,
	mail varchar(50)
)
go

create unique index t_userinfo_id_uindex
	on users (id)
go

