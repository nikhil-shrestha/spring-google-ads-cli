package com.example.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "AdUnitAdx")
@Table(name = "ad_unit_adx")
public class AdUnitAdxReport implements Serializable {
  @Id
  @SequenceGenerator(
    name = "ad_unit_adx_sequence",
    sequenceName = "ad_unit_adx_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "ad_unit_adx_sequence"
  )
  @Column(
    name = "id",
    updatable = false
  )
  private Long id;

  private Long parentId;

  @Column(name = "ad_unit_name")
  private String adUnitName;

  @Column(name = "date")
  private Date date;

  @Column(name = "advertiser_name")
  private String advertiserName;

  @Column(name = "ad_unit_id")
  private Long adUnitId;

  @Column(name = "adx_impressions")
  private Double adxImpressions;

  @Column(name = "adx_item_clicks")
  private Double adxItemClicks;

  @Column(name = "adx_item_ctr")
  private Double adxItemCtr;

  @Column(name = "adx_revenue")
  private Double adxRevenue;

  @Column(name = "adx_ecpm")
  private Double adxECPM;

  @Column(name = "adx_eligible_impressions")
  private Double adxEligibleImpressions;

  @Column(name = "adx_measurable_impressions")
  private Double adxMeasurableImpressions;

  @Column(name = "adx_viewable_impressions")
  private Double adxViewableImpressions;

  @Column(name = "adx_responses_served")
  private Double adxResponseServed;

  @Column(name = "adsense_responses_served")
  private Double adsenseResponsesServed;

  public AdUnitAdxReport() {
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

  public String getAdUnitName() {
    return adUnitName;
  }

  public void setAdUnitName(String adUnitName) {
    this.adUnitName = adUnitName;
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

  public Double getAdxImpressions() {
    return adxImpressions;
  }

  public void setAdxImpressions(String impression) {
    try {
      System.out.println("impression = " + impression);
      this.adxImpressions = Double.parseDouble(impression);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxItemClicks() {
    return adxItemClicks;

  }

  public void setAdxItemClicks(String click) {
    try {
      this.adxItemClicks = Double.parseDouble(click);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxItemCtr() {
    return adxItemCtr;
  }

  public void setAdxItemCtr(String ctr) {
    try {
      this.adxItemCtr = Double.parseDouble(ctr);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxRevenue() {
    return adxRevenue;
  }

  public void setAdxRevenue(String revenue) {
    try {
      this.adxRevenue = Double.parseDouble(revenue);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxECPM() {
    return adxECPM;
  }

  public void setAdxECPM(String averageECPM) {
    try {
      this.adxECPM = Double.parseDouble(averageECPM);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxEligibleImpressions() {
    return adxEligibleImpressions;
  }

  public void setAdxEligibleImpressions(String eligibleImpressions) {
    try {
      this.adxEligibleImpressions = Double.parseDouble(eligibleImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxMeasurableImpressions() {
    return adxMeasurableImpressions;
  }

  public void setAdxMeasurableImpressions(String measurableImpressions) {
    try {
      this.adxMeasurableImpressions = Double.parseDouble(measurableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxViewableImpressions() {
    return adxViewableImpressions;
  }

  public void setAdxViewableImpressions(String viewableImpressions) {
    try {
      this.adxViewableImpressions = Double.parseDouble(viewableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdxResponseServed() {
    return adxResponseServed;
  }

  public void setAdxResponseServe(String responseServed) {
    try {
      this.adxResponseServed = Double.parseDouble(responseServed);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getAdsenseResponsesServed() {
    return adsenseResponsesServed;
  }

  public void setAdsenseResponsesServed(String responseServed) {
    try {
      this.adsenseResponsesServed = Double.parseDouble(responseServed);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "AdUnitAdxReport{" +
      "id=" + id +
      ", parentId=" + parentId +
      ", adUnitName='" + adUnitName + '\'' +
      ", date=" + date +
      ", advertiserName='" + advertiserName + '\'' +
      ", adUnitId=" + adUnitId +
      ", adxImpressions=" + adxImpressions +
      ", adxItemClicks=" + adxItemClicks +
      ", adxItemCtr=" + adxItemCtr +
      ", adxRevenue=" + adxRevenue +
      ", adxECPM=" + adxECPM +
      ", adxEligibleImpressions=" + adxEligibleImpressions +
      ", adxMeasurableImpressions=" + adxMeasurableImpressions +
      ", adxViewableImpressions=" + adxViewableImpressions +
      ", adxResponseServed=" + adxResponseServed +
      ", adsenseResponsesServed=" + adsenseResponsesServed +
      '}';
  }
}
