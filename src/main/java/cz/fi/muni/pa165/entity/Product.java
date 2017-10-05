package cz.fi.muni.pa165.entity;

import cz.fi.muni.pa165.enums.Color;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity @Table(name = "ESHOP_PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@NotNull
    @Column(nullable = false, unique = true)
    private String name;

    private Color color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Temporal(value = TemporalType.DATE)
    private Date addedDate;

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + name.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Product))
            return false;

        Product product = (Product) obj;
        return equalsNullable(name, product.getName());
    }

    private boolean equalsNullable(Object o1, Object o2) {
        return (o1 == null && o2 == null) || (o1 != null && o1.equals(o2));
    }
}
