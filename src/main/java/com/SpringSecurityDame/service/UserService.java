package com.SpringSecurityDame.service;

import com.SpringSecurityDame.model.Role;
import com.SpringSecurityDame.model.User;
import com.SpringSecurityDame.repository.RoleRepository;
import com.SpringSecurityDame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private RoleRepository roleRep;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRep.findAll().forEach(user -> {
            users.add(user);
        });
        return users;
    }

    public User getUser(long id) { return userRep.findById(id).orElse(null); }

    public User saveUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }

    public User addRoleToUser(String username, String rolename) {
        User usr = userRep.findByUsername(username);
        Role r = roleRep.findByRole(rolename);

        usr.getRoles().add(r);
        return userRep.save(usr);
    }

    public Role addRole(Role role) {
        return roleRep.save(role);
    }

    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }
}