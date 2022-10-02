# Rotten Potato Backend
## How to run
`mvn spring-boot:run`

## APIs

----
### Movies 

`http://localhost:8080/api/movies` <br/>
`http://localhost:8080/api/movies?page={page-nember}&size={page-size}` <br/>
`http://localhost:8080/api/movies/{movie_id}` <br/>
`http://localhost:8080/api/movies/{movie_id}/crews` <br/>
`http://localhost:8080/api/movies/{movie_id}/crews/{crew_id}` <br/>

#### search
`http://localhost:8080/api/movies/search/byTitle?title={keyword}&page={page-nember}&size={page-size}` <br/>
`http://localhost:8080/api/movies/search/byYear?from={from}&to={to}&page={page-nember}&size={page-size}` <br/>
`http://localhost:8080/api/movies/search/search?title={title}&minRate={min-rate}&yearFrom={year-from}&yearTo={year-to}&genre={genre}` <br/>

#### sort
Just add sort url-parameter to your url like:  `sort={field}` or `sort={field},desc` for descending sort.

Applicable to these urls:

`http://localhost:8080/api/movies` <br/>
`http://localhost:8080/api/movies/search/byTitle` <br/>
`http://localhost:8080/api/movies/search/byYear` <br/>

----
### Crews

`http://localhost:8080/api/crews` <br/>
`http://localhost:8080/api/crews?page={page-nember}&size={page-size}` <br/>
`http://localhost:8080/api/crews/{crew_id}` <br/>
`http://localhost:8080/api/crews/{crew_id}/movies` <br/>
`http://localhost:8080/api/crews/{crew_id}/movies/{movie_id}` <br/>

#### search
`http://localhost:8080/api/crews/search/byTitle?title={keyword}&page={page-nember}&size={page-size}` <br/>
`http://localhost:8080/api/crews/search/byProfession?profession={profession}&page={page-nember}&size={page-size}` <br/>
`http://localhost:8080/api/movies/search/search?name={name}&birthFrom={year-from}&birthTo={year-to}&profession={profession}` <br/>

Valid professions are:
`actor actress animation_department art_department art_director assistant assistant_director camera_department casting_department casting_director cinematographer composer costume_department costume_designer director editor editorial_department executive legal location_management make_up_department manager miscellaneous music_department producer production_designer production_manager programmer publicist script_department set_decorator sound_department soundtrack special_effects stunts talent_agent transportation_department visual_effects writer`

#### sort
Just add sort url-parameter to your url like:  `sort={field}` or `sort={field},desc` for descending sort.

Applicable to these urls:

`http://localhost:8080/api/crews` <br/>
`http://localhost:8080/api/crews/search/byTitle` <br/>
`http://localhost:8080/api/crews/search/byProfession` <br/>
