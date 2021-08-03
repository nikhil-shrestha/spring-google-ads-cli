package com.example.demo.dao.repository;

import com.example.demo.dao.entity.DashboardReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardReportRepository extends JpaRepository<DashboardReport, Long> {

}