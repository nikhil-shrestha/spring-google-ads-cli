package com.example.demo.service;

import com.example.demo.csv.GeoAll;
import com.example.demo.dao.entity.GeoReport;
import com.example.demo.dao.repository.GeoAllReportRepository;
import com.example.demo.utils.CustomDate;
import com.google.api.ads.admanager.axis.factory.AdManagerServices;
import com.google.api.ads.admanager.axis.utils.v202105.DateTimes;
import com.google.api.ads.admanager.axis.utils.v202105.ReportDownloader;
import com.google.api.ads.admanager.axis.utils.v202105.StatementBuilder;
import com.google.api.ads.admanager.axis.v202105.*;
import com.google.api.ads.admanager.lib.client.AdManagerSession;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

@Service
public class GeoAllReportService {
  private static final Logger logger = LoggerFactory.getLogger(GeoAllReportService.class);

  @Autowired
  private GeoAllReportRepository geoAllReportRepository;

  public long getCount() {
    return geoAllReportRepository.count();
  }

  /**
   * Runs the example.
   *
   * @param adManagerServices the services factory.
   * @param session           the session.
   * @throws ApiException         if the API request failed with one or more service errors.
   * @throws RemoteException      if the API request failed due to other errors.
   * @throws IOException          if the report's contents could not be written to a temp file.
   * @throws InterruptedException if the thread was interrupted while waiting for the report to be
   *                              ready.
   */
  public void runExample(AdManagerServices adManagerServices, AdManagerSession session, long parentId, String type)
    throws IOException, InterruptedException {
    // Get the ReportService.
    ReportServiceInterface reportService =
      adManagerServices.get(session, ReportServiceInterface.class);

    // Create statement
    StatementBuilder statementBuilder =
      new StatementBuilder()
        .where("PARENT_AD_UNIT_ID = :id")
        .withBindVariableValue("id", parentId)
        .removeLimitAndOffset();

    // Create report query.
    ReportQuery reportQuery = new ReportQuery();
    reportQuery.setDimensions(
      new Dimension[]{
        Dimension.DATE,
        Dimension.CUSTOM_DIMENSION,
        Dimension.AD_UNIT_NAME,
        Dimension.COUNTRY_NAME
      });
    reportQuery.setColumns(
      new Column[]{
        Column.TOTAL_INVENTORY_LEVEL_UNFILLED_IMPRESSIONS,
        Column.TOTAL_LINE_ITEM_LEVEL_IMPRESSIONS,
        Column.TOTAL_LINE_ITEM_LEVEL_CLICKS,
        Column.TOTAL_LINE_ITEM_LEVEL_CPM_AND_CPC_REVENUE,
        Column.TOTAL_AD_REQUESTS,
        Column.TOTAL_RESPONSES_SERVED,
        Column.TOTAL_FILL_RATE
      });

    // Set the filter statement.
    reportQuery.setStatement(statementBuilder.toStatement());

    // Set the dynamic date range type or a custom start and end date.
    if (type.equals("cron")) {
      reportQuery.setDateRangeType(DateRangeType.YESTERDAY);
    } else {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String yesterdayDateString = dateFormat.format(CustomDate.yesterday());
      String thirtyDaysDateString = dateFormat.format(CustomDate.ninetyDays());

      // TODO: check default timezone (Google Adx TimeZone)
      reportQuery.setDateRangeType(DateRangeType.CUSTOM_DATE);
      reportQuery.setStartDate(DateTimes.toDateTime(thirtyDaysDateString + "T00:00:00", "America/New_York").getDate());
      reportQuery.setEndDate(DateTimes.toDateTime(yesterdayDateString + "T00:00:00", "America/New_York").getDate());
    }

    long[] id = {
      12597864
    };
    reportQuery.setCustomDimensionKeyIds(id);


    // Create report job.
    ReportJob reportJob = new ReportJob();
    reportJob.setReportQuery(reportQuery);

    // Run report job.
    reportJob = reportService.runReportJob(reportJob);

    // Create report downloader.
    ReportDownloader reportDownloader = new ReportDownloader(reportService, reportJob.getId());

    // Wait for the report to be ready.
    reportDownloader.waitForReportReady();

    // Change to your file location.
    File file = File.createTempFile("geo-all-report-", ".csv");

    System.out.printf("Downloading report to %s ...", file.toString());

    // Download the report.
    ReportDownloadOptions options = new ReportDownloadOptions();
    options.setExportFormat(ExportFormat.CSV_DUMP);
    options.setUseGzipCompression(false);
    URL url = reportDownloader.getDownloadUrl(options);
    Resources.asByteSource(url).copyTo(Files.asByteSink(file));

    System.out.println("done.");
    String fileName = file.toString();
    try {
      List<GeoAll> beans = new CsvToBeanBuilder(new FileReader(fileName))
        .withType(GeoAll.class)
        .withSkipLines(1)
        .build()
        .parse();

      for (GeoAll obj : beans) {
        try {
//          DashboardReport report = new DashboardReport();
//          report.setDimensionDate(obj.getDate());
//          Example<DashboardReport> example = Example.of(report);
//          Optional<DashboardReport> optional = geoReporRepository.findOne(example);
//
//          if(!optional.isPresent()) {
//
//          }

          GeoReport geoAllReport = new GeoReport();
          geoAllReport.setParentId(parentId);
          geoAllReport.setDate(obj.getDate());
          geoAllReport.setAdvertiserName(obj.getAdvertiserName());
          geoAllReport.setAdUnitName(obj.getAdUnitName());
          geoAllReport.setCountryName(obj.getCountryName());
          geoAllReport.setCountryCriteriaID(obj.getCountryCriteriaID());
          geoAllReport.setAdUnitId(obj.getAdUnitId());
          geoAllReport.setTotalUnfilledImpressions(obj.getUnfilledImpression());
          geoAllReport.setTotalImpressions(obj.getImpression());
          geoAllReport.setTotalItemClicks(obj.getLineItemClicks());
          geoAllReport.setTotalRevenue(obj.getCpmRevenue());
          geoAllReport.setTotalAdRequest(obj.getAdRequest());
          geoAllReport.setTotalResponseServed(obj.getResponseServed());
          geoAllReport.setTotalFillRate(obj.getFillRate());
          System.out.println(geoAllReport.toString());

          geoAllReportRepository.save(geoAllReport);

        } catch (Exception e) {
          System.out.println("Error in data save");
          e.printStackTrace();
        }
      }

    } catch (IOException e) {
      System.err.printf("Request failed unexpectedly due to IOException: %s%n", e);
    }
  }

