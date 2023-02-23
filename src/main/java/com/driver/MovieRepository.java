package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap = new HashMap<>();
    HashMap<String, Director> directorMap = new HashMap<>();
    HashMap<String,List<String>> movieDirectorMap = new HashMap<>();

    public void addMovie(Movie name) {
        String movieName= name.getName();
        movieMap.put(movieName,name);
    }

    public void addDirector(Director name) {
        String directorName= name.getName();
        directorMap.put(directorName,name);
    }

    public void addMovieDirectorPair(String movie, String director) {
        List<String> movieList = new ArrayList<>();
        if(movieDirectorMap.containsKey(director)){
            movieList = movieDirectorMap.get(movie);
            movieList.add(movie);
            movieDirectorMap.put(director,movieList);
        }
        else{
            movieList.add(movie);
            movieDirectorMap.put(director,movieList);
        }
    }

    public Movie getMovieByName(String movieName) {
        for(String mName: movieMap.keySet()){
            if(mName.equals(movieName))
                return movieMap.get(mName);
        }
        return null;
    }

    public Director getDirectorByName(String directorName) {
        for(String dName: directorMap.keySet()){
            if(dName.equals(directorName)){
                return directorMap.get(dName);
            }
        }
        return  null;
    }

    public List<String> getMovieByDirectorName(String dName) {
        if(movieDirectorMap.containsKey(dName)){
           return movieDirectorMap.get(dName);
        }
        return null;
    }

    public List<String> findAllMovies() {
        List<String> allMovies = new ArrayList<>();
        for(String movie: movieMap.keySet()){
            allMovies.add(movie);
        }
        return allMovies;
    }

    public void deleteDirectorByName(String directorName) {
        List<String> dirList = new ArrayList<>();
        if(movieDirectorMap.containsKey(directorName)){
            dirList= movieDirectorMap.get(directorName);
            for(String movie : dirList){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }
            if(directorMap.containsKey(directorName))
                directorMap.remove(directorName);
        }
        if(movieDirectorMap.containsKey(directorName))
            movieDirectorMap.remove(directorName);


    }

    public void deleteAllDirectors() {
        for (String dir: movieDirectorMap.keySet()) {
            List<String> lis = movieDirectorMap.get(dir);
            for (String name: lis) {
                if(movieMap.containsKey(name)){
                    movieMap.remove(name);
                }
            }
            directorMap.remove(dir);
        }
        for (String d: directorMap.keySet()) {
            directorMap.remove(d);
        }

    }
}
