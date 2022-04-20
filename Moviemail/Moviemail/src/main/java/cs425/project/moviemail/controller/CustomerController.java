package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Cart;
import cs425.project.moviemail.model.Customer;
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

import java.util.List;

import javax.validation.Valid;

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
        modelAndView.setViewName("secured/admin/cart");
        return modelAndView;
    }

    @PostMapping(value = {"/checkout"})
    public void checkout(@Valid @ModelAttribute("record") Record record, BindingResult bindingResult, Model model) {
        recordService.checkOut(record);
        System.out.println("save record!");
    }

    @GetMapping(value = {"/addtocart/{movieId}"})
    public String addToCart(@PathVariable Long movieId, Model model) {
        var movie = movieService.getMovieById(movieId);
        if(movie != null) {
            Customer customer = new Customer();
            customer.setCustomerId(1L);

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
        modelAndView.addObject("customers", ((List)customers).size());
        modelAndView.setViewName("secured/admin/customerList");
        return modelAndView;
    }
}
