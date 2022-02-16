package com.revature.controllers;

import com.revature.models.Users;
import com.revature.services.UserService;
//import com.revature.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(value="users")
@CrossOrigin
public class UserController {
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<List<Users>> registration(@RequestBody Users user) throws NoSuchAlgorithmException {
            if(userService.createUser(user)){
                return ResponseEntity.status(201).build();
            }
            return ResponseEntity.status(400).build();
        }


    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user, HttpSession session) throws NoSuchAlgorithmException {
        if(userService.loginUser(user)){
            session.setAttribute("id",user.getUserId());
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

    @Autowired
    UserController(UserService userService){
        super();
        this.userService=userService;
    }
}
