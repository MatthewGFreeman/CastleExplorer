CREATE TABLE collectibles (
    ID SERIAL PRIMARY KEY,
    prettyThing varchar(25)
);

CREATE TABLE furnishings (
    ID SERIAL PRIMARY KEY,
    furnitureName varchar(25)
);

CREATE TABLE players (
    ID SERIAL PRIMARY KEY,
    playerName varchar(35);
    score INT
);