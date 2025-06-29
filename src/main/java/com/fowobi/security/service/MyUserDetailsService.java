package com.fowobi.security.service;

import com.fowobi.security.model.MyUser;
import com.fowobi.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepo.findByUsername(name);

        if(user.isPresent()) {
            var userObj = user.get();

            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException("User " + name + " not found");
        }
    }

    private String[] getRoles(MyUser myUser) {
        if(myUser.getRoles() == null)
            return new String[]{"USER"};

        return myUser.getRoles().split(",");
    }
}
