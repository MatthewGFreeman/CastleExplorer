# Castle Explorer

A command line game where a player explores a castle, searches furniture, and collects items.
Explore the castle and find furniture items.
Search the furniture items and fill your bag with 3 collectible items to win.

## Features
- [x] Accepts user input
    - [x] Game flows depending on user input
    - [x] Provide feedback to user based on decisions
- [x] Reads data from SQL database
    - [x] Utlizes Docker
    - [x] Converts data from database to class types
- [ ] Writes data to SQL database
    - [x] Inserts items into database
    - [ ] Saves user information
        - [ ] Writes user name to database
        - [ ] Saves a score for a user to database 
- [ ] Utilize JUnit Jupiter for testing

## How to Play

Database: Run and Load data in Docker environment and Access data
```bash
# In resources folder:
docker build -t castle

# In another prompt:
docker run -d -e POSTGRES_PASSWORD=p4ssw0rd -p 5432:5432 castle

# To get the container name:
docker ps

# To access database in command line where <container-name> is from list generated from above:
docker exec -it <container-name> psql -U castle
```

Castle Explorer Game: Run and Play
```bash
# To begin game:
./gradlew run
```