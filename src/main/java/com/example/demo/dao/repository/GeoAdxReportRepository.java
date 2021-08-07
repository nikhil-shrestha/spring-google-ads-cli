package com.example.demo.dao.repository;

import com.example.demo.dao.entity.GeoAdxReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoAdxReportRepository extends JpaRepository<GeoAdxReport, Long> {
}
