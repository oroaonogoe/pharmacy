package com.example.pharmacy.model.item;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "description")
    @JsonManagedReference(value = "sub-desc")
    private List<SubDes> subtitle;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    @JsonBackReference(value = "item_des")
    private Item item;

    public Description() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubDes> getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(List<SubDes> subtitle) {
        this.subtitle = subtitle;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
