package nhom8.shoppingweb.repository;

import nhom8.shoppingweb.model.Message;
import nhom8.shoppingweb.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("SELECT e FROM contactdb e")
    Page<Message> findAllFeedback(Pageable pageable);
}