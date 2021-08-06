package com.example.demo.dao.repository.geo;

import com.example.demo.dao.entity.geo.GeoAllReport;
import com.example.demo.dao.entity.geo.GeoHbReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoHbReportRepository extends JpaRepository<GeoHbReport, Long> {
}
