package com.revature.controllers;
import com.revature.models.Events;
import com.revature.models.Users;
import com.revature.services.EventService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "users")
@CrossOrigin
public class EventController {

    private EventService eventService;

    @PostMapping("/event")
    public ResponseEntity<Events> addEvent(@RequestBody Events events, HttpSession session){
        if(session.getAttribute("login").equals(true)) {
            if (eventService.saveEvent(events)) {
                return ResponseEntity.status(201).build();
            }else{
                return ResponseEntity.status(400).build();
            }
        }
        return ResponseEntity.status(401).build();
    }

    @PutMapping("/updateevent")
    public ResponseEntity<Events> updateEvent(@RequestBody Events events, HttpSession session){
        if(session.getAttribute("login").equals(true)) {
            if (eventService.saveEvent(events)) {
                return ResponseEntity.status(201).build();
            }else{
                return ResponseEntity.status(400).build();
            }
        }
        return ResponseEntity.status(401).build();
    }

    @Autowired
    EventController(EventService eventService){
        super();
        this.eventService=eventService;
    }

}
