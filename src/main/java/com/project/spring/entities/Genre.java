package com.project.spring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GATUNEK")

public class Genre {

    @Id@GeneratedValue(generator = "gen2", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen2", sequenceName = "genre_seq")
    private int id;

    @Column(name = "gatunek", nullable = false)
    private String genre;

    public Genre(){}

    public Genre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @ManyToMany(mappedBy = "genres")
    List<Film> films;
}
