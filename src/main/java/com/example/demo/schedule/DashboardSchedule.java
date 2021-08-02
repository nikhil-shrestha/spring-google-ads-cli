package com.example.demo.schedule;

import com.example.demo.service.DashboardAdxReportService;
import com.example.demo.service.DashboardHbReportService;
import com.example.demo.service.DashboardReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DashboardSchedule {
  @Autowired
  private DashboardHbReportService hbReportService;
  @Autowired
  private DashboardAdxReportService adxReportService;
  @Autowired
  private DashboardReportService allReportService;


  @Scheduled(cron = "0 0 1 * * ?")
  public void scheduleTask() throws Exception {
    String[] parentIds = new String[]{
      "21875886579",
      "21887933792",
      "21876902145",
      "21876718147",
      "21915945038"
    };

    for (String parentId : parentIds) {
      allReportService.save(parentId);
    }

    for (String parentId : parentIds) {
      adxReportService.save(parentId);
    }

    for (String parentId : parentIds) {
      hbReportService.save(parentId);
    }

  }
}
