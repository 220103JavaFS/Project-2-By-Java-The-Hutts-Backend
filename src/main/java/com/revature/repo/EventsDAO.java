package com.revature.repo;

import com.revature.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventsDAO extends JpaRepository<Events, Integer> {

    public Optional<Events> findByCreatedByID(String createdByID);

    public Optional<Events> findByStatus(boolean status);

}
