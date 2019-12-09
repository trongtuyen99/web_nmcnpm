package nhom8.shoppingweb.service;


import nhom8.shoppingweb.model.Message;
import nhom8.shoppingweb.model.MessageValidator;
import nhom8.shoppingweb.model.User;
import nhom8.shoppingweb.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageValidator mvalidator;
    public List<Message> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> messageRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> messageRepository.findAll());
    }
    /**
     * Thêm một User mới vào danh sách
     *
     * @return Trả về đối tượng User sau khi lưu vào DB, trả về null nếu không thành công
     */
    public Message add(Message msg) {
        if (mvalidator.isValid(msg)) {
            return messageRepository.save(msg);
        }
        return null;
    }
}