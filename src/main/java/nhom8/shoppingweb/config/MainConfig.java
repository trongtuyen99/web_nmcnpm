package nhom8.shoppingweb.config;

import javax.sql.DataSource;

import nhom8.shoppingweb.model.ProductValidator;
import  nhom8.shoppingweb.model.User;
import nhom8.shoppingweb.model.MessageValidator;
import nhom8.shoppingweb.model.UserValidator;
import nhom8.shoppingweb.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class MainConfig extends WebSecurityConfigurerAdapter {
    /*
        Cài đặt Spring Security để phân quyền khi đăng nhập.
    */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Cài đặt dịch vụ để tìm kiếm User trong Database.
        // Và cài đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        // Các trang không yêu cầu login, không yêu cầu role nào
        http.authorizeRequests().antMatchers("/", "/logout").permitAll();
        // Các trang chỉ truy cập được khi là khách
        http.authorizeRequests().antMatchers("/login.html").access("isAnonymous()");
        // Các trang yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        // lưu ý tên role là 'ROLE_USER ' (10 ký tự) chứ không phải 'ROLE_USER' (9 ký tự)
        // vì thuộc tính quyenTruyCap trong database có kiểu char(10) cố định 10 ký tự
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER ', 'ROLE_ADMIN')");

        // Các trang yêu cầu phải login với vai trò ROLE_ADMIN
        http.authorizeRequests().antMatchers(
                "/admin", "/adminControlPanel.html",
                "addProduct.html"
        ).access("hasRole('ROLE_ADMIN')");

        // Các trang yêu cầu phải login với vai trò ROLE_USER
        http.authorizeRequests().antMatchers(
                "/contact.html"
        ).access("hasRole('ROLE_USER ')");

        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra, dẫn tới /403.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login") // trang login
                .defaultSuccessUrl("/userAccountInfo") // login thành công
                .failureUrl("/login?error=true") // login thất bại
                .usernameParameter("username")
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

        // Cấu hình Remember Me.
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(86400); // = 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        // lưu token trong memory
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
    public class UserConfig {
        /**
         * Tạo ra Bean UserValidator để sử dụng sau này
         * @return
         */
        @Bean
        public UserValidator uvalidator() {
            return new UserValidator();
        }
    }
    public class MessageConfig {
        /**
         * Tạo ra Bean MessageValidator để sử dụng sau này
         * @return
         */
        @Bean
        public MessageValidator mvalidator() {
            return new MessageValidator();
        }
    }
    public class ProductConfig {
        /**
         * Tạo ra Bean ProductValidator để sử dụng sau này
         * @return
         */
        @Bean
        public ProductValidator pvalidator() {
            return new ProductValidator();
        }
    }
}