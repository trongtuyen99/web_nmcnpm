package nhom8.shoppingweb.model;

import nhom8.shoppingweb.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;
import nhom8.shoppingweb.model.User;
import nhom8.shoppingweb.repository.UserDAO;

/*
Đối tượng này dùng để kiểm tra xem một Object User có hợp lệ không
 */
public class UserValidator {
    @Autowired
    UserDAO userDAO;
    /**
     * Kiểm tra một object User có hợp lệ không
     * @param user
     * @return
     */
    public boolean isValid(User user) {
        return Optional.ofNullable(user)
                .filter(t -> userDAO.findUser(user.getUSERNAME()) == null)
                .filter(t -> !StringUtils.isEmpty(t.getFULLNAME())) // Kiểm tra Firstname khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getPHONE())) // Kiểm tra Lastname khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getEMAIL()))
                .filter(t -> !StringUtils.isEmpty(t.getUSERNAME()))
                .filter(t -> !StringUtils.isEmpty(t.getPASSWORD()))
                .filter(t -> StringUtils.equals(t.getCPASSWORD(),t.getPASSWORD()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}