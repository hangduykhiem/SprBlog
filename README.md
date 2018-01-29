# SprBlog
A  Demo project to test out Spring Boot. 

## How to use this repo

To run the application, first create a postgres docker instance and expose it to localhost:
```bash
docker run -e POSTGRES_PASSWORD=thisisblog  -p 5432:5432 postgres:9.6-alpine
```

Connect to the database via psql with password `thisisblog`:
```bash
psql -h localhost -U postgres -W
```

Create a database call `blog_app`:
```SQL
CREATE DATABASE blog_app;
```

And then run the following:
```bash
./gradlew bootRun
```

Spring Boot will *magically* create a RESTful service serving at `localhost:8080/`.
The service contains the CRUD option at the endpoint `/api/blogs`

For more information, please read the code.