-- noinspection SqlNoDataSourceInspectionForFile
SET MODE Oracle;

CREATE TABLE EXAMPLE_ENTITY (
  ID NUMBER(5) PRIMARY KEY,
  NAME        VARCHAR(255)
);

CREATE SEQUENCE SEQ_ID INCREMENT BY 1 NOCYCLE;
