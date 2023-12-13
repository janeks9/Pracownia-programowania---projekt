import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REŻYSER")

public class Director {

    @Id@GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "director_seq")
    private int id;

    @Column(name = "imię", nullable = false)
    private String name;

    @Column(name = "nazwisko", nullable = false)
    private String surname;

    @Column(name = "data_urodzenia")
    private String dateOfBirth;

    @Column(name = "narodowość")
    private String country;

    public Director(){}


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
    @OneToMany(mappedBy = "director")
    List<Film> films = new ArrayList<>();
}
