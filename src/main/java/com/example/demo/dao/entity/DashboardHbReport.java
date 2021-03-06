package com.example.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity(name = "DashboardHb")
@Table(name = "dashboard_hb")
public class DashboardHbReport implements Serializable {
  @Id
  @SequenceGenerator(
    name = "dashboard_hb_sequence",
    sequenceName = "dashboard_hb_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "dashboard_hb_sequence"
  )
  @Column(
    name = "id",
    updatable = false
  )
  private Long id;

  @Column(name = "parent_id")
  private Long parentId;

  @Column(name = "date")
  private Date date;

  @Column(name = "advertiser_name")
  private String advertiserName;

  @Column(name = "device_name")
  private String deviceName;

  @Column(name = "ad_unit_name")
  private String adUnitName;

  @Column(name = "ad_unit_id")
  private Long adUnitId;

  @Column(name = "adserver_impressions")
  private Double adserverImpressions;

  @Column(name = "adserver_clicks")
  private Double adserverClicks;

  @Column(name = "adserver_ctr")
  private Double adserverCtr;

  @Column(name = "adserver_ecpm")
  private Double adserverECPM;

  @Column(name = "adserver_revenue")
  private Double adserverRevenue;

  @Column(name = "adserver_eligible_impressions")
  private Double adserverEligibleImpressions;

  @Column(name = "adserver_measurable_impressions")
  private Double adserverMeasurableImpressions;

  @Column(name = "adserver_viewable_impressions")
  private Double adserverViewableImpressions;


  public DashboardHbReport() {
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

  public Double getAdserverImpressions() {
    return adserverImpressions;
  }

  public void setAdserverImpressions(String impression) {
    try {
      this.adserverImpressions = Double.parseDouble(impression);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdserverClicks() {
    return adserverClicks;
  }

  public void setAdserverClicks(String click) {
    try {
      this.adserverClicks = Double.parseDouble(click);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdserverCtr() {
    return adserverCtr;
  }

  public void setAdserverCtr(String ctr) {
    try {
      this.adserverCtr = Double.parseDouble(ctr);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdserverECPM() {
    return adserverECPM;
  }

  public void setAdserverECPM(String averageECPM) {
    try {
      this.adserverECPM = Double.parseDouble(averageECPM);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdserverRevenue() {
    return adserverRevenue;
  }

  public void setAdserverRevenue(String revenue) {
    try {
      this.adserverRevenue = Double.parseDouble(revenue);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdserverEligibleImpressions() {
    return adserverEligibleImpressions;
  }

  public void setAdserverEligibleImpressions(String eligibleImpressions) {
    try {
      this.adserverEligibleImpressions = Double.parseDouble(eligibleImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdserverMeasurableImpressions() {
    return adserverMeasurableImpressions;
  }

  public void setAdserverMeasurableImpressions(String measurableImpressions) {
    try {
      this.adserverMeasurableImpressions = Double.parseDouble(measurableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdserverViewableImpressions() {
    return adserverViewableImpressions;
  }

  public void setAdserverViewableImpressions(String viewableImpressions) {
    try {
      this.adserverViewableImpressions = Double.parseDouble(viewableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "DashboardHbReport{" +
      "id=" + id +
      ", parentId=" + parentId +
      ", date=" + date +
      ", advertiserName='" + advertiserName + '\'' +
      ", deviceName='" + deviceName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId=" + adUnitId +
      ", adserverImpressions=" + adserverImpressions +
      ", adserverClicks=" + adserverClicks +
      ", adserverCtr=" + adserverCtr +
      ", adserverECPM=" + adserverECPM +
      ", adserverRevenue=" + adserverRevenue +
      ", adserverEligibleImpressions=" + adserverEligibleImpressions +
      ", adserverMeasurableImpressions=" + adserverMeasurableImpressions +
      ", adserverViewableImpressions=" + adserverViewableImpressions +
      '}';
  }
}
