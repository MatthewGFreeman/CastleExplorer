# Castle Explorer

An interactive command line game where a player explores a castle, searches furniture, and collects items.
Explore the castle and find furniture items.
Search the furniture items and fill your bag with 3 collectible items to win.

## Features
- [x] Accepts user input
    - [x] Game flows depending on user input
    - [x] Provide feedback to user based on decisions
- [x] Random chance of finding item
- [x] Reads data from SQL database
    - [x] Utlizes Docker
    - [x] Converts data from database to class types
- [ ] Writes data to SQL database
    - [x] Inserts items into database
    - [ ] Saves user information
        - [ ] Writes user name to database
        - [ ] Saves a score for a user to database 
- [x] Utilize JUnit for testing

## How to Play

What do you need to play?
- [ ] Docker (https://www.docker.com/get-started)
- [ ] Gradle (https://gradle.org/install/) (Instructions to install Java are provided at this link)


Database: Run and Load data in Docker environment and Access data
```bash
# To ensure all necessary drivers and dependencies are intalled:
gradle build

# In resources folder:
docker build -t castle .

# In another prompt:
docker run -d -e POSTGRES_PASSWORD=p4ssw0rd -p 5432:5432 castle

# To get the container name:
docker ps

# To access database in command line where <container-name> is from list generated from above:
docker exec -it <container-name> psql -U castle
```

Castle Explorer Game: Test, Run and Play
```bash
# To run test:
gradle test

# To begin game:
./gradlew run
```

## Issues

If you run into any issues, have comments, or ideas for future development, plese submit a pull request.
A link on how to submit a pull request on GitHub is provided below.

Creating a pull request - https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request

