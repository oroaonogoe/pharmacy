package com.example.pharmacy.model.item;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "item_id")
    private String id;
    private String name;
    private boolean inStock;
    private double price;
    private boolean sign;
    private String country;
    private String expiredOn;
    private String pharma;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference(value = "category-item")
    private Category category;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_tag", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @JsonIgnoreProperties(value = "items")
    private List<Tag> tags;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    @JsonManagedReference(value = "desc")
    private List<Description> descriptions;

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(String expiredOn) {
        this.expiredOn = expiredOn;
    }

    public String getPharma() {
        return pharma;
    }

    public void setPharma(String pharma) {
        this.pharma = pharma;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }
}
