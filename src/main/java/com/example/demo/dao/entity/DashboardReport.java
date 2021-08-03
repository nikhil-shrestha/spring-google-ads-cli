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

  @Column(name = "dimension_date")
  private Date dimensionDate;

  @Column(name = "advertiser_name")
  private String advertiserName;

  @Column(name = "device_name")
  private String deviceName;

  @Column(name = "adUnit_name")
  private String adUnitName;

  @Column(name = "adUnit_id")
  private Long adUnitId;

  @Column(name = "unfilled_impression")
  private Double unfilledImpression;

  @Column()
  private Double impression;

  @Column(name = "line_item_clicks")
  private Double lineItemClicks;

  @Column(name = "cpm_revenue")
  private Double cpmRevenue;

  @Column(name = "ad_request")
  private Double adRequest;

  @Column(name = "response_served")
  private Double responseServed;

  @Column(name = "fill_rate")
  private Double fillRate;


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


  public Date getDimensionDate() {
    return dimensionDate;
  }

  public void setDimensionDate(String dimensionDate) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      this.dimensionDate = sdf.parse(dimensionDate);
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

  public Double getUnfilledImpression() {
    return unfilledImpression;
  }

  public void setUnfilledImpression(String unfilledImpression) {
    try {
      this.unfilledImpression = Double.parseDouble(unfilledImpression);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }

  }

  public Double getImpression() {
    return impression;
  }

  public void setImpression(String impression) {
    try {
      this.impression = Double.parseDouble(impression);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getRevenue() {
    return cpmRevenue;
  }

  public void setRevenue(String revenue) {
    try {
      this.cpmRevenue = Double.parseDouble(revenue);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdRequest() {
    return adRequest;

  }

  public void setAdRequest(String adRequest) {
    try {
      this.adRequest = Double.parseDouble(adRequest);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getResponses() {
    return responseServed;
  }

  public void setResponses(String responseServed) {
    try {
      this.responseServed = Double.parseDouble(responseServed);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdClicks() {
    return lineItemClicks;
  }

  public void setAdClicks(String adClicks) {
    try {
      this.lineItemClicks = Double.parseDouble(adClicks);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "DashboardReport{" +
      "id=" + id +
      ", parentId=" + parentId +
      ", dimensionDate=" + dimensionDate +
      ", advertiserName='" + advertiserName + '\'' +
      ", deviceName='" + deviceName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId=" + adUnitId +
      ", unfilledImpression=" + unfilledImpression +
      ", impression=" + impression +
      ", lineItemClicks=" + lineItemClicks +
      ", cpmRevenue=" + cpmRevenue +
      ", adRequest=" + adRequest +
      ", responseServed=" + responseServed +
      ", fillRate=" + fillRate +
      '}';
  }
}
