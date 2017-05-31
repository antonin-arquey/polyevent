/* INSERT USERS */
INSERT INTO Users(email, password, firstName, lastName, departement) VALUES ('toto@gmail.com', 'toto', 'Jack', 'lopoto', 'ADMINISTRATION');

INSERT INTO Users(email, password, firstName, lastName, departement) VALUES ('jeremilehn@gmail.com', 'bash', 'jérémy', 'lehn', 'INFO');

INSERT INTO Users(email, password, firstName, lastName, departement) VALUES ('BernadettePastaure@gmail.com', 'fake', 'bernadette', 'pastaure', 'ETN');

/* INSERT AN ORGANIZATION */

INSERT INTO Organization(name, leader) VALUES ('Idesys', 3);

/* INSERT MEMBER IN AN ORGANIZATION */

INSERT INTO Members(user, organization) VALUES (3, 4);

/* EVENT CREATED BY AN USER */

INSERT INTO Events(name, summary, max_participants, creator_id, lieu) VALUES ('Gouter chez moi', 'Un bon petit gouter au calme', 20, 2, 'Polytech');

/* EVENT CREATED BY AN ORGANIZATION */

INSERT INTO Events(name, summary, max_participants, creator_id, lieu) VALUES ('Afterwork gros projets', 'On va se faire un max de thunes', 500, 4, 'Parc');

