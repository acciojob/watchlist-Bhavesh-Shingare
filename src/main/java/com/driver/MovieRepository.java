package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap;
    HashMap<String, Director> directorMap;
    HashMap<String,List<String>> movieDirectorMap;

    public MovieRepository() {

        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.movieDirectorMap = new HashMap<>();
    }

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
            if(movieDirectorMap.containsKey(directorName))
                movieDirectorMap.remove(directorName);
        }
        if(directorMap.containsKey(directorName))
            directorMap.remove(directorName);


//        List<String> movies = new ArrayList<String>();
//        if(directorMovieMapping.containsKey(director)){
//            movies = directorMovieMapping.get(director);
//            for(String movie: movies){
//                if(movieMap.containsKey(movie)){
//                    movieMap.remove(movie);
//                }
//            }
//
//            directorMovieMapping.remove(director);
//        }
//
//        if(directorMap.containsKey(director)){
//            directorMap.remove(director);
//        }


    }

    public void deleteAllDirectors() {
//        for (String dir: movieDirectorMap.keySet()) {
//            List<String> lis = movieDirectorMap.get(dir);
//            for (String name: lis) {
//                if(movieMap.containsKey(name)){
//                    movieMap.remove(name);
//                }
//            }
//            directorMap.remove(dir);
//        }
//        for (String d: directorMap.keySet()) {
//            directorMap.remove(d);
//        }

        HashSet<String> moviesSet = new HashSet<String>();

    //directorMap = new HashMap<>();

        for(String director: movieDirectorMap.keySet()){
            for(String movie: movieDirectorMap.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
}
}
