package nhom8.shoppingweb.controller;

import nhom8.shoppingweb.repository.MessageRepository;
import nhom8.shoppingweb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FeedbackController {
    /*
        Controller. Xử lý các request GET, POST,...
    */
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageRepository messageRepository;



    // hiển thị danh sách Feedback (đã phân trang)
    @RequestMapping("/listFeedback")
    public String listUser(Model model,
                              @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "1") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        model.addAttribute("listFeedback", messageRepository.findAllFeedback(pageable));
        model.addAttribute("numberOfPages", messageRepository.findAll().size() / size);
        model.addAttribute("currentPage", page);
        return "listFeedback";
    }


    // hiển thị User có ID = {id}
//    @RequestMapping("/viewFeedback/{id}")
//    public String viewUser(@PathVariable int id, Model model) {
//        Optional<nhom8.shoppingweb.model.Message> message = messageRepository.findById(id);
//        if (message.isPresent()) {
//            model.addAttribute("msg", message.get());
//        }
//        return "viewFeedback";
//    }

    // xóa User có ID = {id}
//    @RequestMapping("/deleteUser/{id}")
//    public String userDelete(@PathVariable int id, Model model) {
//        userRepository.deleteById(id);
//        model.addAttribute("listUser", userRepository.findAll());
//        return "fragments/dsuccess";
//    }

    // sửa User
//    @GetMapping("/updateUser/{id}")
//    public String updateUser(@PathVariable int id, Model model) {
//        nhom8.shoppingweb.model.User user = new nhom8.shoppingweb.model.User();
//        user.setID(id);
//        model.addAttribute("user", user);
//        return "updateUser";
//    }
//
//    @PostMapping("/updateUser")
//    public String updateUser(@ModelAttribute nhom8.shoppingweb.model.User user) {
//        return Optional.ofNullable(userService.update(user))
//                .map(t -> "fragments/psuccess")
//                .orElse("fragments/pfailed");
//    }
}
