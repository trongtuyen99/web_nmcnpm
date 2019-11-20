package nhom8.shoppingweb.service;

import nhom8.shoppingweb.model.User;
import nhom8.shoppingweb.model.UserValidator;
import nhom8.shoppingweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator validator;

    /**
     * Thêm một User mới vào danh sách
     *
     * @return Trả về đối tượng User sau khi lưu vào DB, trả về null nếu không thành công
     */
    public User add(User user) {
        if (validator.isValid(user)) {
            return userRepository.save(user);
        }
        return null;
    }
}