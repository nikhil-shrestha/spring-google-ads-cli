package com.example.demo;

import com.opencsv.bean.CsvBindByPosition;

public class DashboardAll {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String unfilledImpression;

  @CsvBindByPosition(position = 2)
  private String impression;

  @CsvBindByPosition(position = 3)
  private String clicks;

  @CsvBindByPosition(position = 4)
  private String revenue;

  @CsvBindByPosition(position = 5)
  private String adRequest;

  @CsvBindByPosition(position = 6)
  private String served;

  public String getDate() {
    return date;
  }

  public String getUnfilledImpression() {
    return unfilledImpression;
  }

  public String getImpression() {
    return impression;
  }

  public String getClicks() {
    return clicks;
  }

  public String getRevenue() {
    return revenue;
  }

  public String getAdRequest() {
    return adRequest;
  }

  public String getServed() {
    return served;
  }

  @Override
  public String toString() {
    return "Dashboard1{" +
      "date='" + date + '\'' +
      ", unfilledImpression='" + unfilledImpression + '\'' +
      ", impression='" + impression + '\'' +
      ", clicks='" + clicks + '\'' +
      ", revenue='" + revenue + '\'' +
      ", adRequest='" + adRequest + '\'' +
      ", served='" + served + '\'' +
      '}';
  }
}
