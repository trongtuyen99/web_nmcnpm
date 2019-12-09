package nhom8.shoppingweb.controller;

import java.security.Principal;
import java.util.Optional;

import nhom8.shoppingweb.model.Message;
import nhom8.shoppingweb.repository.UserRepository;
import nhom8.shoppingweb.service.MessageService;
import nhom8.shoppingweb.service.UserService;
import nhom8.shoppingweb.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    private UserRepository userRepository;


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
        model.addAttribute("messageList", messageService.findAll(limit));
        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {

        return "login";
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
    @RequestMapping(value = {"/index.html","index"}, method = RequestMethod.GET)
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

    @RequestMapping(value = "/adminControlPanel.html", method = RequestMethod.GET)
    public String single(){
        return "adminControlPanel.html";
    }
}