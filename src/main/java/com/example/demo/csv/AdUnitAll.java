
package com.example.demo.csv;

import com.opencsv.bean.CsvBindByPosition;


public class AdUnitAll {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String advertiserName;

  @CsvBindByPosition(position = 2)
  private String adUnitName;

  @CsvBindByPosition(position = 4)
  private String adUnitId;

  @CsvBindByPosition(position = 5)
  private String unfilledImpression;

  @CsvBindByPosition(position = 6)
  private String impression;

  @CsvBindByPosition(position = 7)
  private String lineItemClicks;

  @CsvBindByPosition(position = 8)
  private String cpmRevenue;

  @CsvBindByPosition(position = 9)
  private String adRequest;

  @CsvBindByPosition(position = 10)
  private String responseServed;

  @CsvBindByPosition(position = 11)
  private String fillRate;

  public String getAdUnitName() {
    return adUnitName;
  }

  public String getDate() {
    return date;
  }

  public String getAdvertiserName() {
    return advertiserName;
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
    return "AdUnitAll{" +
      "adUnitName='" + adUnitName + '\'' +
      ", date='" + date + '\'' +
      ", advertiserName='" + advertiserName + '\'' +
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

