package com.lesson6.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "FLIGHT")
public class Flight {
    private Long id;
    private Plane plane;
    private List<Passenger> passanger;
    private Date dateFlight;
    private String cityFrom;
    private String cityTo;

    @Id
    @SequenceGenerator(name = "FLIGHT_SK", sequenceName = "FLIGHT_SK", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SK")
    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "PLANE")
    public Plane getPlane() {
        return plane;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "STORY",
            joinColumns = @JoinColumn(name = "FLIGHT"),
            inverseJoinColumns = @JoinColumn(name = "PASSENGER")
    )
    public List<Passenger> getPassanger() {
        return passanger;
    }

    @Column(name = "DATE_FLIGHT")
    public Date getDateFlight() {
        return dateFlight;
    }

    @Column(name = "CITY_FROM")
    public String getCityFrom() {
        return cityFrom;
    }

    @Column(name = "CITY_TO")
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

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", dateFlight=" + dateFlight +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                '}';
    }
}
