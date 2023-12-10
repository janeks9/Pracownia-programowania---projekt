import javax.persistence.*;

@Entity
@Table(name = "GATUNEK")

public class Genre {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "gatunek", nullable = false)
    private String genre;

    public Genre(){}

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
}
