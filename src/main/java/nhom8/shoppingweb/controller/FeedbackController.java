package nhom8.shoppingweb.controller;

import nhom8.shoppingweb.entity.Message;
import nhom8.shoppingweb.repository.MessageRepository;
import nhom8.shoppingweb.service.MessageService;
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
public class FeedbackController {
    // controller cho chức năng phản hồi.
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageService messageService;

    // phản hồi
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
                .map(t -> "/success")
                .orElse("/failed");
    }

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
        Page<Message> pageMessage = messageRepository.findAllFeedback(pageable);
        model.addAttribute("listFeedback", pageMessage);
        model.addAttribute("numberOfPages", pageMessage.getTotalPages());
        model.addAttribute("currentPage", page);
        return "listFeedback";
    }
}
