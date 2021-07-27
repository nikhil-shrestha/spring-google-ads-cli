package com.example.demo.dao.repository;

import com.example.demo.dao.entity.DashboardHbReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardHbReportRepository extends CrudRepository<DashboardHbReport, Long> {

}