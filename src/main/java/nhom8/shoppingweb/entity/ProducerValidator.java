package nhom8.shoppingweb.entity;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

public class ProducerValidator {
    public boolean isValid(Producer producer) {
        return Optional.ofNullable(producer)
                .filter(t -> !StringUtils.isEmpty(t.getNAME()))
                .filter(t -> !StringUtils.isEmpty(t.getWEBSITE()))
                .isPresent();
    }
}