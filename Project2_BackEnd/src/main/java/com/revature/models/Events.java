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
    Set<Users> eventParticipants;

    //    @JsonIgnoreProperties("userEvents")



    private String type;

    private float price;

    private boolean status;

    private String activity;

    private Timestamp endTime;

    private Timestamp startTime;

    private float accessibility;

    //number of people attending
    private Integer participants;

    private Integer createdByID;

    public Events() {
    }

    public Events(int id, Date date, Set<Users> eventParticipants, String type, float price, String notes, boolean status, String activity,
                  Timestamp endTime, Timestamp startTime, float accessibility, Integer participants, Integer createdByID) {
        this.id = id;
        this.date = date;
        this.eventParticipants = eventParticipants;
        this.type = type;
        this.price = price;
        this.status = status;
        this.activity = activity;
        this.endTime = endTime;
        this.startTime = startTime;
        this.accessibility = accessibility;
        this.participants = participants;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(float accessibility) {
        this.accessibility = accessibility;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public Integer getCreatedByID() {
        return createdByID;
    }

    public void setCreatedByID(Integer createdByID) {
        this.createdByID = createdByID;
    }
}