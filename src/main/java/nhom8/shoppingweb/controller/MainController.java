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
    // controller các chức năng chung
    @Autowired
    private MessageService messageService;
    @Autowired
    private ProductRepository productRepository;

    // trang chức năng của admin
    @RequestMapping(value = "/adminControlPanel", method = RequestMethod.GET)
    public String adminControlPanel(Model model){
        return "adminControlPanel";
    }

    // đăng nhập
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    // trang lỗi
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

    // trang chủ
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model){
        // hiện 5 sản phẩm ra index cho đẹp
        Page<Product> pageProduct = productRepository.findAllProducts(PageRequest.of(0, 6));
        model.addAttribute("listProduct", pageProduct);
        return "index";
    }
}