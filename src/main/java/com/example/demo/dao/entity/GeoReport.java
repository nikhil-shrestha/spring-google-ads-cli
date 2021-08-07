package com.example.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "Geo")
@Table(name = "geo")
public class GeoReport implements Serializable {
  @Id
  @SequenceGenerator(
    name = "geo_sequence",
    sequenceName = "geo_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "geo_sequence"
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

  @Column(name = "country_name")
  private String countryName;

  @Column(name = "adUnit_id")
  private Long adUnitId;

  @Column(name = "country_criteria_id")
  private Long countryCriteriaID;

  @Column(name = "geo_total_unfilled_impressions")
  private Double totalUnfilledImpressions;

  @Column(name = "geo_total_impressions")
  private Double totalImpressions;

  @Column(name = "geo_total_item_clicks")
  private Double totalItemClicks;

  @Column(name = "geo_total_revenue")
  private Double totalRevenue;

  @Column(name = "geo_total_ad_request")
  private Double totalAdRequest;

  @Column(name = "geo_total_response_served")
  private Double totalResponseServed;

  @Column(name = "geo_total_fill_rate")
  private Double totalFillRate;

  public GeoReport() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
    System.out.println("this.id = " + this.id);
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

  public void setTotalUnfilledImpressions(String totalUnfilledImpressions) {
    try {
      this.totalUnfilledImpressions = Double.parseDouble(totalUnfilledImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalImpressions() {
    return totalImpressions;
  }

  public void setTotalImpressions(String totalImpressions) {
    try {
      this.totalImpressions = Double.parseDouble(totalImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalItemClicks() {
    return totalItemClicks;
  }

  public void setTotalItemClicks(String totalItemClicks) {
    try {
      this.totalItemClicks = Double.parseDouble(totalItemClicks);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(String totalRevenue) {
    try {
      this.totalRevenue = Double.parseDouble(totalRevenue);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalAdRequest() {
    return totalAdRequest;
  }

  public void setTotalAdRequest(String totalAdRequest) {
    try {
      this.totalAdRequest = Double.parseDouble(totalAdRequest);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getTotalResponseServed() {
    return totalResponseServed;
  }

  public void setTotalResponseServed(String totalResponseServed) {
    try {
      this.totalResponseServed = Double.parseDouble(totalResponseServed);
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


  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public Long getCountryCriteriaID() {
    return countryCriteriaID;
  }

  public void setCountryCriteriaID(String countryCriteriaID) {
    try {
      this.countryCriteriaID = Long.parseLong(countryCriteriaID);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "GeoAllReport{" +
      "id=" + id +
      ", parentId=" + parentId +
      ", date=" + date +
      ", advertiserName='" + advertiserName + '\'' +
      ", deviceName='" + deviceName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId=" + adUnitId +
      ", totalUnfilledImpressions=" + totalUnfilledImpressions +
      ", totalImpressions=" + totalImpressions +
      ", totalItemClicks=" + totalItemClicks +
      ", totalRevenue=" + totalRevenue +
      ", totalAdRequest=" + totalAdRequest +
      ", totalResponseServed=" + totalResponseServed +
      ", totalFillRate=" + totalFillRate +
      ", countryName='" + countryName + '\'' +
      ", countryCriteriaID=" + countryCriteriaID +
      '}';
  }
}
