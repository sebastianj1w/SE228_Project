create database ebook collate Chinese_PRC_CI_AS
go

create table books
(
	title varchar(50) not null,
	author varchar(50) not null,
	publisher varchar(50) not null,
	price numeric(8,2) not null,
	ID varchar(50) not null
		constraint bookBasic_pk
			primary key nonclustered,
	stock int,
	ISBN nchar(13) not null,
	rate float,
	words float,
	publishDate varchar(11),
	abstraction text,
	catalogue text
)
go

create unique index t_booklist_ID_uindex
	on books (ID)
go

create unique index t_booklist_ISBN_uindex
	on books (ISBN)
go

create table orders
(
	total money not null,
	userID varchar(50),
	orderID varchar(50) not null
		constraint orders_pk
			primary key nonclustered,
	state int,
	title varchar(500),
	date numeric(30)
)
go

create table items
(
	orderID varchar(50) not null
		constraint items_orders_orderID_fk
			references orders,
	bookID varchar(50) not null
		constraint items_books_ID_fk
			references books,
	amount int not null,
	value money not null
)
go

create unique index orders_orderID_uindex
	on orders (orderID)
go

create table users
(
	id varchar(50) not null
		constraint users_pk
			primary key nonclustered,
	iden varchar(10) not null,
	password varchar(50) not null,
	ban bit not null,
	mail varchar(50),
	cart varchar(2000)
)
go

create unique index t_userinfo_id_uindex
	on users (id)
go

