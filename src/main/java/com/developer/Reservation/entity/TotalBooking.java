package com.developer.reservation.entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Data
@Entity
@Table(name = "total_booking")
public class TotalBooking  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private long id;
    @Column(name = "total_booking")
    private int totalBooking;

    @OneToOne(mappedBy = "totalBooking")
    private Performance performance;

    public TotalBooking() {
    }

    public TotalBooking( Performance performance, int amountBooking) {
        this.totalBooking = amountBooking;
        this.performance = performance;
    }
}
