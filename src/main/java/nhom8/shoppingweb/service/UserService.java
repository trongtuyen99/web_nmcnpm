package nhom8.shoppingweb.service;

import nhom8.shoppingweb.model.User;
import nhom8.shoppingweb.model.UserValidator;
import nhom8.shoppingweb.repository.UserRepository;
import nhom8.shoppingweb.utils.EncryptedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator uvalidator;


    /**
     * Lấy ra danh sách List<User>
     *
     * @param limit - Giới hạn số lượng lấy ra
     *
     * @return Trả về danh sách List<User> dựa theo limit, nếu limit == null thì trả findAll()
     */

    public List<User> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> userRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> userRepository.findAll());
    }

    /**
     * Thêm một User mới vào danh sách
     *
     * @return Trả về đối tượng User sau khi lưu vào DB, trả về null nếu không thành công
     */
    public User add(User user) {
        if (uvalidator.isValid(user)) {
            user.setPASSWORD(EncryptedPasswordUtils.encryptedPassword(user.getPASSWORD()));
            user.setCPASSWORD(EncryptedPasswordUtils.encryptedPassword(user.getCPASSWORD()));
            user.setROLE("ROLE_USER ");
            return userRepository.save(user);
        }
        return null;
    }
}