package nhom8.shoppingweb.model;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

/*
Đối tượng này dùng để kiểm tra xem một Object User có hợp lệ không
 */
public class UserValidator {

    /**
     * Kiểm tra một object User có hợp lệ không
     * @param user
     * @return
     */
    public boolean isValid(User user) {
        return Optional.ofNullable(user)
                .filter(t -> !StringUtils.isEmpty(t.getFIRSTNAME())) // Kiểm tra Firstname khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getLASTNAME())) // Kiểm tra Lastname khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getEMAIL()))
                .filter(t -> !StringUtils.isEmpty(t.getUSERNAME()))
                .filter(t -> !StringUtils.isEmpty(t.getPASSWORD()))
                .filter(t -> StringUtils.equals(t.getCPASSWORD(),t.getPASSWORD()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}