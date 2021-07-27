package com.example.demo.dao.repository;

  import com.example.demo.dao.entity.DashboardAdxReport;
  import org.springframework.data.repository.CrudRepository;
  import org.springframework.stereotype.Repository;

@Repository
public interface DashboardAdxReportRepository extends CrudRepository<DashboardAdxReport, Long> {

}