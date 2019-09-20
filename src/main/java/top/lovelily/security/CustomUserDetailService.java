package top.lovelily.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: CustomUserDetailService
 * Author: xuhe
 * Date: 2019/9/20 5:48 PM
 * Version: 1.0
 */
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities =  new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("Admin"));
        // spring 会自动采用passwordEncode()编码后比较密码是否正确  123456
        return new User(username, "$2a$10$WgS0ym.GpV.sfwU/J2IWTuaQP8WvotBMK9x9f0h2UHEnlD6pqhaTG", grantedAuthorities);
    }
}
