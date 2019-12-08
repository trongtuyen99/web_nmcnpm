package nhom8.shoppingweb.repository;

import nhom8.shoppingweb.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT e FROM orderdb e")
    Page<Order> findAllOrders(Pageable pageable);
}