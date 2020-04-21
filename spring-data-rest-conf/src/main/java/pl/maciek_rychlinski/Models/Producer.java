package pl.maciek_rychlinski.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Producer implements Serializable {
    private static final long serialVersionUID=2l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private double totalInCome;
    @OneToMany(mappedBy = "producer")
    private List<Product> products;

    public Producer() {
    }

    public Producer(String name, String country, double totalInCome, List<Product> products){
        this.name=name;
        this.country=country;
        this.totalInCome=totalInCome;
        this.products=products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTotalInCome() {
        return totalInCome;
    }

    public void setTotalInCome(double totalInCome) {
        this.totalInCome = totalInCome;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
