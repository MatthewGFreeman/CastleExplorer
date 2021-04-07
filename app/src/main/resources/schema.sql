CREATE TABLE collectible (
    ID SERIAL PRIMARY KEY,
    collectibleName varchar(25)
);

CREATE TABLE furniture (
    ID SERIAL PRIMARY KEY,
    furnitureName varchar(25)
);

-- Creating collectible items
INSERT INTO collectible (collectibleName) VALUES ('Gem');
INSERT INTO collectible (collectibleName) VALUES ('Ring');
INSERT INTO collectible (collectibleName) VALUES ('Necklace');

-- Creating furniture items
INSERT INTO furniture (furnitureName) VALUES ('Locker');
INSERT INTO furniture (furnitureName) VALUES ('Dresser');
INSERT INTO furniture (furnitureName) VALUES ('Bookcase');
INSERT INTO furniture (furnitureName) VALUES ('Chair');
INSERT INTO furniture (furnitureName) VALUES ('Chest');

