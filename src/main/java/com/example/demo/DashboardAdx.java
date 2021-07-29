package com.example.demo;

import com.opencsv.bean.CsvBindByPosition;

public class DashboardAdx {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String impression;

  @CsvBindByPosition(position = 2)
  private String click;

  @CsvBindByPosition(position = 3)
  private String ctr;

  @CsvBindByPosition(position = 4)
  private String revenue;

  @CsvBindByPosition(position = 5)
  private String averageECPM;

  @CsvBindByPosition(position = 6)
  private String eligibleImpressions;

  @CsvBindByPosition(position = 7)
  private String measurableImpressions;

  @CsvBindByPosition(position = 8)
  private String viewableImpressions;

  @CsvBindByPosition(position = 9)
  private String adExchangeResponseServed;

  @CsvBindByPosition(position = 10)
  private String programmaticResponsesServed;


  public String getDate() {
    return date;
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
