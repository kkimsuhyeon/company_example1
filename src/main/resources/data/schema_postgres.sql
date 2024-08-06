DROP TABLE IF EXISTS schedule;

CREATE TABLE schedule
(
    schedule_id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    content varchar(255),
    color varchar(50) NOT NULL
);