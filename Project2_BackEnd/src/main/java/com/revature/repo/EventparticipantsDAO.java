package com.revature.repo;

import com.revature.models.Eventparticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventparticipantsDAO extends JpaRepository<Eventparticipants, Integer> {
}
