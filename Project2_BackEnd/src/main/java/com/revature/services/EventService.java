package com.revature.services;

import com.revature.models.Events;
import com.revature.repo.EventsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    EventsDAO eventsDAO;

    @Autowired
    public EventService(EventsDAO eventsDAO) {
        super();
        this.eventsDAO = eventsDAO;
    }

    //EVENT SERVICES
    //ADD EVENT
    //UPDATE EVENT
    public boolean saveOrUpdateEvent(Events events){
        try{
            eventsDAO.save(events);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
