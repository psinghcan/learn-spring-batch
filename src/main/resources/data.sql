DROP TABLE IF EXISTS person;

CREATE TABLE person  (
                         person_id INTEGER PRIMARY KEY AUTOINCREMENT ,
                         first_name VARCHAR(40),
                         last_name VARCHAR(40),
                         email VARCHAR(100),
                         age INT
);