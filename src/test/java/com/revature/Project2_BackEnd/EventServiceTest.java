package com.revature.Project2_BackEnd;


import com.revature.models.Events;
import com.revature.models.Users;
import com.revature.models.loginDTO;
import com.revature.repo.EventsDAO;
import com.revature.repo.UsersDAO;
import com.revature.services.EventService;
import com.revature.services.UserService;
import com.revature.utils.Encryptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventServiceTest {
    @Mock
    private static EventsDAO eventsDAO;

    private static UserService userService;
    private static EventService eventService;

    @Mock
    private static UsersDAO usersDAO;
    private static Users testUser = new Users();
    private static Encryptor encode = new Encryptor();
    private static List<String> userpre = new ArrayList<String>();
    private static Events testEvents = new Events();
    private List<Events> testli = new ArrayList<Events>(){
        {add(testEvents);}
    };

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        testUser.setUserId(4);
        testUser.setUsername("admin");
        testUser.setFirstname("ad");
        testUser.setLastname("min");
        testUser.setPassword(encode.encoder("password"));
        testUser.setEmail("admin@admin.com");
        testUser.setUserPreferences(userpre);
        testEvents.setId(1);
        testEvents.setCreatedByID(4);
        MockitoAnnotations.openMocks(this);
        userService = new UserService(usersDAO);
        eventService = new EventService(eventsDAO, usersDAO);
        Mockito.when(userService.findById(4)).thenReturn(testUser);
        Mockito.when(eventService.findEventsByCreator(4)).thenReturn(testli);
    }

    @Test
    public void TestgetEvent(){
        List<Events> li = new ArrayList<Events>(){
            {add(testEvents);}
        };
        assertEquals(li, eventService.findEventsByCreator(4));
    }

    @Test
    public void testSaveEvents() throws NoSuchAlgorithmException{
        assertTrue(eventService.saveEvent(testEvents, 4));
    }
}
