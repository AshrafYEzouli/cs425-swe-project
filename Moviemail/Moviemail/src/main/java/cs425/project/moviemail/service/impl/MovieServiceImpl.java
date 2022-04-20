package cs425.project.moviemail.service.impl;

import cs425.project.moviemail.model.Movie;
import cs425.project.moviemail.repository.MovieRepository;
import cs425.project.moviemail.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovie() { return movieRepository.findAll();}

    @Override
    public Movie addNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
