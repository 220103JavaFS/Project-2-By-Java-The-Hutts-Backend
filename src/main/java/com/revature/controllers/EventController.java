package com.revature.controllers;
import com.revature.models.Events;
import com.revature.services.EventService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "users")
@CrossOrigin
public class EventController {

    private EventService eventService;
    private UserService userService;

    @PostMapping("/addevent")
    public ResponseEntity<Events> addEvent(@RequestBody Events events, HttpSession session){
        if(session.getAttribute("login").equals(true)) {
            int id = (int) session.getAttribute("userID");
            System.out.println(id + "User id obtained");
            if (eventService.saveEvent(events, id)) {
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
            int id = (int) session.getAttribute("userID");
            if (eventService.saveEvent(events,id)) {
                return ResponseEntity.status(201).build();
            }else{
                return ResponseEntity.status(400).build();
            }
        }
        return ResponseEntity.status(401).build();
    }


    @GetMapping("/myevents")
    @ResponseBody
    public ResponseEntity<List<Events>> getEvents(HttpSession session){
        if(session.getAttribute("login").equals(true)) {
            int id = (int) session.getAttribute("userID");
            List<Events> eventList = eventService.findEventsByCreator(id);
            if (eventList != null) {
                return ResponseEntity.status(200).body(eventList);
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
