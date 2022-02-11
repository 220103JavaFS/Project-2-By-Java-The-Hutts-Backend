package com.revature.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @Column(unique=true)
    @NotNull
    private String username;

    @Column(unique=true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private ArrayList<UserPreferences> userPreferences;
}
