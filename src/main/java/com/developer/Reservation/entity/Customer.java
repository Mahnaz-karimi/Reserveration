package com.developer.reservation.entity;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private long id;
    @Column(name = "Customer_name")
    private String name;
    @Column(name = "telephone_number")
    private String tlf;

    public Customer() {
    }

    public Customer(String name, String tlf) {
        this.name = name;
        this.tlf = tlf;
    }

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

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
}
