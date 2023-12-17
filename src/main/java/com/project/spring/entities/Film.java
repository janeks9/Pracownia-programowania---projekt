package com.project.spring.entities;

import org.joda.time.LocalDate;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {

    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "data_premiery", nullable = false)
    private LocalDate dataPremiery;

    @Column(name = "długość")
    private int dlugosc;

    @Column(name = "kraj_produkcji")
    private String krajProdukcji;

    public Film(){}

    public Film(String title, LocalDate dataPremiery, int dlugosc, String krajProdukcji) {
        this.title = title;
        this.dataPremiery = dataPremiery;
        this.dlugosc = dlugosc;
        this.krajProdukcji = krajProdukcji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDataPremiery() {
        return dataPremiery;
    }

    public void setDataPremiery(LocalDate dataPremiery) {
        this.dataPremiery = dataPremiery;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public String getKrajProdukcji() {
        return krajProdukcji;
    }

    public void setKrajProdukcji(String krajProdukcji) {
        this.krajProdukcji = krajProdukcji;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Reżyser_id", referencedColumnName = "id")
    private Director director;

    @OneToOne(mappedBy = "film")
    Finances finances;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "FILM_AKTORZY",
            joinColumns = @JoinColumn(name = "Film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Aktor_id", referencedColumnName = "id")
    )
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "FILM_GATUNEK",
            joinColumns = @JoinColumn(name = "Film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Gatunek_id", referencedColumnName = "id")
    )
    private List<Genre> genres = new ArrayList<>();

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
