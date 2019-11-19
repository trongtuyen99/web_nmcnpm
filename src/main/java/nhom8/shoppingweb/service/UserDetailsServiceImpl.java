package nhom8.shoppingweb.service;

import java.util.ArrayList;
import java.util.List;

import nhom8.shoppingweb.dao.NguoiDungDAO;
import nhom8.shoppingweb.entity.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /*
        Tạo đối tượng User từ dữ liệu nhập vào.
    */
    
    @Autowired
    private NguoiDungDAO nguoiDungDAO;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        NguoiDung nguoiDung = this.nguoiDungDAO.findUser(userName);
 
        if (nguoiDung == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + nguoiDung);
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority auth = new SimpleGrantedAuthority(nguoiDung.getQuyenTruyCap());
        grantList.add(auth);
        
        // tạo một người dùng mới với tdn, mk và danh sách quyền truy cập.
        UserDetails userDetails = (UserDetails) new User(nguoiDung.getTenDangNhap(), //
                nguoiDung.getMatKhau(), grantList);
 
        return userDetails;
    }
 
}