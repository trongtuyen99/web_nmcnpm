package nhom8.shoppingweb.controller;

import java.security.Principal;
import java.util.Optional;

import nhom8.shoppingweb.model.Message;
import nhom8.shoppingweb.repository.UserDAO;
import nhom8.shoppingweb.service.MessageService;
import nhom8.shoppingweb.service.ProductService;
import nhom8.shoppingweb.service.UserService;
import nhom8.shoppingweb.utils.WebUtils;
import nhom8.shoppingweb.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBean;
import javax.validation.constraints.Null;

@Controller
public class MainController {
    /*
        Controller. Xử lý các request GET, POST,...
    */
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserDAO userDAO;

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
                .orElse("fragments/failed");
    }

    @GetMapping("/addProduct.html")
    public String addProduct(Model model) {
        model.addAttribute("product", new nhom8.shoppingweb.model.Product());
        return "addProduct";
    }

    /*
    @ModelAttribute đánh dấu đối tượng User được gửi lên bởi Form Request
     */
    @PostMapping("/addProduct.html")
    public String addProduct(@ModelAttribute nhom8.shoppingweb.model.Product product) {
        return Optional.ofNullable(productService.add(product))
                .map(t -> "fragments/psuccess")
                .orElse("fragments/pfailed");
    }

    @GetMapping("/contact.html")
    public String addMessage(Model model) {
        model.addAttribute("msg", new Message());
        return "contact";
    }

    /*
    @ModelAttribute đánh dấu đối tượng Message được gửi lên bởi Form Request
     */
    @PostMapping("/contact.html")
    public String addMessage(@ModelAttribute Message msg) {
        return Optional.ofNullable(messageService.add(msg))
                .map(t -> "fragments/msuccess")
                .orElse("fragments/mfailed");
    }

    @RequestMapping(value = "/adminControlPanel.html", method = RequestMethod.GET)
    public String adminControlPanel(Model model){
        return "adminControlPanel";
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal, @RequestParam(value = "limit", required = false) Integer limit) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        // Trả về đối tượng userList.
        model.addAttribute("userList", userService.findAll(limit));
        return "adminPage";
    }
    @RequestMapping(value = {"/userInfo","/userAccountInfo"}, method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thành công, sẽ có principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);

        nhom8.shoppingweb.model.User user = userDAO.findUser(userName);
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

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String loginhtml(Model model) {

        return "login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/product.html", method = RequestMethod.GET)
    public String product(Model model){
        return "product";
    }

    @RequestMapping(value = "/single.html", method = RequestMethod.GET)
    public String single(Model model){
        return "single.html";
    }
}