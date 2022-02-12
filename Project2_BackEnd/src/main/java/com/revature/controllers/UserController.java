package com.revature.controllers;

import com.revature.models.Users;
import com.revature.services.UserService;
import com.revature.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private UserService userService;
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        super();
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<List<Users>> registration(@RequestBody Users user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(400).build();
        }else {
            if(userService.saveUser(user)){
                return ResponseEntity.status(201).build();
            }
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user){
        if(userService.findByUsername(user.getUsername())!= null){
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(401).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Users> logout(HttpSession session){
        if(session != null) {
            session.invalidate();
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(401).build();
    }
}
