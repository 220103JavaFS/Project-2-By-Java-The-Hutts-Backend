package com.revature.controllers;

import com.revature.models.Eventparticipants;
import com.revature.models.Events;
import com.revature.services.EventparticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventparticipantController {
    private EventparticipantService eventparticipantService;

    @Autowired
    public EventparticipantController(EventparticipantService eventparticipantService) {
        this.eventparticipantService = eventparticipantService;
    }

    @GetMapping(value = "/invite")
    public ResponseEntity<List<Eventparticipants>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(eventparticipantService.findAllparticipants());
    }

    @PutMapping("/invite")
    public ResponseEntity<Events> updateEvent(@RequestBody Eventparticipants eventparticipants){
        if(eventparticipantService.savestatus(eventparticipants)){
            return ResponseEntity.status(202).build();
        }
        return ResponseEntity.status(400).build();
    }
}
