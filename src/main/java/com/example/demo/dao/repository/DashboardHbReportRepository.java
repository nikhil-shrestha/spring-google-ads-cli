package com.example.demo.dao.repository;

import com.example.demo.dao.entity.DashboardHbReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardHbReportRepository extends JpaRepository<DashboardHbReport, Long> {

}