  public void save(String pid, String type) {
    long start = System.currentTimeMillis();

    AdManagerSession session;
    try {
      // Generate a refreshable OAuth2 credential.
      Credential oAuth2Credential =
        new OfflineCredentials.Builder()
          .forApi(OfflineCredentials.Api.AD_MANAGER)
          .fromFile()
          .build()
          .generateCredential();

      // Construct a AdManagerSession.
      session =
        new AdManagerSession.Builder().fromFile().withOAuth2Credential(oAuth2Credential).build();
    } catch (ConfigurationLoadException cle) {
      System.err.printf(
        "Failed to load configuration from the %s file. Exception: %s%n",
        DEFAULT_CONFIGURATION_FILENAME, cle);
      return;
    } catch (ValidationException ve) {
      System.err.printf(
        "Invalid configuration in the %s file. Exception: %s%n",
        DEFAULT_CONFIGURATION_FILENAME, ve);
      return;
    } catch (OAuthException oe) {
      System.err.printf(
        "Failed to create OAuth credentials. Check OAuth settings in the %s file. "
          + "Exception: %s%n",
        DEFAULT_CONFIGURATION_FILENAME, oe);
      return;
    }

    AdManagerServices adManagerServices = new AdManagerServices();
    long parentId = Long.parseLong(pid);

    try {
      try {
        runExample(adManagerServices, session, parentId, type);
      } catch (ApiException apiException) {
        // ApiException is the base class for most exceptions thrown by an API request. Instances
        // of this exception have a message and a collection of ApiErrors that indicate the
        // type and underlying cause of the exception. Every exception object in the admanager.axis
        // packages will return a meaningful value from toString
        //
        // ApiException extends RemoteException, so this catch block must appear before the
        // catch block for RemoteException.
        System.err.println("Request failed due to ApiException. Underlying ApiErrors:");
        if (apiException.getErrors() != null) {
          int i = 0;
          for (ApiError apiError : apiException.getErrors()) {
            System.err.printf("  Error %d: %s%n", i++, apiError);
          }
        }
      } catch (RemoteException re) {
        System.err.printf("Request failed unexpectedly due to RemoteException: %s%n", re);
      }
    } catch (ApiException apiException) {
      // ApiException is the base class for most exceptions thrown by an API request. Instances
      // of this exception have a message and a collection of ApiErrors that indicate the
      // type and underlying cause of the exception. Every exception object in the adwords.axis
      // packages will return a meaningful value from toString
      //
      // ApiException extends RemoteException, so this catch block must appear before the
      // catch block for RemoteException.
      System.err.println("Request failed due to ApiException. Underlying ApiErrors:");
      if (apiException.getErrors() != null) {
        int i = 0;
        for (ApiError apiError : apiException.getErrors()) {
          System.err.printf("  Error %d: %s%n", i++, apiError);
        }
      }
    } catch (RemoteException re) {
      // RemoteException extends IOException, so this catch block must appear before the catch
      // block for IOException.
      System.err.printf("Request failed unexpectedly due to RemoteException: %s%n", re);
    } catch (IOException ioe) {
      System.err.printf("Request failed unexpectedly due to IOException: %s%n", ioe);
    } catch (InterruptedException ie) {
      System.err.printf(
        "Thread was interrupted while waiting for the report to be ready: %s.%n", ie);
    }
    long end = System.currentTimeMillis();
    logger.info("Total time {}", (end - start));
    return;
  }
}
