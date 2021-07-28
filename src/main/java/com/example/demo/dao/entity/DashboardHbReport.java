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
    name = "dashboardHb_sequence",
    sequenceName = "dashboardHb_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "dashboardHb_sequence"
  )
  @Column(
    name = "id",
    updatable = false
  )
  private Long id;

  @Column(name = "dimension_date")
  private Date dimensionDate;

  @Column()
  private Double impression;

  @Column()
  private Double click;

  @Column()
  private Double ctr;

  @Column()
  private Double revenue;

  @Column(name = "average_eCPM")
  private Double averageECPM;

  @Column(name = "eligible_impressions")
  private Double eligibleImpressions;

  @Column(name = "measurable_impressions")
  private Double measurableImpressions;

  @Column(name = "viewable_impressions")
  private Double viewableImpressions;

  @Column(name = "ad_exchange_responses_served")
  private Double adExchangeResponseServed;

  @Column(name = "programmatic_responses_served")
  private Double programmaticResponsesServed;


  public DashboardHbReport(
    String dimensionDate,
    String impression,
    String click,
    String ctr,
    String revenue,
    String averageECPM,
    String eligibleImpressions,
    String measurableImpressions,
    String viewableImpressions,
    String adExchangeResponseServed,
    String programmaticResponsesServed) {
    System.out.println(
      dimensionDate + " " +
        impression + " " +
        click + " " +
        ctr + " " +
        revenue + " " +
        averageECPM + " " +
        eligibleImpressions + " " +
        measurableImpressions + " " +
        viewableImpressions + " " +
        adExchangeResponseServed + " " +
        programmaticResponsesServed
    );
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      this.dimensionDate = sdf.parse(dimensionDate);
    } catch (Exception e) {
      System.out.println("Error occurred " + e.getMessage());
    }
    this.impression = Double.parseDouble(impression);
    this.click = Double.parseDouble(click);
    this.ctr = Double.parseDouble(ctr);
    this.revenue = Double.parseDouble(revenue);
    this.averageECPM = Double.parseDouble(averageECPM);
    this.eligibleImpressions = Double.parseDouble(eligibleImpressions);
    this.measurableImpressions = Double.parseDouble(measurableImpressions);
    this.viewableImpressions = Double.parseDouble(viewableImpressions);
    this.adExchangeResponseServed = Double.parseDouble(adExchangeResponseServed);
    this.programmaticResponsesServed = Double.parseDouble(programmaticResponsesServed);
  }

  public DashboardHbReport() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Double getClick() {
    return click;
  }

  public void setClick(String click) {
    try {
      this.click = Double.parseDouble(click);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getCtr() {
    return ctr;
  }

  public void setCtr(String ctr) {
    try {
      this.ctr = Double.parseDouble(ctr);
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


  public Double getAverageECPM() {
    return averageECPM;
  }

  public void setAverageECPM(String averageECPM) {
    try {
      this.averageECPM = Double.parseDouble(averageECPM);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }


  public Double getEligibleImpressions() {
    return eligibleImpressions;
  }

  public void setEligibleImpressions(String eligibleImpressions) {
    try {
      this.eligibleImpressions = Double.parseDouble(eligibleImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }


  public Double getMeasurableImpressions() {
    return measurableImpressions;
  }

  public void setMeasurableImpressions(String measurableImpressions) {
    try {
      this.measurableImpressions = Double.parseDouble(measurableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }


  public Double getViewableImpressions() {
    return viewableImpressions;
  }

  public void setViewableImpressions(String viewableImpressions) {
    try {
      this.viewableImpressions = Double.parseDouble(viewableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }


  public Double getAdExchangeResponseServed() {
    return adExchangeResponseServed;
  }

  public void setAdExchangeResponseServed(String adExchangeResponseServed) {
    try {
      if(adExchangeResponseServed != null){
        this.adExchangeResponseServed = Double.parseDouble(adExchangeResponseServed);
      }
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getProgrammaticResponsesServed() {
    return programmaticResponsesServed;
  }

  public void setProgrammaticResponsesServed(String programmaticResponsesServed) {
    try {
      if(programmaticResponsesServed != null){
        this.programmaticResponsesServed = Double.parseDouble(programmaticResponsesServed);
      }
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }


  @Override
  public String toString() {
    return "DashboardHbReport{" +
      "id=" + id +
      ", dimensionDate=" + dimensionDate +
      ", impression=" + impression +
      ", click=" + click +
      ", ctr=" + ctr +
      ", revenue=" + revenue +
      ", averageECPM=" + averageECPM +
      ", eligibleImpressions=" + eligibleImpressions +
      ", measurableImpressions=" + measurableImpressions +
      ", viewableImpressions=" + viewableImpressions +
      ", adExchangeResponseServed=" + adExchangeResponseServed +
      ", programmaticResponsesServed=" + programmaticResponsesServed +
      '}';
  }
}
