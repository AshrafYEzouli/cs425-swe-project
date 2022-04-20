package cs425.project.moviemail.service;

import cs425.project.moviemail.model.Cart;

import java.util.List;

public interface CartService {
    Cart addToCart(Cart cart);
    List<Cart> getAllCarts();
}
