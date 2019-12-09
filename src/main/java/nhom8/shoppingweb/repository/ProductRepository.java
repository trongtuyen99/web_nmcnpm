package nhom8.shoppingweb.repository;

import nhom8.shoppingweb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT e FROM productdb e")
    Page<Product> findAllProducts(Pageable pageable);
    
    @Query("SELECT e FROM productdb e WHERE e.NAME like :pattern")
    Page<Product> findProductsByName(Pageable pageable, 
        @Param("pattern") String pattern);
    
    @Query("SELECT e FROM productdb e WHERE e.PRODUCER_ID = :producerID")
    Page<Product> findProductsByProducer(Pageable pageable, 
        @Param("producerID") int producerID);
}