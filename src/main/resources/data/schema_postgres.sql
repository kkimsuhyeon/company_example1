DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS attachment;

CREATE TABLE schedule
(
    schedule_id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    content varchar(255),
    color varchar(50) NOT NULL,
    repeat_unit varchar(50),
    alert_time INTEGER,
    start_time TIMESTAMP,
    end_time TIMESTAMP
 );

 CREATE TABLE attachment
 (
    attachment_id SERIAL PRIMARY KEY,
    origin_name varchar(255) NOT NULL,
    stored_name varchar(255) NOT NULL,
    path varchar(255) NOT NULL,
    schedule_id INTEGER NOT NULL
 )