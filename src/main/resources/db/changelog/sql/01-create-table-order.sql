--liquibase formatted sql

--changeset sergej:1
CREATE TABLE ORDERS
(
    ID               BIGSERIAL                      PRIMARY KEY,
    INVOICE_ID       BIGINT                         NOT NULL
);
