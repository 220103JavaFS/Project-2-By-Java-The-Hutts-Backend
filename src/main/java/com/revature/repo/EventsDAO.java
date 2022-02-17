package com.revature.repo;

import com.revature.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventsDAO extends JpaRepository<Events, Integer> {

    public List<Events> findByCreatedByID(int createdByID);

    public Optional<List<Events>> findByStatus(boolean status);

}
