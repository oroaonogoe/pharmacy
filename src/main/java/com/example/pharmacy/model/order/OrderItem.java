//package com.example.pharmacy.model.order;
//
//import com.example.pharmacy.model.item.Item;
//import jakarta.persistence.*;
//import org.hibernate.annotations.UuidGenerator;
//
//@Entity
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @UuidGenerator(style = UuidGenerator.Style.TIME)
//    @Column(name = "ot_id")
//    private String id;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    Order order;
//    @ManyToOne
//    @JoinColumn(name = "item_id")
//    Item item;
//    public OrderItem() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
//    }
//}
