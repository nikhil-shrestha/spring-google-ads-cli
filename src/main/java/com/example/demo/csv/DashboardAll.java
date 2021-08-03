package com.example.demo.csv;

import com.opencsv.bean.CsvBindByPosition;

public class DashboardAll {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String advertiserName;

  @CsvBindByPosition(position = 2)
  private String deviceName;

  @CsvBindByPosition(position = 3)
  private String adUnitName;

  @CsvBindByPosition(position = 6)
  private String adUnitId;

  @CsvBindByPosition(position = 7)
  private String unfilledImpression;

  @CsvBindByPosition(position = 8)
  private String impression;

  @CsvBindByPosition(position = 9)
  private String lineItemClicks;

  @CsvBindByPosition(position = 10)
  private String cpmRevenue;

  @CsvBindByPosition(position = 11)
  private String adRequest;

  @CsvBindByPosition(position = 12)
  private String responseServed;

  @CsvBindByPosition(position = 13)
  private String fillRate;

  public String getDate() {
    return date;
  }

  public String getAdvertiserName() {
    return advertiserName;
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

  public String getUnfilledImpression() {
    return unfilledImpression;
  }

  public String getImpression() {
    return impression;
  }

  public String getLineItemClicks() {
    return lineItemClicks;
  }

  public String getCpmRevenue() {
    return cpmRevenue;
  }

  public String getAdRequest() {
    return adRequest;
  }

  public String getResponseServed() {
    return responseServed;
  }

  public String getFillRate() {
    return fillRate;
  }

  @Override
  public String toString() {
    return "DashboardAll{" +
      "date='" + date + '\'' +
      ", advertiserName='" + advertiserName + '\'' +
      ", deviceName='" + deviceName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId='" + adUnitId + '\'' +
      ", unfilledImpression='" + unfilledImpression + '\'' +
      ", impression='" + impression + '\'' +
      ", lineItemClicks='" + lineItemClicks + '\'' +
      ", cpmRevenue='" + cpmRevenue + '\'' +
      ", adRequest='" + adRequest + '\'' +
      ", responseServed='" + responseServed + '\'' +
      ", fillRate='" + fillRate + '\'' +
      '}';
  }
}
