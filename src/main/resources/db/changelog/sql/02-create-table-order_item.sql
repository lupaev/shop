--liquibase formatted sql

--changeset sergej:1
CREATE TABLE ORDER_ITEM
(
    ID             BIGSERIAL                     PRIMARY KEY,
    PRICE          NUMERIC,
    QUANTITY       INTEGER
);

--changeset sergej:2
ALTER TABLE ORDER ADD CONSTRAINT FK_ORDER_ITEM_ID FOREIGN KEY (ORDER_ITEM_ID) REFERENCES ORDER_ITEM (ID);

