BEGIN;

DROP TABLE IF EXISTS consumers_products CASCADE;
DROP TABLE IF EXISTS products CASCADE;
--DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS consumers CASCADE;

CREATE TABLE consumers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO consumers (name) VALUES ('Иванов');
INSERT INTO consumers (name) VALUES ('Петров');
INSERT INTO consumers (name) VALUES ('Сидоров');

CREATE TABLE products (id bigserial PRIMARY KEY, title varchar(255), price int);
INSERT INTO products (title, price) VALUES ('milk', 79);
INSERT INTO products (title, price) VALUES ('bread', 24);
INSERT INTO products (title, price) VALUES ('cheese', 350);
INSERT INTO products (title, price) VALUES ('coca-cola', 69);
INSERT INTO products (title, price) VALUES ('butter', 220);


CREATE TABLE consumers_products (consumer_id bigint, product_id bigint, FOREIGN KEY (consumer_id) REFERENCES consumers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO consumers_products (consumer_id, product_id) VALUES (1, 1);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (1, 2);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (3, 3);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (2, 2);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (3, 1);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (2, 3);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (1, 5);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (2, 3);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (3, 5);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (2, 2);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (2, 4);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (1, 4);
INSERT INTO consumers_products (consumer_id, product_id) VALUES (3, 1);

COMMIT;