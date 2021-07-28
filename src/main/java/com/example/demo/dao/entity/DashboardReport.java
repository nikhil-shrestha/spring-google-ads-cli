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

  @Column(name = "unfilled_impression")
  private Double unfilledImpression;

  @Column()
  private Double impression;

  @Column()
  private Double revenue;

  @Column(name = "ad_request")
  private Double adRequest;

  @Column()
  private Double responses;

  @Column(name = "ad_clicks")
  private Double adClicks;

  public DashboardReport(
    Long parentId,
    String dimensionDate,
    String unfilledImpression,
    String impression,
    String revenue,
    String adRequest,
    String responses,
    String adClicks) {
    System.out.println(
      parentId + " " +
        dimensionDate + " " +
        unfilledImpression + " " +
        impression + " " +
        revenue + " " +
        adRequest + " " +
        responses + " " +
        adClicks
    );
    this.parentId = parentId;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      this.dimensionDate = sdf.parse(dimensionDate);
    } catch (Exception e) {
      System.out.println("Error occurred " + e.getMessage());
    }
    this.unfilledImpression = Double.parseDouble(unfilledImpression);
    this.impression = Double.parseDouble(impression);
    this.revenue = Double.parseDouble(revenue);
    this.adRequest = Double.parseDouble(adRequest);
    this.responses = Double.parseDouble(responses);
    this.adClicks = Double.parseDouble(adClicks);
  }

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
    return revenue;
  }

  public void setRevenue(String revenue) {
    try {
      this.revenue = Double.parseDouble(revenue);
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
    return responses;
  }

  public void setResponses(String responses) {
    try {
      this.responses = Double.parseDouble(responses);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdClicks() {
    return adClicks;
  }

  public void setAdClicks(String adClicks) {
    try {
      this.adClicks = Double.parseDouble(adClicks);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "DashboardReport{" +
      "id=" + id +
      ", dimensionDate=" + dimensionDate +
      ", unfilledImpression=" + unfilledImpression +
      ", impression=" + impression +
      ", revenue=" + revenue +
      ", adRequest=" + adRequest +
      ", responses=" + responses +
      ", adClicks=" + adClicks +
      '}';
  }
}
