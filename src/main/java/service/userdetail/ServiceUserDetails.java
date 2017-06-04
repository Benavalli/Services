package service.userdetail;

import java.util.Arrays;
import data.bo.userdetail.UserDetailBO;
import data.model.userdetail.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceUserDetails implements UserDetailsService {

    @Autowired
    private UserDetailBO userDetailBO;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

        UserDetail userDetail = userDetailBO.getUserDetail(user);
        if(userDetail != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(userDetail.getRole());
            UserDetails userDetails = (UserDetails) new User(userDetail.getUser(),
                    userDetail.getPassword(), Arrays.asList(authority));
            return userDetails;
        }
        return null;
    }
}