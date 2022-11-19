package com.developer.reservation.entity;

import javax.persistence.*;

@Entity
@Table(name = "TotalBooking")
public class TotalBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private long id;
    @Column(name = "performance_id")
    private long performanceId;
    @Column(name = "total_reservation")
    private int totalBooking;

    public TotalBooking() {
    }

    public TotalBooking(long performanceId, int totalBooking) {
        this.performanceId = performanceId;
        this.totalBooking = totalBooking;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(long performanceId) {
        this.performanceId = performanceId;
    }

    public int getTotalBooking() {
        return totalBooking;
    }
    public void setTotalBooking(int totalBooking) {
        this.totalBooking = totalBooking;
    }
}
