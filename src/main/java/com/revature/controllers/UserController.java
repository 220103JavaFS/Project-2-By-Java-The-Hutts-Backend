package com.revature.controllers;

import com.revature.models.Events;
import com.revature.models.Users;
import com.revature.models.loginDTO;

import com.revature.services.EventService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "users")
public class UserController {

    private UserService userService;
    private EventService eventsService;

    @PostMapping("/registration")
    public ResponseEntity<Users> registration(@RequestBody Users user) throws NoSuchAlgorithmException {
            if(userService.createUser(user)){
                System.out.println(user.getUserPreferences());
                return ResponseEntity.status(201).body(user);
            }
            return ResponseEntity.status(400).build();
        }


    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody loginDTO login, HttpSession session) throws NoSuchAlgorithmException {
        if(userService.loginUser(login)){
            Users user= userService.findByUsername(login.getUsername());
            session.setAttribute("login",true);
            session.setAttribute("userID", user.getUserId());
            return ResponseEntity.status(200).body(user);
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

    @GetMapping("/profile")
    @ResponseBody
    public ResponseEntity<Users> getEvents(@RequestBody loginDTO login, HttpSession session){
        if(session.getAttribute("login").equals(true)){
            Users thisuser = userService.findByUsername(login.getUsername());
            if (thisuser != null) {
                return ResponseEntity.status(200).body(thisuser);
            }else{
                return ResponseEntity.status(400).build();
            }
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/{username}")
    @ResponseBody
    public ResponseEntity<Users> getUser(@PathVariable("username") String username, HttpSession session){
        Users loggedInUser = userService.findByUsername(username);
        if (loggedInUser != null) {
            return ResponseEntity.status(200).body(loggedInUser);
        } else {
            return ResponseEntity.status(204).build();
        }
    }



    @Autowired
    UserController(UserService userService, EventService eventService){
        super();
        this.userService = userService;
        this.eventsService = eventService;
    }

}
