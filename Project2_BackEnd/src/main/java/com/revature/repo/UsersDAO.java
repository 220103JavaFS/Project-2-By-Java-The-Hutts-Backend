package com.revature.repo;

import com.revature.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsersDAO extends JpaRepository<Users, Integer> {

    public Optional<Users> findByEmail(String email);

    public Optional<Users> findByUsername(String username);

}
