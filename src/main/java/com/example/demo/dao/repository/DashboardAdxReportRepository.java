package com.example.demo.dao.repository;

  import com.example.demo.dao.entity.DashboardAdxReport;
  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.stereotype.Repository;

@Repository
public interface DashboardAdxReportRepository extends JpaRepository<DashboardAdxReport, Long> {

}