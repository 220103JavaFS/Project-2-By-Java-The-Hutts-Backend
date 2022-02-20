package com.revature.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "eventid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    @JsonIgnoreProperties("usersEvents")
    Set<Users> eventParticipants;

    private String type;

    private boolean status;

    private String activity;

    private String endTime;

    private String startTime;

    private Integer createdByID;

    public Events() {
    }

    public Events(int id, Date date, Set<Users> eventParticipants, String type,  boolean status, String activity,
                  String endTime, String startTime, Integer createdByID) {
        this.id = id;
        this.date = date;
        this.eventParticipants = eventParticipants;
        this.type = type;
        this.status = status;
        this.activity = activity;
        this.endTime = endTime;
        this.startTime = startTime;
        this.createdByID = createdByID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Users> getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(Set<Users> eventParticipants) {
        this.eventParticipants = eventParticipants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getCreatedByID() {
        return createdByID;
    }

    public void setCreatedByID(Integer createdByID) {
        this.createdByID = createdByID;
    }
}