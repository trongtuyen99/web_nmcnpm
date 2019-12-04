package nhom8.shoppingweb.service;

import java.util.ArrayList;
import java.util.List;

import nhom8.shoppingweb.repository.UserDAO;
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
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        nhom8.shoppingweb.model.User user = this.userDAO.findUser(userName);

        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + user);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority auth = new SimpleGrantedAuthority(user.getROLE());
        grantList.add(auth);

        // tạo một người dùng mới với tdn, mk và danh sách quyền truy cập.
        UserDetails userDetails = new User(user.getUSERNAME(), //
                user.getPASSWORD(), grantList);

        return userDetails;
    }
}