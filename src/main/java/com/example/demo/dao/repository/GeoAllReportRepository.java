package com.example.demo.dao.repository;

import com.example.demo.dao.entity.GeoReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoAllReportRepository extends JpaRepository<GeoReport, Long> {
}