import javax.persistence.*;

@Entity
@Table(name = "FINANSE")

public class Finances {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "budżet", nullable = false)
    private int budget;

    @Column(name = "dochód")
    private int profit;

    public Finances(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Film_id", referencedColumnName = "id")
    Film film;
}
