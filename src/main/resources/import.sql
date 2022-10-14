DROP TABLE IF EXISTS customers;
CREATE TABLE IF NOT EXISTS customers(id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('Bob'), ('Jack'), ('Miki'), ('John');

DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products(id bigserial, price int, title VARCHAR(255), cust_id int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Milk', 80), ('Cream', 60), ('Carrot', 30), ('Bread', 12), ('Potato', 25);

-- DROP TABLE IF EXISTS orders;
-- CREATE TABLE IF NOT EXISTS orders();
-- INSERT INTO products (title, price) VALUES ('Milk', 80), ('Cream', 60), ('Carrot', 30);
