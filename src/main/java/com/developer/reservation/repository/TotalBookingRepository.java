package com.developer.reservation.repository;

import com.developer.reservation.entity.TotalBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface TotalBookingRepository extends JpaRepository<TotalBooking, Long> {
    TotalBooking findTotalBookingByPerformanceId(long performanceId); // transaktioner
}

