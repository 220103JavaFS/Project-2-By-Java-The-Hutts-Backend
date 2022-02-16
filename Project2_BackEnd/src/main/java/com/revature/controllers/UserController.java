package com.revature.controllers;

import com.revature.models.Events;
import com.revature.models.Users;
import com.revature.services.EventService;
import com.revature.services.UserService;
//import com.revature.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="users")
@CrossOrigin
public class UserController {

    private UserService userService;
    private EventService eventsService;

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
            session.setAttribute("login",true);
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


    @GetMapping("/myevents")
    public ResponseEntity<Events> getEvents(@RequestBody Users user, HttpSession session){
        if(session.getAttribute("login").equals(true)) {
            List<Events> eventList = eventsService.findEventsByCreator(user.getUserId());
            if (eventList != null) {
                return ResponseBody;
            }else{
                return ResponseEntity.status(400).build();
            }
        }
        return ResponseEntity.status(401).build();
    }


    @Autowired
    UserController(UserService userService, EventService eventService){
        super();
        this.userService = userService;
        this.eventsService = eventService;
    }

}
