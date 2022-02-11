package com.revature.repo;

import com.revature.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsDAO extends JpaRepository<Events, Integer> {
}
