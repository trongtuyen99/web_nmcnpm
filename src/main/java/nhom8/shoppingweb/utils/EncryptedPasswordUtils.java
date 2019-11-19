package nhom8.shoppingweb.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
public class EncryptedPasswordUtils {
    /* 
        Mã hóa mật khẩu bằng BCryptPasswordEncoder.
        Khi lưu mật khẩu vào csdl, phải mã hóa trước.
    */
    public static String encryptedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
 
    public static void main(String[] args) {
        // mã hóa thử
        String password = "user";
        String encryptedPassword = encryptedPassword(password);
 
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
     
}