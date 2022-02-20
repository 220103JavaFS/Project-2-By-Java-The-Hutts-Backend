package com.revature.Project2_BackEnd;

import com.revature.models.Users;
import com.revature.models.loginDTO;
import com.revature.repo.UsersDAO;
import com.revature.services.UserService;
import com.revature.utils.Encryptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private static UserService userService;

    @Mock
    private static UsersDAO usersDAO;
    private static Users testUser = new Users();
    private static Encryptor encode = new Encryptor();
    private static List<String> userpre = new ArrayList<String>();
    private static loginDTO login = new loginDTO();

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException{
        testUser.setUserId(4);
        testUser.setUsername("admin");
        testUser.setFirstname("ad");
        testUser.setLastname("min");
        testUser.setPassword(encode.encoder("password"));
        testUser.setEmail("admin@admin.com");
        testUser.setUserPreferences(userpre);
        login.setUsername("admin");
        login.setPassword("password");
        MockitoAnnotations.openMocks(this);
        userService = new UserService(usersDAO);
        Mockito.when(userService.findByUsername("admin")).thenReturn(testUser);
    }

    @Test
    public void testLogin()throws NoSuchAlgorithmException{
        assertTrue(userService.loginUser(login));
    }

    @Test
    public void testCreateUser() throws NoSuchAlgorithmException{
        assertTrue(userService.createUser(testUser));
    }

    @Test
    public void testFindByUsername(){
        assertEquals(testUser, userService.findByUsername(testUser.getUsername()));
    }
}
