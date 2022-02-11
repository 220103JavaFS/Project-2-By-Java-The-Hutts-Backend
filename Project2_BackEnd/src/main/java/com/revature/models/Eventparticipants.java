package com.revature.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Eventparticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantsId;

    @ManyToOne(fetch = FetchType.EAGER)
    private ArrayList<Users> usersId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Events eventId;

    @Enumerated(EnumType.ORDINAL)
    private Roles role;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
