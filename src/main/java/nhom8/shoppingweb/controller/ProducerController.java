package nhom8.shoppingweb.controller;

import java.util.Optional;

import nhom8.shoppingweb.entity.Producer;
import nhom8.shoppingweb.repository.ProducerRepository;
import nhom8.shoppingweb.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProducerController {
    // controller nhà sản xuất.
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ProducerRepository producerRepository;

    // thêm nsx mới
    @GetMapping("/addProducer")
    public String addProducer(Model model) {
        model.addAttribute("producer", new nhom8.shoppingweb.entity.Producer());
        return "addProducer";
    }

    @PostMapping("/addProducer")
    public String addProducer(@ModelAttribute nhom8.shoppingweb.entity.Producer producer) {
        return Optional.ofNullable(producerService.add(producer))
                .map(t -> "/success")
                .orElse("/failed");
    }

    // hiển thị danh sách nsx (đã phân trang)
    @RequestMapping("/listProducer")
    public String listProducer(Model model,
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
        Page<Producer> pageProducer = producerRepository.findAllProducers(pageable);
        model.addAttribute("listProducer", pageProducer);
        model.addAttribute("numberOfPages", pageProducer.getTotalPages());
        model.addAttribute("currentPage", page);
        return "/listProducer";
    }

    // xóa nsx có ID = {id}
    @RequestMapping("/deleteProducer/{id}")
    public String producerDelete(@PathVariable int id, Model model) {
        producerRepository.deleteById(id);
        model.addAttribute("listProducer", producerRepository.findAll());
        return "/success";
    }
}