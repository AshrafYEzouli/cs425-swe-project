package cs425.project.moviemail.service;
import cs425.project.moviemail.model.Movie;
import org.springframework.stereotype.Service;


public interface MovieService {
    public abstract Iterable<Movie> getAllMovie();


    public abstract Movie addNewMovie(Movie movie);
    //public abstract Movie getBookById(Long movieId);
  //  Movie updateMovieById(Long movieId);

}
