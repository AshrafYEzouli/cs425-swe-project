package cs425.project.moviemail.service;

import cs425.project.moviemail.model.Cart;
import cs425.project.moviemail.model.Record;

import java.util.List;

public interface CartService {
    Cart addToCart(Cart cart);
    List<Cart> getAllCarts(Long customerId);
    void deleteCarts(List<Cart> carts);
}
