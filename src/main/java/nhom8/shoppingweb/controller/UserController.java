package nhom8.shoppingweb.controller;

import java.security.Principal;
import java.util.Optional;
import nhom8.shoppingweb.repository.UserDAO;
import nhom8.shoppingweb.service.UserService;
import nhom8.shoppingweb.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    /*
        Controller. Xử lý các request GET, POST,...
    */
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new nhom8.shoppingweb.entity.User());
        return "register";
    }

    /*
    @ModelAttribute đánh dấu đối tượng User được gửi lên bởi Form Request
     */
    @PostMapping("/register")
    public String addUser(@ModelAttribute nhom8.shoppingweb.entity.User user) {
        return Optional.ofNullable(userService.add(user))
                .map(t -> "fragments/success")
                .orElse("fragments/failed");
    }
}