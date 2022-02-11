package com.revature.models;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Value("${aDateStr}")
    private Date date;

    private Timestamp startTime;

    private Timestamp endTime;

    private String notes;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Events() {
    }

    public Events(int eventId, String title, Date date, Timestamp startTime, Timestamp endTime, String notes, Status status) {
        this.eventId = eventId;
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.notes = notes;
        this.status = status;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        Events events = (Events) o;
        return eventId == events.eventId && Objects.equals(title, events.title) && Objects.equals(date, events.date) && Objects.equals(startTime, events.startTime) && Objects.equals(endTime, events.endTime) && Objects.equals(notes, events.notes) && status == events.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, title, date, startTime, endTime, notes, status);
    }

    @Override
    public String toString() {
        return "Events{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", notes='" + notes + '\'' +
                ", status=" + status +
                '}';
    }
}
