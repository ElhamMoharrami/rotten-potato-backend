# Rotten Potato Backend
## How to run
`mvn spring-boot:run`

## Apis
### Movies
`http://localhost:8080/api/movies`

`http://localhost:8080/api/movies?page={page-nember}&size={page-size}`

`http://localhost:8080/api/movies/{movie_id}`

`http://localhost:8080/api/movies/{movie_id}/crews`

`http://localhost:8080/api/movies/{movie_id}/crews/{crew_id}`

### Crews
`http://localhost:8080/api/crews`

`http://localhost:8080/api/crews?page={page-nember}&size={page-size}`

`http://localhost:8080/api/crews/{crew_id}`

`http://localhost:8080/api/crews/{crew_id}/movies`

`http://localhost:8080/api/crews/{crew_id}/movies/{movie_id}`

