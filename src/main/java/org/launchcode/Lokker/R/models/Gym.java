package org.launchcode.Lokker.R.models;

        import javax.persistence.*;
        import javax.validation.constraints.NotNull;
        import javax.validation.constraints.Size;


@Entity
public class Gym {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotNull
    @Size(min = 3, max = 100)
    private String address;

    @ManyToOne
    private Cities city;
    private Boolean booked;


    private String datebooked;

    // @OneToMany
    // private List<Lokkers> lokkers = new ArrayList<>();

    public Gym() {
    }

    public Gym(String name, String address) {
        this.name = name;
        this.address = address;
        this.booked = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }

    public String getDatebooked() {
        return datebooked;
    }

    public void setDatebooked(String datebooked) {
        this.datebooked = datebooked;
    }
}