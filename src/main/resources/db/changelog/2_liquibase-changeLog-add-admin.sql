--liquibase formatted sql

--Changeset smirshin-ao:2

INSERT INTO users VALUES ('admin', '$2y$10$7syobYf0wGd.dGjNyKzfdOsKsnMsORJ9OZ2Eu0OcE.bqDEFeXTTmq', true);

INSERT INTO authorities VALUES ('admin', 'ROLE_ADMIN');