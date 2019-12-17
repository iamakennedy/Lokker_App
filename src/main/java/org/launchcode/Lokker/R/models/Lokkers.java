package org.launchcode.Lokker.R.models;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;
        import javax.persistence.ManyToOne;

@Entity
public class Lokkers {
    @Id
    @GeneratedValue
    private int id;

    @GeneratedValue
    private int lokkerNumber;

    @ManyToOne
    private User user;

    //please add
    //ym class for functionality below
    @ManyToOne
    private Gym gym;

}