package com.revature.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Eventparticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantsId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonManagedReference
    private Users userId;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "eventId")
    private Events eventId;

    @Enumerated(EnumType.ORDINAL)
    private Roles role;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Eventparticipants() {
    }

    public Eventparticipants(int participantsId, Users userId, Events eventId, Roles role, Status status) {
        this.participantsId = participantsId;
        this.userId = userId;
        this.eventId = eventId;
        this.role = role;
        this.status = status;
    }

    public int getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(int participantsId) {
        this.participantsId = participantsId;
    }

    public Users getUsersId() {
        return userId;
    }

    public void setUsersId(Users usersId) {
        this.userId = usersId;
    }

    public Events getEventId() {
        return eventId;
    }

    public void setEventId(Events eventId) {
        this.eventId = eventId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eventparticipants that = (Eventparticipants) o;
        return participantsId == that.participantsId && Objects.equals(userId, that.userId) && Objects.equals(eventId, that.eventId) && role == that.role && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantsId, userId, eventId, role, status);
    }

    @Override
    public String toString() {
        return "Eventparticipants{" +
                "participantsId=" + participantsId +
                ", usersId=" + userId +
                ", eventId=" + eventId +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
