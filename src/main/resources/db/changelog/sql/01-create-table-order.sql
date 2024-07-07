--liquibase formatted sql

--changeset sergej:1
CREATE TABLE ORDER
(
    ID             BIGSERIAL                      PRIMARY KEY,
    ORDER_ITEM_ID  BIGINT                         NOT NULL,
    INVOICE_ID     BIGINT                         NOT NULL
);
