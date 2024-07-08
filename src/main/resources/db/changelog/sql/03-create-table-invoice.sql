--liquibase formatted sql

--changeset sergej:1
CREATE TABLE INVOICE
(
    ID                      BIGSERIAL                     PRIMARY KEY,
    PAYMENT_AMOUNT          FLOAT,
    ORDERS_ID                BIGINT,
    PAYMENT_RESULT_ID       BIGINT,
    CONSTRAINT FK_ORDER_ID FOREIGN KEY (ORDERS_ID) REFERENCES ORDERS (ID)
);
