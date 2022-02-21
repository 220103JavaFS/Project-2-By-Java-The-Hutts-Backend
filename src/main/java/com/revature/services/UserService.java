package com.revature.services;

import com.revature.models.Users;
import com.revature.models.loginDTO;

import com.revature.repo.UsersDAO;

import com.revature.utils.Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
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

    public Users findById(int id){return usersDAO.findById(id);}

    public Users findByUsername(String username) {
        return usersDAO.findByUsername(username);
    }

    public Users findUserByEmail(String email){
        return usersDAO.findByEmail(email);
    }

    public boolean loginUser(loginDTO user) throws NoSuchAlgorithmException {
        Users secure = usersDAO.findByUsername(user.getUsername());
        if (secure != null){
            String passcheck = encryptor.encoder(user.getPassword());
            String securepass = secure.getPassword();
            return securepass.equals(passcheck);
            }
        return false;
    }

    public boolean createUser(Users user) throws NoSuchAlgorithmException {
        user.setPassword(encryptor.encoder(user.getPassword()));
        System.out.println(user.getUserPreferences());
        try{
            usersDAO.save(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateUser(Users user) throws NoSuchAlgorithmException {
        usersDAO.findByUsername(user.getUsername());
            try{
                usersDAO.save(user);
            }catch(Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
    }
}
