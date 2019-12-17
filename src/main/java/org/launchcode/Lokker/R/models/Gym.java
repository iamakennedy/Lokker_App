package org.launchcode.Lokker.R.models;

import javax.persistence.*;

@Entity
public class Gym {

    @Id
    @GeneratedValue
    private int id;

    @GeneratedValue
    private int lokkerNumber;

    @ManyToOne
    private User user;

    @OneToMany
    private Lokkers lokkers;


}