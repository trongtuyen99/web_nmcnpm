package nhom8.shoppingweb.entity;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;


public class MessageValidator {

    public boolean isValid(Message message) {
        return Optional.ofNullable(message)
                .filter(t -> !StringUtils.isEmpty(t.getNAME())) // Kiểm tra Name khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getEMAIL()))
                .filter(t -> !StringUtils.isEmpty(t.getMESSAGE()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}