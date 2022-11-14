package com.developer.Resevation.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "performance")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "performance_id")
    private long id;
    @Column(name = "performance_title")
    private String title;
    @Column(name = "performance_date")
    private Date dateOfPerformance;

    public Performance() {
    }

    public Performance(long id, String title, Date dateOfPerformance) {
        this.id = id;
        this.title = title;
        this.dateOfPerformance = dateOfPerformance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfPerformance() {
        return dateOfPerformance;
    }

    public void setDateOfPerformance(Date dateOfPerformance) {
        this.dateOfPerformance = dateOfPerformance;
    }
}
