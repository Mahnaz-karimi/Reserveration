package com.developer.reservation.repository;

import com.developer.reservation.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    List<Performance> findPerformanceByDateOfPerformance(Date date);
    List<Performance> findPerformanceByTitle(String title);
}
