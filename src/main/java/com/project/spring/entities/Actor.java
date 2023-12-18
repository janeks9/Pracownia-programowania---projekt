package com.project.spring.entities;

import org.joda.time.LocalDate;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AKTOR")

public class Actor {

    @Id@GeneratedValue(generator = "gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen", sequenceName = "actor_seq")
    private int id;

    @Column(name = "imię", nullable = false)
    private String name;

    @Column(name = "nazwisko", nullable = false)
    private String surname;

    @Column(name = "data_urodzenia")
    private LocalDate dateOfBirth;

    @Column(name = "narodowość")
    private String country;

    public Actor(){}

    public Actor(String name, String surname, LocalDate dateOfBirth, String country) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
