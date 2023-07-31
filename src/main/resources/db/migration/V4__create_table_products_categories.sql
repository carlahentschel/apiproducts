create table products_categories(
    id uuid primary key,
    id_product uuid references products(id) not null,
    id_categories uuid references categories(id) not null
);