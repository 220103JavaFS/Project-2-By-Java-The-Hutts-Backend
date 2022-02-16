package com.revature.controllers;
import com.revature.models.Events;
import com.revature.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EventController {

    EventService eventService;

    @PostMapping("/Event")
    public ResponseEntity<Events> addEvent(@RequestBody Events events){
        if(eventService.saveOrUpdateEvent(events)){
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

    @PutMapping("/Event")
    public ResponseEntity<Events> updateEvent(@RequestBody Events events){
        if(eventService.saveOrUpdateEvent(events)){
            return ResponseEntity.status(202).build();
        }
        return ResponseEntity.status(400).build();
    }
}
