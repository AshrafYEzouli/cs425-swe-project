package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Cart;
import cs425.project.moviemail.model.Customer;
import cs425.project.moviemail.model.Movie;
import cs425.project.moviemail.model.Record;
import cs425.project.moviemail.service.CartService;
import cs425.project.moviemail.service.MovieService;
import cs425.project.moviemail.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cs425.project.moviemail.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/customer"})
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private CartService cartService;

    @Autowired
    private MovieService movieService;

    @GetMapping(value = {"/cart"})
    public ModelAndView goToCart() {
        var modelAndView = new ModelAndView();

        var carts = cartService.getAllCarts(1L);
        var movies = new ArrayList<Movie>();
        for (Cart cart: carts) {
            movies.add(movieService.getMovieById(cart.getMovie().getMovieId()));
        }

        modelAndView.addObject("movies", movies);
        modelAndView.setViewName("secured/admin/cart");

        return modelAndView;
    }

    @GetMapping(value = {"/checkout/{customerId}"})
    public String checkout(@PathVariable Long customerId, Model model) {
        Record record = new Record();
        record.setCheckOutDate(LocalDate.now());

        var carts = cartService.getAllCarts(customerId);
        var movies = new ArrayList<Movie>();
        for (Cart cart: carts) {
            movies.add(movieService.getMovieById(cart.getMovie().getMovieId()));
        }
        record.setMovies(movies);

        Customer customer = customerService.getCustomerById(customerId);
        record.setCustomer(customer);

        Record savedRecord = recordService.checkOut(record);
        if(savedRecord != null) {
            System.out.println("save record!");
            cartService.deleteCarts(carts);
        }
        return "redirect:/customer/cart";
    }

    @GetMapping(value = {"/addtocart/{movieId}"})
    public String addToCart(@PathVariable Long movieId, Model model) {
        var movie = movieService.getMovieById(movieId);
        Customer customer = customerService.getCustomerById(1L);

        if(movie != null && customer != null) {
            Cart cart = new Cart();
            cart.setMovie(movie);
            cart.setCustomer(customer);

            cartService.addToCart(cart);
        }
        return "redirect:/admin/movies";
    }

    public List<Record> getAllRecords() {
        return recordService.getAllRecords();
    }

    public List<Record> getAllRecordsByCustomerId(@PathVariable Long customerId, Model model) {
        return recordService.getAllRecordsByCustomerId(customerId);
    }

    @GetMapping(value = {"/listCustomer"})
    public ModelAndView listCustomers() {
        var modelAndView = new ModelAndView();
        var customers = customerService.getAllCustomer();
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customersCount", customers.size());
        modelAndView.setViewName("secured/admin/customerList");
        return modelAndView;
    }
  
    @GetMapping(value = {"/new"})
    public String displayNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer(null,null,null,null));
        return "secured/admin/customerNew";
    }

    @PostMapping(value = {"/new"})
    public String registerNewAdmin(@Valid @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/listCustomer";
    }

    @GetMapping(value = {"/edit/{customerId}"})
    public String editCustomer(@PathVariable Long customerId, Model model) {
        var customer = customerService.getCustomerById(customerId);
        if(customer != null) {
            model.addAttribute("customer", customer);
            return "secured/admin/customerEdit";
        }
        return "redirect:/customer/listCustomer";
    }

    @PostMapping(value = {"/update"})
    public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/admin/customerEdit";
        }
        customerService.save(customer);
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        customerService.deleteCustomerById(customerId);
        return "redirect:/customer/listCustomer";
    }
}
