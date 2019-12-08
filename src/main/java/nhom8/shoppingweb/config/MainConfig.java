package nhom8.shoppingweb.config;

import nhom8.shoppingweb.entity.ProductValidator;
import nhom8.shoppingweb.entity.MessageValidator;
import nhom8.shoppingweb.entity.ProducerValidator;
import nhom8.shoppingweb.entity.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
    // tạo bean cho các validator
    public class UserConfig {
        @Bean
        public UserValidator uvalidator() {
            return new UserValidator();
        }
    }
    public class MessageConfig {
        @Bean
        public MessageValidator mvalidator() {
            return new MessageValidator();
        }
    }
    public class ProductConfig {
        @Bean
        public ProductValidator pvalidator() {
            return new ProductValidator();
        }
    }
    
    public class ProducerConfig {
        @Bean
        public ProducerValidator p2validator() {
            return new ProducerValidator();
        }
    }
}