package com.example.demo.csv;

import com.opencsv.bean.CsvBindByPosition;

public class AdUnitHb {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String advertiserName;

  @CsvBindByPosition(position = 2)
  private String adUnitName;

  @CsvBindByPosition(position = 4)
  private String adUnitId;

  @CsvBindByPosition(position = 5)
  private String impression;

  @CsvBindByPosition(position = 6)
  private String click;

  @CsvBindByPosition(position = 7)
  private String ctr;

  @CsvBindByPosition(position = 8)
  private String averageECPM;

  @CsvBindByPosition(position = 9)
  private String revenue;

  @CsvBindByPosition(position = 10)
  private String eligibleImpressions;

  @CsvBindByPosition(position = 11)
  private String measurableImpressions;

  @CsvBindByPosition(position = 12)
  private String viewableImpressions;

  public String getDate() {
    return date;
  }

  public String getAdvertiserName() {
    return advertiserName;
  }

  public String getAdUnitName() {
    return adUnitName;
  }

  public String getAdUnitId() {
    return adUnitId;
  }

  public String getImpression() {
    return impression;
  }

  public String getClick() {
    return click;
  }

  public String getCtr() {
    return ctr;
  }

  public String getAverageECPM() {
    return averageECPM;
  }

  public String getRevenue() {
    return revenue;
  }

  public String getEligibleImpressions() {
    return eligibleImpressions;
  }

  public String getMeasurableImpressions() {
    return measurableImpressions;
  }

  public String getViewableImpressions() {
    return viewableImpressions;
  }

  @Override
  public String toString() {
    return "AdUnitHb{" +
      "date='" + date + '\'' +
      ", advertiserName='" + advertiserName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId='" + adUnitId + '\'' +
      ", impression='" + impression + '\'' +
      ", click='" + click + '\'' +
      ", ctr='" + ctr + '\'' +
      ", averageECPM='" + averageECPM + '\'' +
      ", revenue='" + revenue + '\'' +
      ", eligibleImpressions='" + eligibleImpressions + '\'' +
      ", measurableImpressions='" + measurableImpressions + '\'' +
      ", viewableImpressions='" + viewableImpressions + '\'' +
      '}';
  }
}