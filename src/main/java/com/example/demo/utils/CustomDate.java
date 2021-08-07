package com.example.demo.utils;

import java.util.Calendar;
import java.util.Date;

public class CustomDate {
  public static Date yesterday() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    return cal.getTime();
  }

  public static Date thirtyDays() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, -30);
    return cal.getTime();
  }

  public static Date ninetyDays() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, -30);
    return cal.getTime();
  }
}
