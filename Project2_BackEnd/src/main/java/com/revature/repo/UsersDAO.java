package com.revature.repo;

import com.revature.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users, Integer> {
}
