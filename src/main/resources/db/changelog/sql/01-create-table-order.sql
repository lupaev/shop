--liquibase formatted sql

--changeset sergej:1
CREATE TABLE ORDER
(
    ID             BIGSERIAL                     PRIMARY KEY,
    CAR_NUM        VARCHAR(20)                   NOT NULL,
    INVOICE_NUM    VARCHAR(25),
    SHIP_DATE      DATE,
    CONTRACT_NUM   VARCHAR(20),
    IS_LOAD        INT
);
