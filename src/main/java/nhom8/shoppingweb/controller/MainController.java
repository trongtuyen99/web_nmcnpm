package nhom8.shoppingweb.controller;

import java.security.Principal;
import java.util.Optional;
import nhom8.shoppingweb.entity.Message;
import nhom8.shoppingweb.entity.Product;
import nhom8.shoppingweb.repository.ProductRepository;
import nhom8.shoppingweb.service.MessageService;
import nhom8.shoppingweb.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    @Autowired
    private MessageService messageService;
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/contact")
    public String addMessage(Model model) {
        model.addAttribute("msg", new Message());
        return "contact";
    }

    /*
    @ModelAttribute đánh dấu đối tượng Message được gửi lên bởi Form Request
     */
    @PostMapping("/contact")
    public String addMessage(@ModelAttribute Message msg) {
        return Optional.ofNullable(messageService.add(msg))
                .map(t -> "fragments/success")
                .orElse("fragments/failed");
    }

    @RequestMapping(value = "/adminControlPanel", method = RequestMethod.GET)
    public String adminControlPanel(Model model){
        return "adminControlPanel";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() //
                    + "~<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403";
    }
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model){
        // hiện 5 sản phẩm ra index cho đẹp
        Page<Product> pageProduct = productRepository.findAllProducts(PageRequest.of(0, 6));
        model.addAttribute("listProduct", pageProduct);
        return "index";
    }
}