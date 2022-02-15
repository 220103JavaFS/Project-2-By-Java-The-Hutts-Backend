package com.revature.services;

import com.revature.models.Eventparticipants;
import com.revature.models.Events;
import com.revature.repo.EventparticipantsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventparticipantService {

    //EVENTS PARTICIPANTS SERVICE
    //SENT INVITATION
    private EventparticipantsDAO eventparticipantsDAO;

    @Autowired
    public EventparticipantService(EventparticipantsDAO eventparticipantsDAO) {
        super();
        this.eventparticipantsDAO = eventparticipantsDAO;
    }

    public List<Eventparticipants> findAllparticipants(){
        return eventparticipantsDAO.findAll();
    }

    public Eventparticipants findById(int id){
        return eventparticipantsDAO.findById(id).get();
    }

    public boolean savestatus(Eventparticipants eventparticipants){
     try{
         eventparticipantsDAO.save(eventparticipants);
     }catch(Exception e){
         e.printStackTrace();
         return false;
     }
     return true;
    }
}
