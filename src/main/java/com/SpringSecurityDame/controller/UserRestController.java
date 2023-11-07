package com.SpringSecurityDame.controller;

import com.SpringSecurityDame.model.User;
import com.SpringSecurityDame.repository.UserRepository;
//import com.SpringSecurityDame.security.AuthenticationService;
import com.SpringSecurityDame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users/")
public class UserRestController {

    @Autowired
    UserRepository userRep;

    @Autowired
    UserService userService;

//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) {
//        String token = authenticationService.authenticate(
//                user.getUsername(), user.getPassword()
//        );
//
//        return ResponseEntity.ok(token);
//    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable long id){return userService.getUser(id); }

    @GetMapping("/protected")
    public String helloSecure() {
        return "Hello Autour Du Code protected !";
    }

    @GetMapping("/public")
    public String helloPublic() {
        return "Hello Autour Du Code public!";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "Hello Autour Du Code user!";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Autour Du Code ADMIN!";
    }
}
