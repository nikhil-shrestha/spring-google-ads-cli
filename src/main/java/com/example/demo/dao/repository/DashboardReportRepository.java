package com.example.demo.dao.repository;

import com.example.demo.dao.entity.DashboardReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardReportRepository extends CrudRepository<DashboardReport, Long> {

}