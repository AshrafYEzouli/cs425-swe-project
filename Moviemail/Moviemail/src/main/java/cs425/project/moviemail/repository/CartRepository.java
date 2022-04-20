package cs425.project.moviemail.repository;

import cs425.project.moviemail.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c where c.customer.customerId = ?1")
    List<Cart> getCartsByCustomerId(Long customerId);
}
