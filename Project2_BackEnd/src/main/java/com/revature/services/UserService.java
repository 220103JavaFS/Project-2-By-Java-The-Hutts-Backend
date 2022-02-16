package com.revature.services;

import com.revature.models.Users;
import com.revature.repo.EventsDAO;
import com.revature.repo.UsersDAO;
import com.revature.utils.Encryptor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    private final UsersDAO usersDAO;
    private static final Encryptor encryptor = new Encryptor();

    @Autowired
    public UserService(UsersDAO usersDAO) {
        super();
        this.usersDAO = usersDAO;
    }

    public boolean createUser(Users user) throws NoSuchAlgorithmException {
        encryptor.encoder(user.getPassword());
        try{
            usersDAO.save(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Optional<Users> findByUsername(String username) {
        return usersDAO.findByUsername(username);
    }

    public Optional<Users> findUserByEmail(String email){
        return usersDAO.findByEmail(email);
    }
}
