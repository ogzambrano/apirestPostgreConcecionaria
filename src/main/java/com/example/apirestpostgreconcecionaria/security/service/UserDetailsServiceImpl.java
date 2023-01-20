package com.example.apirestpostgreconcecionaria.security.service;


import com.example.apirestpostgreconcecionaria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.apirestpostgreconcecionaria.domain.User user = userRepository.finByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found with username: "+username));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),user.getPassword(),new ArrayList<>()
        );
    }
}
