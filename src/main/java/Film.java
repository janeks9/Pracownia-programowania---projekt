import net.bytebuddy.asm.Advice;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {

    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "tytuł", nullable = false)
    private String tytul;

    //JodaTime
    @Column(name = "data_premiery", nullable = false)
    private String dataPremiery;

    @Column(name = "długość")
    private int dlugosc;

    @Column(name = "kraj_produkcji")
    private String krajProdukcji;

    public Film(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getDataPremiery() {
        return dataPremiery;
    }

    public void setDataPremiery(String dataPremiery) {
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

    @ManyToOne
    @JoinColumn(name = "Reżyser_id", referencedColumnName = "id")
    private Director director;

    @OneToOne(mappedBy = "film")
    Finances finances;

    @ManyToMany
    @JoinTable(
            name = "FILM_AKTORZY",
            joinColumns = @JoinColumn(name = "Film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Aktor_id", referencedColumnName = "id")
    )
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "FILM_GATUNEK",
            joinColumns = @JoinColumn(name = "Film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Gatunek_id", referencedColumnName = "id")
    )
    private List<Genre> genres;

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
