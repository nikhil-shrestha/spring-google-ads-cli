package com.example.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity(name = "Dashboard")
@Table(name = "dashboard")
public class DashboardReport implements Serializable {
  @Id
  @SequenceGenerator(
    name = "dashboard_sequence",
    sequenceName = "dashboard_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "dashboard_sequence"
  )
  @Column(
    name = "id",
    updatable = false
  )
  private Long id;

  private Long parentId;

  @Column(name = "date")
  private Date date;

  @Column(name = "advertiser_name")
  private String advertiserName;

  @Column(name = "device_name")
  private String deviceName;

  @Column(name = "adUnit_name")
  private String adUnitName;

  @Column(name = "adUnit_id")
  private Long adUnitId;

  @Column(name = "total_unfilled_impressions")
  private Double totalUnfilledImpressions;

  @Column(name = "total_impressions")
  private Double totalImpressions;

  @Column(name = "total_item_clicks")
  private Double totalItemClicks;

  @Column(name = "total_revenue")
  private Double totalRevenue;

  @Column(name = "total_ad_request")
  private Double totalAdRequest;

  @Column(name = "total_response_served")
  private Double totalResponseServed;

  @Column(name = "total_fill_rate")
  private Double totalFillRate;


  public DashboardReport() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      this.date = sdf.parse(date);
    } catch (Exception e) {
      System.out.println("Error occurred " + e.getMessage());
    }
  }

  public String getAdvertiserName() {
    return advertiserName;
  }

  public void setAdvertiserName(String advertiserName) {
    this.advertiserName = advertiserName;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getAdUnitName() {
    return adUnitName;
  }

  public void setAdUnitName(String adUnitName) {
    this.adUnitName = adUnitName;
  }

  public Long getAdUnitId() {
    return adUnitId;
  }

  public void setAdUnitId(String adUnitId) {
    try {
      this.adUnitId = Long.parseLong(adUnitId);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalUnfilledImpressions() {
    return totalUnfilledImpressions;
  }

  public void setTotalUnfilledImpressions(String unfilledImpression) {
    try {
      this.totalUnfilledImpressions = Double.parseDouble(unfilledImpression);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalImpressions() {
    return totalImpressions;
  }

  public void setTotalImpressions(String impression) {
    try {
      this.totalImpressions = Double.parseDouble(impression);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalItemClicks() {
    return totalItemClicks;
  }

  public void setTotalItemClicks(String adClicks) {
    try {
      this.totalItemClicks = Double.parseDouble(adClicks);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(String revenue) {
    try {
      this.totalRevenue = Double.parseDouble(revenue);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalAdRequest() {
    return totalAdRequest;
  }

  public void setTotalAdRequest(String adRequest) {
    try {
      this.totalAdRequest = Double.parseDouble(adRequest);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalResponseServed() {
    return totalResponseServed;
  }

  public void setTotalResponseServed(String responseServed) {
    try {
      this.totalResponseServed = Double.parseDouble(responseServed);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalFillRate() {
    return totalFillRate;
  }

  public void setTotalFillRate(String fillRate) {
      try {
        this.totalFillRate = Double.parseDouble(fillRate);
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage());
      }
  }

  @Override
  public String toString() {
    return "DashboardReport{" +
      "id=" + id +
      ", parentId=" + parentId +
      ", date=" + date +
      ", advertiserName='" + advertiserName + '\'' +
      ", deviceName='" + deviceName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId=" + adUnitId +
      ", totalUnfilledImpression=" + totalUnfilledImpressions +
      ", totalImpression=" + totalImpressions +
      ", totalItemClicks=" + totalItemClicks +
      ", totalRevenue=" + totalRevenue +
      ", totalAdRequest=" + totalAdRequest +
      ", totalResponseServed=" + totalResponseServed +
      ", totalFillRate=" + totalFillRate +
      '}';
  }
}
