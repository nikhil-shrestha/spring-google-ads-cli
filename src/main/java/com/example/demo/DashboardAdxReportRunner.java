package com.example.demo;

import com.example.demo.service.DashboardAdxReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
@Order(value = 2)
public class DashboardAdxReportRunner implements CommandLineRunner {

  @Autowired
  private DashboardAdxReportService adxReportService;

  @Override
  public void run(String... args) {
    long count = adxReportService.getCount();
    System.out.println(count);
    if (count == 0) {
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
        adxReportService.save(parentId, "runner");
        System.out.println("DASHBOARD ADX SAVED... ");
        System.out.println("\n\n\n");
      }
    }
  }
}
