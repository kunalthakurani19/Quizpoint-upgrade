package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    private com.exam.repo.UserRepository userRepository;
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        Role role = new Role();
        role.setRoleName("NORMAL");

        Set<UserRole> roles=new HashSet<>();
        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);



        roles.add(userRole);
        return  this.userService.createUser(user,roles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        System.out.println(username);

        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId)
    {
        System.out.println(userId);
         this.userService.deleteUser(userId);
    }

}
