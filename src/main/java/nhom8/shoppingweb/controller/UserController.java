package nhom8.shoppingweb.controller;

import nhom8.shoppingweb.repository.UserRepository;
import nhom8.shoppingweb.service.UserService;
import nhom8.shoppingweb.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {
    /*
        Controller. Xử lý các request GET, POST,...
    */
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register.html")
    public String addUser(Model model) {
        model.addAttribute("user", new nhom8.shoppingweb.model.User());
        return "register";
    }

    /*
    @ModelAttribute đánh dấu đối tượng User được gửi lên bởi Form Request
     */
    @PostMapping("/register.html")
    public String addUser(@ModelAttribute nhom8.shoppingweb.model.User user) {
        return Optional.ofNullable(userService.add(user))
                .map(t -> "fragments/rsuccess")
                .orElse("fragments/rfailed");
    }

    @RequestMapping(value = {"/userInfo","/userAccountInfo"}, method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thành công, sẽ có principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);

        nhom8.shoppingweb.model.User user = userRepository.findByUSERNAME(userName);
        String USERNAME = user.getUSERNAME();
        String FULLNAME = user.getFULLNAME();
        String PHONE = user.getPHONE();
        String EMAIL = user.getEMAIL();
        String ROLE = user.getROLE();

        model.addAttribute("userInfo", userInfo);
        model.addAttribute("USERNAME", USERNAME);
        model.addAttribute("FULLNAME", FULLNAME);
        model.addAttribute("PHONE", PHONE);
        model.addAttribute("EMAIL", EMAIL);
        model.addAttribute("ROLE", ROLE);
        return "userInfoPage";
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
        model.addAttribute("listUser", userRepository.findAllUser(pageable));
        model.addAttribute("numberOfPages", userRepository.findAll().size() / size);
        model.addAttribute("currentPage", page);
        return "listUser";
    }


    // hiển thị User có ID = {id}
    @RequestMapping("/viewUser/{id}")
    public String viewUser(@PathVariable int id, Model model) {
        Optional<nhom8.shoppingweb.model.User> user = userService.findById(id);
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
        return "fragments/dsuccess";
    }

    // sửa User
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, Model model) {
        nhom8.shoppingweb.model.User user = new nhom8.shoppingweb.model.User();
        user.setID(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute nhom8.shoppingweb.model.User user) {
        return Optional.ofNullable(userService.update(user))
                .map(t -> "fragments/psuccess")
                .orElse("fragments/pfailed");
    }
}
