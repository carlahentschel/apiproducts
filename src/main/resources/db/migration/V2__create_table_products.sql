create table products (
    id uuid primary key,
    name varchar(50) not null,
    price numeric(10,2) not null,
    stock int not null,
    id_brand uuid not null references brands(id),
    barcode int not null,
    image varchar(255)
);