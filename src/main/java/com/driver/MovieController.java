package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie name){
        movieService.addMovie(name);
        return new ResponseEntity<>("New Movie Added", HttpStatus.CREATED);

    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director name){
        movieService.addDirector(name);
        return new ResponseEntity<>("New Director Added",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New Movie and Director Pair added", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        Movie movie = null;
        movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);

    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){
        Director director=null;
        director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String dName){
        List<String> movies= null;
        movies = movieService.getMovieByDirectorName(dName);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);

    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = null;
        movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(directorName+"Removed",HttpStatus.CREATED);

    }
    @DeleteMapping("/delete-all-directors")
    public  ResponseEntity<String>  deleteAllDirectors(){
        movieService. deleteAllDirectors();
        return new ResponseEntity<>("All directors removed", HttpStatus.CREATED);
    }







}
