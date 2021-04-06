# Castle Explorer

A command line game where a player explores a castle, searches furniture, and collects items.

## Features

-[ x ] Accepts user input\n
    -[ x ] Game flows depending on user input
    -[ x ] Provide feedback to user based on decisions
-[ x ] Reads data from SQL database
    -[ x ] Utlizes Docker
    -[ x ] Converts data from database to class types
-[ ] Utilize Junit Jupiter for testing

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