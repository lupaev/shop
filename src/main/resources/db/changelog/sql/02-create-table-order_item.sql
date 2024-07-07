--liquibase formatted sql

--changeset sergej:1
CREATE TABLE ORDERS_ITEMS
(
    ID             BIGSERIAL                     PRIMARY KEY,
    PRICE          FLOAT,
    QUANTITY       INTEGER,
    ORDERS_ID      BIGINT,
    CONSTRAINT FK_ORDERS_ID FOREIGN KEY (ORDERS_ID) REFERENCES ORDERS (ID)
);


