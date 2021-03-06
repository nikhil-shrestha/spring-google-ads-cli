package com.example.demo.schedule;

import com.example.demo.service.*;
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
  @Autowired
  private GeoAllReportService geoAllReportService;
  @Autowired
  private GeoAdxReportService geoAdxReportService;
  @Autowired
  private GeoHbReportService geoHbReportService;
  @Autowired
  private AdUnitReportService adUnitReportService;
  @Autowired
  private AdUnitAdxReportService adUnitAdxReportService;
  @Autowired
  private AdUnitHbReportService adUnitHbReportService;

  @Scheduled(cron = "0 0 1 * * ?")
  public void scheduleTask() throws Exception {
    String[] parentIds = {
      "21887933792",
      "21915945038",
      "21876718147",
      "21876902145",
      "21875886579",
      "21897089670",
      "21887988623",
      "21887783590",
      "21876587060",
      "21876425862",
    };

    for (String parentId : parentIds) {
      allReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      adxReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      hbReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      geoAllReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      geoAdxReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      geoHbReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      adUnitReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      adUnitAdxReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

    for (String parentId : parentIds) {
      adUnitHbReportService.save(parentId, "cron");
      Thread.sleep(5000);
    }

  }
}
