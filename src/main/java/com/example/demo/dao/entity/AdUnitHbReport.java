package com.example.demo.dao.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "AdUnitHb")
@Table(name = "ad_unit_hb")
public class AdUnitHbReport {
  @Id
  @SequenceGenerator(
    name = "ad_unit_hb_sequence",
    sequenceName = "ad_unit_hb_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "ad_unit_hb_sequence"
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

  @Column(name = "hB_impressions")
  private Double hBImpressions;

  @Column(name = "hB_item_clicks")
  private Double hBItemClicks;

  @Column(name = "hB_item_ctr")
  private Double hBItemCtr;

  @Column(name = "hB_revenue")
  private Double hBRevenue;

  @Column(name = "hB_ecpm")
  private Double hBECPM;

  @Column(name = "hB_eligible_impressions")
  private Double hBEligibleImpressions;

  @Column(name = "hB_measurable_impressions")
  private Double hBMeasurableImpressions;

  @Column(name = "hB_viewable_impressions")
  private Double hBViewableImpressions;

  public AdUnitHbReport() {
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

  public Double getHbImpressions() {
    return hBImpressions;
  }

  public void setHbImpressions(String impression) {
    try {
      System.out.println("impression = " + impression);
      this.hBImpressions = Double.parseDouble(impression);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getHbItemClicks() {
    return hBItemClicks;

  }

  public void setHbItemClicks(String click) {
    try {
      this.hBItemClicks = Double.parseDouble(click);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getHbItemCtr() {
    return hBItemCtr;
  }

  public void setHbItemCtr(String ctr) {
    try {
      this.hBItemCtr = Double.parseDouble(ctr);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getHbRevenue() {
    return hBRevenue;
  }

  public void setHbRevenue(String revenue) {
    try {
      this.hBRevenue = Double.parseDouble(revenue);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getHbECPM() {
    return hBECPM;
  }

  public void setHbECPM(String averageECPM) {
    try {
      this.hBECPM = Double.parseDouble(averageECPM);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getHbEligibleImpressions() {
    return hBEligibleImpressions;
  }

  public void setHbEligibleImpressions(String eligibleImpressions) {
    try {
      this.hBEligibleImpressions = Double.parseDouble(eligibleImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getHbMeasurableImpressions() {
    return hBMeasurableImpressions;
  }

  public void setHbMeasurableImpressions(String measurableImpressions) {
    try {
      this.hBMeasurableImpressions = Double.parseDouble(measurableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public Double getHbViewableImpressions() {
    return hBViewableImpressions;
  }

  public void setHbViewableImpressions(String viewableImpressions) {
    try {
      this.hBViewableImpressions = Double.parseDouble(viewableImpressions);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "AdUnitHbReport{" +
      "id=" + id +
      ", parentId=" + parentId +
      ", adUnitName='" + adUnitName + '\'' +
      ", date=" + date +
      ", advertiserName='" + advertiserName + '\'' +
      ", adUnitId=" + adUnitId +
      ", hBImpressions=" + hBImpressions +
      ", hBItemClicks=" + hBItemClicks +
      ", hBItemCtr=" + hBItemCtr +
      ", hBRevenue=" + hBRevenue +
      ", hBECPM=" + hBECPM +
      ", hBEligibleImpressions=" + hBEligibleImpressions +
      ", hBMeasurableImpressions=" + hBMeasurableImpressions +
      ", hBViewableImpressions=" + hBViewableImpressions +
      '}';
  }
}
