--liquibase formatted sql

--Changeset smirshin-ao:1

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users
(
    username      varchar(50)  NOT NULL PRIMARY KEY,
    password_hash varchar(100) NOT NULL,
    enabled       boolean      NOT NULL DEFAULT false
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL PRIMARY KEY REFERENCES users (username),
    authority VARCHAR(50) NOT NULL,
    UNIQUE (username, authority)
);

CREATE TABLE verifications
(
    token    uuid        NOT NULL PRIMARY KEY,
    username VARCHAR(50) NOT NULL REFERENCES users (username)
);