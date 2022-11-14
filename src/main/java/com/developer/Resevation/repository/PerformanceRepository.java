package com.developer.Resevation.repository;

import com.developer.Resevation.entity.Performance;
import com.developer.Resevation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
