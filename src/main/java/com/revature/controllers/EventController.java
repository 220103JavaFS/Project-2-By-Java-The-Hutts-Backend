package com.revature.controllers;
import com.revature.models.Events;
import com.revature.models.Users;
import com.revature.services.EventService;
import com.revature.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "users")
public class EventController {

    private EventService eventService;
    private UserService userService;

    @PostMapping("/addevent/{username}")
    public ResponseEntity<Events> addEvent(@RequestBody Events events, @PathVariable String username, HttpSession session){
            Users unsecure = userService.findByUsername(username);
            if (eventService.saveEvent(events, unsecure.getUserId())) {
                return ResponseEntity.status(201).build();
            }else{
                return ResponseEntity.status(400).build();
            }
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


    @GetMapping("/myevents/{username}")
    @ResponseBody
    public ResponseEntity<List<Events>> getEvents(@PathVariable String username,HttpSession session){
        Users unsecure = userService.findByUsername(username);
            List<Events> eventList = eventService.findEventsByCreator(unsecure.getUserId());
            if (eventList != null) {
                return ResponseEntity.status(200).body(eventList);
            }else{
                return ResponseEntity.status(400).build();
            }
    }

    @Autowired
    EventController(EventService eventService, UserService userService){
        super();
        this.eventService=eventService;
        this.userService=userService;
    }

}
