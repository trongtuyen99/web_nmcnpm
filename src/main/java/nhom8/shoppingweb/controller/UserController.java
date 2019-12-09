package nhom8.shoppingweb.controller;

import nhom8.shoppingweb.entity.User;
import nhom8.shoppingweb.repository.UserRepository;
import nhom8.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
public class UserController {
    // controller tài khoản.
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    // đăng ký
    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new nhom8.shoppingweb.entity.User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute nhom8.shoppingweb.entity.User user) {
        return Optional.ofNullable(userService.add(user))
                .map(t -> "/success")
                .orElse("/failed");
    }

    // hiển thị danh sách User (đã phân trang)
    @RequestMapping("/listUser")
    public String listUser(Model model,
                              @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "3") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<User> pageUser = userRepository.findAllUser(pageable);
        model.addAttribute("listUser", pageUser);
        model.addAttribute("numberOfPages", pageUser.getTotalPages());
        model.addAttribute("currentPage", page);
        return "listUser";
    }


    // hiển thị User có ID = {id}
    @RequestMapping("/viewUser/{id}")
    public String viewUser(@PathVariable int id, Model model) {
        Optional<nhom8.shoppingweb.entity.User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
        return "viewUser";
    }

    // xóa User có ID = {id}
    @RequestMapping("/deleteUser/{id}")
    public String userDelete(@PathVariable int id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("listUser", userRepository.findAll());
        return "/success";
    }

    // sửa User
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, Model model) {
        nhom8.shoppingweb.entity.User user = new nhom8.shoppingweb.entity.User();
        user.setID(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute nhom8.shoppingweb.entity.User user) {
        return Optional.ofNullable(userService.update(user))
                .map(t -> "/success")
                .orElse("/failed");
    }
}
