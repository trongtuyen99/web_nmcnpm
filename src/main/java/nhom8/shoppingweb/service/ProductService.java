package nhom8.shoppingweb.service;

import nhom8.shoppingweb.model.Product;
import nhom8.shoppingweb.model.ProductValidator;
import nhom8.shoppingweb.repository.ProductRepository;
import nhom8.shoppingweb.utils.EncryptedPasswordUtils;
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


    /**
     * Lấy ra danh sách List<User>
     *
     * @param limit - Giới hạn số lượng lấy ra
     *
     * @return Trả về danh sách List<User> dựa theo limit, nếu limit == null thì trả findAll()
     */

    public List<Product> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> productRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> productRepository.findAll());
    }

    /**
     * Thêm một User mới vào danh sách
     *
     * @return Trả về đối tượng User sau khi lưu vào DB, trả về null nếu không thành công
     */
    public Product add(Product product) {
        if (pvalidator.isValid(product)) {
            return productRepository.save(product);
        }
        return null;
    }
}