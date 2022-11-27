package com.developer.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Reservation")
public class Reservation  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private long id;
    @Column(name = "performance_id")
    private long performanceId;
    @Column(name = "costumer_id")
    private long costumerId;
    @Column(name = "amount_of_reservation")
    private int reservationAmount;

    public Reservation(long performanceId, long costumerId, int reservationAmount) {
        this.performanceId = performanceId;
        this.costumerId = costumerId;
        this.reservationAmount = reservationAmount;
    }
}
