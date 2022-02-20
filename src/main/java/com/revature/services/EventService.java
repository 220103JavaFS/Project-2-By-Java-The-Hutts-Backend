package com.revature.services;

import com.revature.models.Events;
import com.revature.models.Users;
import com.revature.repo.EventsDAO;
import com.revature.repo.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
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

    public List<Events> findEventsByCreator(int id){ return eventsDAO.findByCreatedByID(id);}

    public boolean saveEvent(Events events, int id){

        Set<Users> participants = null;

        try{
            if(events.getCreatedByID() == 0) {
                events.setCreatedByID(id);
                System.out.println(id);
//                System.out.println("set created byID");
            }
            if(events.getEventParticipants() == null)
                participants = new HashSet<>();
            else
                participants = events.getEventParticipants();

//            System.out.println("finding by userid");
            Users user = usersDAO.findById(id);
//            System.out.println("userfound");
            participants.add(user);
//            System.out.println("useradded to participants");
            events.setEventParticipants(participants);
//            System.out.println("saving event");
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
