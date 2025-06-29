package com.fowobi.security.controller;

import com.fowobi.security.dto.MyUserDto;
import com.fowobi.security.model.MyUser;
import com.fowobi.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/reg")
    public MyUser createUser(@RequestBody MyUserDto myUser) {
        MyUser newUser = new MyUser();
        newUser.setUsername(myUser.getUsername());
        newUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        newUser.setRoles(myUser.getRoles());

        return userRepo.save(newUser);
    }
}
