package nhom8.shoppingweb.controller;

import java.util.Optional;
import nhom8.shoppingweb.entity.Product;
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
public class ProductController {
    /*
        Controller. Xử lý các request GET, POST,...
    */
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    // thêm sản phẩm mới
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new nhom8.shoppingweb.entity.Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute nhom8.shoppingweb.entity.Product product) {
        return Optional.ofNullable(productService.add(product))
                .map(t -> "fragments/success")
                .orElse("fragments/failed");
    }

    // hiển thị danh sách sản phẩm (đã phân trang)
    @RequestMapping("/listProduct")
    public String listProduct(Model model,
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
        Page<Product> pageProduct = productRepository.findAllProducts(pageable);
        model.addAttribute("listProduct", pageProduct);
        model.addAttribute("numberOfPages", pageProduct.getTotalPages());
        model.addAttribute("currentPage", page);
        return "listProduct";
    }

    @RequestMapping("/listProductUser")
    public String listProductUser(Model model,
                              @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "6") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> pageProduct = productRepository.findAllProducts(pageable);
        model.addAttribute("listProduct", pageProduct);
        model.addAttribute("numberOfPages", pageProduct.getTotalPages());
        model.addAttribute("currentPage", page);
        return "listProductUser";
    }
    
    // hiển thị danh sách sản phẩm có chứa chuỗi pattern trong tên
    @RequestMapping("/listProductSearch")
    public String listProductSearch(Model model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                               @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                               @RequestParam(name = "pattern", required = true, defaultValue = "ASC") String pattern) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> pageProduct = productRepository.findProductsByName(pageable, "%" + pattern + "%");
        model.addAttribute("listProduct", pageProduct);
        model.addAttribute("numberOfPages", pageProduct.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("pattern", pattern);
        return "listProductSearch";
    }
    
    // hiển thị danh sách sản phẩm theo ID nhà sản xuất
    @RequestMapping("/listProductByProducerID")
    public String listProductByProducerID(Model model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                               @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                               @RequestParam(name = "producerID", required = true, defaultValue = "ASC") int producerID) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> pageProduct = productRepository.findProductsByProducer(pageable, producerID);
        model.addAttribute("listProduct", pageProduct);
        model.addAttribute("numberOfPages", pageProduct.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("producerID", producerID);
        return "listProductByProducerID";
    }

    // hiển thị sản phẩm có ID = {id}
    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "viewProduct";
    }

    // xóa sản phẩm có ID = {id}
    @RequestMapping("/deleteProduct/{id}")
    public String productDelete(@PathVariable int id) {
        productRepository.deleteById(id);
        return "fragments/success";
    }

    // sửa sản phẩm
    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable int id, Model model) {
        nhom8.shoppingweb.entity.Product product = new nhom8.shoppingweb.entity.Product();
        product.setID(id);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute nhom8.shoppingweb.entity.Product product) {
        return Optional.ofNullable(productService.update(product))
                .map(t -> "fragments/success")
                .orElse("fragments/failed");
    }
}