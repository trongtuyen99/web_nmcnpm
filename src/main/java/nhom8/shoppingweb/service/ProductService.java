package nhom8.shoppingweb.service;

import nhom8.shoppingweb.model.Product;
import nhom8.shoppingweb.model.ProductValidator;
import nhom8.shoppingweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductValidator pvalidator;

    public List<Product> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> productRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> productRepository.findAll());
    }

    public Product add(Product product) {
        if (pvalidator.isValid(product)) {
            return productRepository.save(product);
        }
        return null;
    }

    public Product update(Product product) {
        if (pvalidator.isValid(product)) {
            return productRepository.save(product);
        }
        return null;
    }


    public Optional<Product> findById(int id){
        return productRepository.findById(id);
    }
}