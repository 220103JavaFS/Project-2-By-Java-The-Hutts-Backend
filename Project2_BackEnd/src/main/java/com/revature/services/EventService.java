package com.revature.services;

import com.revature.models.Events;
import com.revature.repo.EventsDAO;
import com.revature.repo.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EventService {

    private final EventsDAO eventsDAO;
    private final UsersDAO usersDAO;

    @Autowired
    public EventService(EventsDAO eventsDAO, UsersDAO usersDAO) {
        super();
        this.eventsDAO = eventsDAO;
        this.usersDAO = usersDAO;
    }

    public Events findEventById(int id){
        return eventsDAO.findById(id).get();
    }

    public List<Events> findAllEvents(){
        return eventsDAO.findAll();
    }

    public boolean saveOrUpdateEvent(Events events){
        try{
            eventsDAO.save(events);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean removeEventById(int id){
        try{
            eventsDAO.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
