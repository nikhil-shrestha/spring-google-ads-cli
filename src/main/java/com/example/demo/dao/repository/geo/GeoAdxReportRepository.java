package com.example.demo.dao.repository.geo;

import com.example.demo.dao.entity.geo.GeoAdxReport;
import com.example.demo.dao.entity.geo.GeoAllReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoAdxReportRepository extends JpaRepository<GeoAdxReport, Long> {
}
