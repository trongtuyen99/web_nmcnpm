package nhom8.shoppingweb.controller;

import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import nhom8.shoppingweb.entity.Order;
import nhom8.shoppingweb.entity.Product;
import nhom8.shoppingweb.model.Cart;
import nhom8.shoppingweb.repository.OrderRepository;
import nhom8.shoppingweb.repository.ProductRepository;
import nhom8.shoppingweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    // controller cho giỏ hàng và đơn hàng.
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    // hiển thị danh sách đơn hàng (đã phân trang)
    @RequestMapping("/listOrder")
    public String listOrder(Model model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                               @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Order> pageOrder = orderRepository.findAllOrders(pageable);
        model.addAttribute("listOrder", pageOrder);
        model.addAttribute("numberOfPages", pageOrder.getTotalPages());
        model.addAttribute("currentPage", page);
        return "listOrder";
    }

    // hiển thị đơn hàng có ID = {id}
    @RequestMapping("/viewOrder/{id}")
    public String viewOrder(@PathVariable int id, Model model) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
        }
        return "viewOrder";
    }

    // xóa đơn hàng có ID = {id}
    @RequestMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderRepository.deleteById(id);
        return "success";
    }

    // thêm sản phẩm có id = {id} vào giỏ
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id, HttpSession session) {
        Cart cart;
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
	} else {
            cart = (Cart) session.getAttribute("cart");
        }
        cart.addItem(id);
        session.setAttribute("cart", cart);
        return "/success";
    }

    // hiển thị giỏ hàng
    @RequestMapping("/cart")
    public String cart(Model model, HttpSession session) {
        if (session.getAttribute("cart") != null) {
            model.addAttribute("listItems", ((Cart) session.getAttribute("cart")).getCartItems());
        }
        return "cart";
    }

    // xóa sản phẩm khỏi giỏ
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id, HttpSession session) {
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart.getCartItems().containsKey(id)){
                cart.deleteItem(id);
                session.setAttribute("cart", cart);
                return "/success";
            }
        }
        return "/failed";
    }

    // mua hàng
    @RequestMapping(value = "/buy", method = {RequestMethod.GET, RequestMethod.POST})
    public String buy(@RequestParam(name = "id", required = true) int id,
                      @RequestParam(name = "quantity", required = true) int quantity,
                      Model model) {
        Optional<Product> o_product = productRepository.findById(id);
        if (o_product.isPresent()) {
            model.addAttribute("id", id);
            model.addAttribute("quantity", quantity);
            model.addAttribute("name", o_product.get().getNAME());
            model.addAttribute("address", new String());
            return "/order";
        }
        return "failed";
    }

    // lưu đơn hàng
    @PostMapping("/order")
    public String order(@ModelAttribute("id") int id,
                        @ModelAttribute("quantity") int quantity,
                        @ModelAttribute("address") String address,
                        HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart.getCartItems().containsKey(id) && quantity > 0){
            Optional<Product> o_product = productRepository.findById(id);
            if (o_product.isPresent()) {  
                Product product = o_product.get();
                if (product.getSTOCK_NUMBER() - quantity >= 0) {
                    product.setSTOCK_NUMBER(product.getSTOCK_NUMBER() - quantity);
                    productRepository.save(product);
                    Order order = new Order();
                    order.setPRODUCT_ID(id);
                    order.setQUANTITY(quantity);
                    order.setADDRESS(address);
                    order.setPRICE(quantity * product.getPRICE());
                    order.setCREATED_TIME(new Date());
                    orderRepository.save(order);
                    cart.deleteItem(id);
                    session.setAttribute("cart", cart);
                    return "/success";
                }
            }
        }
        return "/failed";
    }
}