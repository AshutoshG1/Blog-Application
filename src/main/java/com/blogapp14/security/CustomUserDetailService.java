package com.blogapp14.security;

import com.blogapp14.entity.User;
import com.blogapp14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(username==null){
            throw new UsernameNotFoundException("user not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),null);
    }
}
