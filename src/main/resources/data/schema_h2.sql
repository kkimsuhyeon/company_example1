DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS file;

CREATE TABLE schedule
(
    schedule_id INTEGER NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    content varchar(255),
    color varchar(50) NOT NULL,
    repeat_unit varchar(50),
    alert_time INTEGER,
    start_time DATE,
    end_time DATE,
    PRIMARY KEY (schedule_id)
 );

 CREATE TABLE file
 (
    file_id INTEGER NOT NULL AUTO_INCREMENT,
    origin_name varchar(255) NOT NULL,
    stored_name varchar(255) NOT NULL,
    path varchar(255) NOT NULL,
    schedule_id INTEGER NOT NULL,
    PRIMARY KEY (file_id)
 )