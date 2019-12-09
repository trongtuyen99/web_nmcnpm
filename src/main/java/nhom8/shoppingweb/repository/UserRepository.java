package nhom8.shoppingweb.repository;

import nhom8.shoppingweb.entity.Product;
import nhom8.shoppingweb.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUSERNAME(String username);
    @Query("SELECT e FROM userdb e")
    Page<User> findAllUser(Pageable pageable);
}