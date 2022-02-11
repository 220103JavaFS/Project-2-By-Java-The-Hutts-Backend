package com.revature.models;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @NotNull
    private String title;

    @NotNull
    @Value("${aDateStr}")
    private Date date;

    private Timestamp startTime;

    private Timestamp endTime;

    private String notes;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
