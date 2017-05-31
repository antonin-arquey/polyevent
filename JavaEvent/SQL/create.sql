CREATE DATABASE IF NOT EXISTS Polytech_Event;
USE Polytech_Event;

CREATE USER 'java'@'localhost' IDENTIFIED BY 'events';
GRANT ALL ON Polytech_Event.* TO 'java'@'localhost' IDENTIFIED BY 'events';

CREATE TABLE IF NOT EXISTS Creators (
    creator_id INT(15) NOT NULL AUTO_INCREMENT,
    creator_type CHAR(1) NOT NULL
        CHECK (creator_type IN ('U', 'O')),
    PRIMARY KEY (creator_id),
    UNIQUE KEY (creator_id, creator_type)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Users (
    creator_id INT(15) NOT NULL,
    creator_type CHAR(1) NOT NULL
        DEFAULT 'U'
        CHECK (creator_type = 'U'),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    departement VARCHAR(50) NOT NULL,
    PRIMARY KEY (creator_id),
    UNIQUE (email),
    FOREIGN KEY (creator_id, creator_type)
        REFERENCES Creators (creator_id, creator_type)
        ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Events (
    id INT(15) NOT NULL AUTO_INCREMENT,
    max_participants INT(5) NOT NULL,
    name VARCHAR(255) NOT NULL,
    summary TEXT,
    creator_id INT(15) NOT NULL,
    lieu VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dateEvent TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (creator_id)
        REFERENCES Creators (creator_id)
        ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Participants (
    id INT(15) NOT NULL AUTO_INCREMENT,
    event INT(15) NOT NULL,
    user INT(15) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (event)
        REFERENCES Events(id)
        ON DELETE CASCADE,
    FOREIGN KEY (user)
        REFERENCES Users (creator_id)
        ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Organization (
    creator_id INT(15) NOT NULL,
    creator_type CHAR(1) NOT NULL
        DEFAULT 'O'
        CHECK (creator_type = 'O'),
    name VARCHAR(255) NOT NULL,
    leader INT(15) NOT NULL,
    PRIMARY KEY (creator_id),
    FOREIGN KEY (leader)
        REFERENCES Users (creator_id)
        ON DELETE CASCADE,
    FOREIGN KEY (creator_id, creator_type)
        REFERENCES Creators (creator_id, creator_type)
        ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Members (
    id INT(15) NOT NULL AUTO_INCREMENT,
    user INT(15) NOT NULL,
    organization INT(15) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (organization)
        REFERENCES Organization (creator_id)
        ON DELETE CASCADE,
    FOREIGN KEY (user)
        REFERENCES Users (creator_id)
        ON DELETE CASCADE
)ENGINE=INNODB;

DELIMITER //

CREATE TRIGGER Users_before_insert BEFORE INSERT ON `Users` FOR EACH ROW
    BEGIN
      INSERT INTO Creators(creator_type) VALUES('U');
        SET NEW.creator_id = (SELECT creator_id FROM Creators ORDER BY creator_id DESC LIMIT 1);
    END//

CREATE TRIGGER Organization_before_insert BEFORE INSERT ON `Organization` FOR EACH ROW
    BEGIN
      INSERT INTO Creators(creator_type) VALUES('O');
        SET NEW.creator_id = (SELECT creator_id FROM Creators ORDER BY creator_id DESC LIMIT 1);
    END//


CREATE TRIGGER Users_after_delete AFTER DELETE ON `Users` FOR EACH ROW
    BEGIN
        DELETE FROM Creators WHERE Creators.creator_id = old.creator_id;
    END//

CREATE TRIGGER Organization_after_delete AFTER DELETE ON `Organization` FOR EACH ROW
    BEGIN
        DELETE FROM Creators WHERE Creators.creator_id = old.creator_id;
    END//
DELIMITER ;
