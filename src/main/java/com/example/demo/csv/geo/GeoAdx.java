package com.example.demo.csv.geo;

import com.opencsv.bean.CsvBindByPosition;

public class GeoAdx {
  @CsvBindByPosition(position = 0)
  private String date;

  @CsvBindByPosition(position = 1)
  private String advertiserName;

  @CsvBindByPosition(position = 2)
  private String deviceName;

  @CsvBindByPosition(position = 3)
  private String adUnitName;

  @CsvBindByPosition(position = 4)
  private String countryName;

  @CsvBindByPosition(position = 7)
  private String adUnitId;

  @CsvBindByPosition(position = 8)
  private String countryCriteriaID;

  @CsvBindByPosition(position = 9)
  private String impression;

  @CsvBindByPosition(position = 10)
  private String click;

  @CsvBindByPosition(position = 11)
  private String ctr;

  @CsvBindByPosition(position = 12)
  private String revenue;

  @CsvBindByPosition(position = 13)
  private String averageECPM;

  @CsvBindByPosition(position = 14)
  private String eligibleImpressions;

  @CsvBindByPosition(position = 15)
  private String measurableImpressions;

  @CsvBindByPosition(position = 16)
  private String viewableImpressions;

  @CsvBindByPosition(position = 17)
  private String adExchangeResponseServed;

  @CsvBindByPosition(position = 18)
  private String programmaticResponsesServed;



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

  public String getCountryName() {
    return countryName;
  }

  public String getCountryCriteriaID() {
    return countryCriteriaID;
  }

  @Override
  public String toString() {
    return "GeoAdxReport{" +
      "date='" + date + '\'' +
      ", advertiserName='" + advertiserName + '\'' +
      ", deviceName='" + deviceName + '\'' +
      ", adUnitName='" + adUnitName + '\'' +
      ", adUnitId='" + adUnitId + '\'' +
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
      ", countryName='" + countryName + '\'' +
      ", countryCriteriaID='" + countryCriteriaID + '\'' +
      '}';
  }
}
