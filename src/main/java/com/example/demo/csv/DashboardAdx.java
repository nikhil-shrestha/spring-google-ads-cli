package com.example.demo.csv;

import com.opencsv.bean.CsvBindByPosition;

public class DashboardAdx {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String customTargetKey;

  @CsvBindByPosition(position = 2)
  private String deviceName;

  @CsvBindByPosition(position = 3)
  private String adUnitName;

  @CsvBindByPosition(position = 6)
  private String adUnitId;

  @CsvBindByPosition(position = 7)
  private String impression;

  @CsvBindByPosition(position = 8)
  private String click;

  @CsvBindByPosition(position = 9)
  private String ctr;

  @CsvBindByPosition(position = 10)
  private String revenue;

  @CsvBindByPosition(position = 11)
  private String averageECPM;

  @CsvBindByPosition(position = 12)
  private String eligibleImpressions;

  @CsvBindByPosition(position = 13)
  private String measurableImpressions;

  @CsvBindByPosition(position = 14)
  private String viewableImpressions;

  @CsvBindByPosition(position = 15)
  private String adExchangeResponseServed;

  @CsvBindByPosition(position = 16)
  private String programmaticResponsesServed;

  public String getDate() {
    return date;
  }

  public String getCustomTargetKey() {
    return customTargetKey;
  }

  public String getDeviceName() {
    return deviceName;
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

  public String getRevenue() {
    return revenue;
  }

  public String getAverageECPM() {
    return averageECPM;
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

  public String getAdExchangeResponseServed() {
    return adExchangeResponseServed;
  }

  public String getProgrammaticResponsesServed() {
    return programmaticResponsesServed;
  }

  @Override
  public String toString() {
    return "DashboardAdx{" +
      "date='" + date + '\'' +
      ", customTargetKey='" + customTargetKey + '\'' +
      ", deviceName='" + deviceName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId=" + adUnitId +
      ", impression='" + impression + '\'' +
      ", click='" + click + '\'' +
      ", ctr='" + ctr + '\'' +
      ", revenue='" + revenue + '\'' +
      ", averageECPM='" + averageECPM + '\'' +
      ", eligibleImpressions='" + eligibleImpressions + '\'' +
      ", measurableImpressions='" + measurableImpressions + '\'' +
      ", viewableImpressions='" + viewableImpressions + '\'' +
      ", adExchangeResponseServed='" + adExchangeResponseServed + '\'' +
      ", programmaticResponsesServed='" + programmaticResponsesServed + '\'' +
      '}';
  }
}
