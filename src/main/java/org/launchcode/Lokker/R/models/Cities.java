package org.launchcode.Lokker.R.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Cities {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private User user;

    @OneToMany
    private Lokkers lokkers;

    @OneToMany
    private Gym gym;



}


