package nhom8.shoppingweb.service;

import nhom8.shoppingweb.entity.Producer;
import nhom8.shoppingweb.entity.ProducerValidator;
import nhom8.shoppingweb.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private ProducerValidator p2validator;

    public List<Producer> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> producerRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> producerRepository.findAll());
    }

    public Producer add(Producer producer) {
        if (p2validator.isValid(producer)) {
            return producerRepository.save(producer);
        }
        return null;
    }

    public Producer update(Producer producer) {
        if (p2validator.isValid(producer)) {
            return producerRepository.save(producer);
        }
        return null;
    }
}