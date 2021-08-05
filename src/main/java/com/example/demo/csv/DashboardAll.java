package com.example.demo.csv;

import com.opencsv.bean.CsvBindByPosition;

public class DashboardAll {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String unfilledImpression;

  @CsvBindByPosition(position = 2)
  private String impression;

  @CsvBindByPosition(position = 3)
  private String lineItemClicks;

  @CsvBindByPosition(position = 4)
  private String cpmRevenue;

  @CsvBindByPosition(position = 5)
  private String adRequest;

  @CsvBindByPosition(position = 6)
  private String responseServed;

  @CsvBindByPosition(position = 7)
  private String fillRate;

  public String getDate() {
    return date;
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
