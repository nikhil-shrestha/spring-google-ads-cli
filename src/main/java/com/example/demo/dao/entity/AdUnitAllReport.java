package com.example.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "AdUnit")
@Table(name = "ad_unit")
public class AdUnitAllReport implements Serializable {
  @Id
  @SequenceGenerator(
    name = "ad_unit_sequence",
    sequenceName = "ad_unit_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "ad_unit_sequence"
  )
  @Column(
    name = "id",
    updatable = false
  )
  private Long id;

  private Long parentId;

  @Column(name = "date")
  private Date date;

  @Column(name = "adUnit_name")
  private String adUnitName;

  @Column(name = "adUnit_id")
  private Long adUnitId;

  @Column(name = "advertiser_Name")
  private String advertiserName;

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

  public AdUnitAllReport() {
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

  public String getAdvertiserName() {
    return advertiserName;
  }

  public void setAdvertiserName(String advertiserName) {
    this.advertiserName = advertiserName;
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

  public void setTotalFillRate(String totalFillRate) {
    try {
      this.totalFillRate = Double.parseDouble(totalFillRate);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "AdUnitAllReport{" +
      "id=" + id +
      ", parentId=" + parentId +
      ", date=" + date +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId=" + adUnitId +
      ", totalUnfilledImpressions=" + totalUnfilledImpressions +
      ", totalImpressions=" + totalImpressions +
      ", totalItemClicks=" + totalItemClicks +
      ", totalRevenue=" + totalRevenue +
      ", totalAdRequest=" + totalAdRequest +
      ", totalResponseServed=" + totalResponseServed +
      ", totalFillRate=" + totalFillRate +
      '}';
  }
}
