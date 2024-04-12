create table AUTHOR (
    id bigint primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255)
);

create table BOOK (
    id bigint primary key auto_increment,
    name varchar(255),
    summary varchar(255)
);

create table AUTHOR_BOOK (
    author_id bigint,
    book_id bigint,
    constraint fk_author_book_author_id foreign key (author_id) references author(id),
    constraint fk_author_book_book_id foreign key (book_id) references book(id)
);
