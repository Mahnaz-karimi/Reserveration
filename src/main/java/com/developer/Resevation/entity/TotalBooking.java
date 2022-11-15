package com.developer.Resevation.entity;

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
    @Column(name = "total_resevation")
    private long costumerId;

    public TotalBooking() {
    }

    public TotalBooking(long performanceId, long costumerId) {
        this.performanceId = performanceId;
        this.costumerId = costumerId;
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

    public long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(long costumerId) {
        this.costumerId = costumerId;
    }
}
