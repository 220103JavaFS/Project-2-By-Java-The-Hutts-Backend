package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(mappedBy = "eventParticipants")
    @JsonIgnoreProperties("eventParticipants")
    Set<Events> usersEvents;

    @ElementCollection
    @CollectionTable(name = "user_preferences",
    joinColumns = @JoinColumn(name="userId"))
    @Column(name="userPreferences")
    private List<String> userPreferences = new ArrayList<String>();

    public Users() {
    }

    public Users(int userId, String firstname, String lastname, String username, String email, String password, Set<Events> usersEvents, List<String> userPreferences) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.usersEvents = usersEvents;
        this.userPreferences = userPreferences;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {this.password = password;}

    public Set<Events> getUsersEvents() {
        return usersEvents;
    }

    public void setUsersEvents(Set<Events> usersEvents) {this.usersEvents = usersEvents;}

    public List<String> getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(List<String> userPreferences) {
        this.userPreferences = userPreferences;
    }

}