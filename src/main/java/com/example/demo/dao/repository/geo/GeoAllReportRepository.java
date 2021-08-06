package com.example.demo.dao.repository.geo;

import com.example.demo.dao.entity.geo.GeoAllReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoAllReportRepository extends JpaRepository<GeoAllReport, Long> {

}