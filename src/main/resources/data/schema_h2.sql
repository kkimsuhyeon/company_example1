DROP TABLE IF EXISTS schedule;

CREATE TABLE schedule
(
    schedule_id INTEGER NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    content varchar(255),
    color varchar(50) NOT NULL,
    PRIMARY KEY (schedule_id)
 );