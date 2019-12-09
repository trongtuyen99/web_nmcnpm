package nhom8.shoppingweb.repository;

import nhom8.shoppingweb.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
    @Query("SELECT e FROM producerdb e")
    Page<Producer> findAllProducers(Pageable pageable);
}