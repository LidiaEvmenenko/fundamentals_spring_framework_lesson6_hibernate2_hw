package ru.geekbrains.hw6.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumers")
@NamedQueries({
       @NamedQuery(name = "consumerIdWithProducts", query = "SELECT c FROM Consumer c JOIN FETCH c.products WHERE c.id = :id")
})

public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "consumers_products",
        joinColumns = @JoinColumn(name = "consumer_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Consumer() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    @Override
    public String toString() {
        return String.format("Покупатель [id = %d, name = %s]", id, name);
    }
}
