CREATE TABLE IF NOT EXISTS COLOR_TABLE (
    id INT PRIMARY KEY,
    parent_id INT,
    name VARCHAR(255),
    color VARCHAR(255)
);


INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (1L, 0L, 'Warrior', 'red');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (2, 0, 'Wizard', 'green');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (3, 0, 'Priest', 'white');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (4, 0, 'Rogue', 'yellow');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (5, 1, 'Fighter', 'blue');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (6, 1, 'Paladin', 'lightblue');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (7, 1, 'Ranger', 'lightgreen');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (8, 2, 'Mage', 'grey');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (9, 2, 'Specialist wizard', 'lightgrey');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (10, 3, 'Cleric', 'red');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (11, 3, 'Druid', 'green');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (12, 3, 'Priest of specific mythos', 'white');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (13, 4, 'Thief', 'yellow');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (14, 4, 'Bard', 'blue');
INSERT INTO COLOR_TABLE (id, parent_id, name, color) VALUES (15, 13, 'Assassin', 'lightblue');