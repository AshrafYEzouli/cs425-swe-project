package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Movie;
import cs425.project.moviemail.service.AdminService;
import cs425.project.moviemail.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MovieService movieService;

    public void addAdmin() {

    }

    public void Login() {

    }

    public void addCustomer() {

    }

    public void getAllCustomers() {

    }

    @GetMapping(value = "/addmovies")
    public ModelAndView getMovieForm() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("movie",new Movie());
        modelAndView.setViewName("movieadd");
        return modelAndView;
    }

    @PostMapping(value = "/addmovies")
    public String addMovie(@ModelAttribute("movie") Movie movie) {

 //       movieService.
        return "redirect:/movies";
    }

    //added by SY
    @GetMapping(value = {"/movies"})
    public ModelAndView getAllMovies() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("movies", movieService.getAllMovie());
        modelAndView.setViewName("movie");
        return modelAndView;

    }
}
