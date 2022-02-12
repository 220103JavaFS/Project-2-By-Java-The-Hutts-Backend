package com.revature.services;

import com.revature.models.Users;
import com.revature.repo.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UsersDAO usersDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UsersDAO usersDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.usersDAO = usersDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //USER SERVICES
    //registration
    //user update
    public boolean saveUser(Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersDAO.save(user);
        return true;
    }
    //findbyusername
    //login
    public Users findByUsername(String username) {
        return usersDAO.findByUsername(username);
    }


}
