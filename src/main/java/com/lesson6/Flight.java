package com.lesson6;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "FLIGHT")
public class Flight {
    Long id;
    Plane plane;
    List<Passenger> passanger;
    Date dateFlight;
    String cityFrom;
    String cityTo;

    @Id
    @SequenceGenerator(name = "FLIGHT_SK", sequenceName = "FLIGHT_SK", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SK")
    public Long getId() {
        return id;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Plane getPlane() {
        return plane;
    }

    public List<Passenger> getPassanger() {
        return passanger;
    }

    public Date getDateFlight() {
        return dateFlight;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setPassanger(List<Passenger> passanger) {
        this.passanger = passanger;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }
}
