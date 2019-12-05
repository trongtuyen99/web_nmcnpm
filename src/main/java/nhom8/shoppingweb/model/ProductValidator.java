package nhom8.shoppingweb.model;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

public class ProductValidator {
    public boolean isValid(Product product) {
        return Optional.ofNullable(product)
                .filter(t -> !StringUtils.isEmpty(t.getNAME())) // Kiểm tra Firstname khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getPRICE())) // Kiểm tra Lastname khác rỗng
//                .filter(t -> !StringUtils.isEmpty(t.getPRODUCER_ID()))
//                .filter(t -> !StringUtils.isEmpty(t.getSTOCK_NUMBER()))
                .filter(t -> !StringUtils.isEmpty(t.getDESCRIPTION()))
                .filter(t -> !StringUtils.isEmpty(t.getIMAGE()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}