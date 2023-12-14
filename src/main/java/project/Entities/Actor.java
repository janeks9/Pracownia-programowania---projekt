package project.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AKTOR")

public class Actor {

    @Id@GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "actor_seq")
    private int id;

    @Column(name = "imię", nullable = false)
    private String name;

    @Column(name = "nazwisko", nullable = false)
    private String surname;

    @Column(name = "data_urodzenia")
    private String dateOfBirth;

    @Column(name = "narodowość")
    private String country;

    public Actor(){}

    public Actor(String name, String surname, String dateOfBirth, String country) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ManyToMany(mappedBy = "actors")
    List<Film> films;
}
