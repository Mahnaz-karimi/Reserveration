package com.developer.Resevation.entity;

import javax.persistence.*;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "reservation_id")
    private long id;
    @Column(name = "performance_id")
    private long performanceId;
    @Column(name = "costumer_id")
    private long costumerId;
    @Column(name = "amount_reservation")
    private int reservationAmount;

    public Reservation() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Reservation(long performanceId, long costumerId, int reservationAmount) {
        this.performanceId = performanceId;
        this.costumerId = costumerId;
        this.reservationAmount = reservationAmount;
    }

    public long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(long performanceId) {
        this.performanceId = performanceId;
    }

    public long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(long costumerId) {
        this.costumerId = costumerId;
    }

    public int getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(int reservationAmount) {
        this.reservationAmount = reservationAmount;
    }
}
