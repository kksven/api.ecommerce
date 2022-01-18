CREATE TABLE BRAND (
    brand_id int NOT NULL AUTO_INCREMENT COMMENT 'primary key',
    name varchar(255) NOT NULL COMMENT 'brand name',
    PRIMARY KEY (brand_id));

CREATE TABLE PRICES (
    price_list int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'primary key',
    product_id int NOT NULL COMMENT 'product identify',
    brand_id int NOT NULL COMMENT 'brand identify',
    start_date datetime NOT NULL COMMENT 'Start date price',
    end_date datetime NOT NULL COMMENT 'End date price',
    priority int NOT NULL COMMENT 'Defines price priority',
    price double NOT NULL COMMENT 'product price',
    curr varchar(3) NOT NULL COMMENT 'Currency price');

ALTER TABLE PRICES ADD FOREIGN KEY (brand_id) REFERENCES BRAND(brand_id);

INSERT INTO BRAND (NAME) values ('Zara');
INSERT INTO BRAND (NAME) values ('Pull&Bear');

INSERT INTO PRICES (price_list, product_id, brand_id, start_date, end_date, priority, price, curr)
VALUES ('1', '35455', '1', '2020-06-14 00.00.00', '2020-12-31 23.59.59', '0', '35.50', 'EUR');

INSERT INTO PRICES (price_list, product_id, brand_id, start_date, end_date, priority, price, `curr`)
VALUES ('2', '35455', '1', '2020-06-14 15.00.00', '2020-06-14 18.30.59', '1', '25.45', 'EUR');

INSERT INTO PRICES (price_list, product_id, brand_id, start_date, end_date, priority, price, `curr`)
VALUES ('3', '35455', '1', '2020-06-15 00.00.00', '2020-06-15 11.00.00', '1', '30.50', 'EUR');

INSERT INTO PRICES (price_list, product_id, brand_id, start_date, end_date, priority, price, curr)
VALUES ('4', '35455', '1', '2020-06-15 16.00.00', '2020-12-31 23.59.59', '1', '38.95', 'EUR');

INSERT INTO PRICES (price_list, product_id, brand_id, start_date, end_date, priority, price, `curr`)
VALUES ('5', '35455', '2', '2020-06-15 00.00.00', '2020-12-31 23.59.59', '1', '25.00', 'EUR');


