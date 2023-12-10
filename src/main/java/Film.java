import javax.persistence.*;

@Entity
@Table(name = "FILM")
public class Film {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "tytuł", nullable = false)
    private String tytul;

    //JodaTime
    @Column(name = "data_premiery", nullable = false)
    private int dataPremiery;

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

    public int getDataPremiery() {
        return dataPremiery;
    }

    public void setDataPremiery(int dataPremiery) {
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

    @OneToOne(mappedBy = "film")
    Finances finances;
}
