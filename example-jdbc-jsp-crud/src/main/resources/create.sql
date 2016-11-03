CREATE SCHEMA movieinfo;

CREATE SEQUENCE movieinfo.MOVIES_SEQ;

CREATE TABLE movieinfo.movies
(
  mov_id INTEGER PRIMARY KEY NOT NULL,
  mov_name VARCHAR(255),
  mov_cat VARCHAR(255),
  mov_sales_millions INTEGER
);

CREATE TABLE movieinfo.users
(
  usr_id INTEGER PRIMARY KEY NOT NULL,
  usr_name VARCHAR(255),
  usr_pass VARCHAR(255)
);