package com.example.demo.dao.repository;

import com.example.demo.dao.entity.GeoHbReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoHbReportRepository extends JpaRepository<GeoHbReport, Long> {
}
