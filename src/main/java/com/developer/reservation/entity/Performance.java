package com.developer.reservation.entity;

import lombok.Data;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;


@Entity
@Transactional
@Data
@Table(name = "performance")
public class Performance  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Long id;
    @Column(name = "performance_title")
    private String title;
    @Column(name = "performance_date")
    private LocalDate dateOfPerformance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "total_booking_id", referencedColumnName = "id")
    private TotalBooking totalBooking;
    public Performance(String title) {
        this.title = title;
        this.dateOfPerformance= LocalDate.now(ZoneId.of("GMT+02:30"));
    }

    public Performance() {

    }
}
