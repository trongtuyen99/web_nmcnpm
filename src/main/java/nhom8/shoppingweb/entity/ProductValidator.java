package nhom8.shoppingweb.entity;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

public class ProductValidator {
    public boolean isValid(Product product) {
        return Optional.ofNullable(product)
                .filter(t -> !StringUtils.isEmpty(t.getNAME()))
                .filter(t -> !StringUtils.isEmpty(t.getDESCRIPTION()))
                .filter(t -> !StringUtils.isEmpty(t.getIMAGE()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}