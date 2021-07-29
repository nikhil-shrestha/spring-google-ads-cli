
package com.example.demo;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

import com.beust.jcommander.Parameter;
import com.example.demo.dao.entity.DashboardAdxReport;
import com.example.demo.dao.entity.DashboardHbReport;
import com.example.demo.dao.repository.DashboardAdxReportRepository;
import com.example.demo.dao.repository.DashboardHbReportRepository;
import com.google.api.ads.admanager.axis.factory.AdManagerServices;
import com.google.api.ads.admanager.axis.utils.v202105.DateTimes;
import com.google.api.ads.admanager.axis.utils.v202105.ReportDownloader;
import com.google.api.ads.admanager.axis.utils.v202105.StatementBuilder;
import com.google.api.ads.admanager.axis.v202105.ApiError;
import com.google.api.ads.admanager.axis.v202105.ApiException;
import com.google.api.ads.admanager.axis.v202105.Column;
import com.google.api.ads.admanager.axis.v202105.DateRangeType;
import com.google.api.ads.admanager.axis.v202105.Dimension;
import com.google.api.ads.admanager.axis.v202105.ExportFormat;
import com.google.api.ads.admanager.axis.v202105.ReportDownloadOptions;
import com.google.api.ads.admanager.axis.v202105.ReportJob;
import com.google.api.ads.admanager.axis.v202105.ReportQuery;
import com.google.api.ads.admanager.axis.v202105.ReportServiceInterface;
import com.google.api.ads.admanager.lib.client.AdManagerSession;
import com.google.api.ads.admanager.lib.utils.examples.ArgumentNames;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.ads.common.lib.utils.examples.CodeSampleParams;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.io.*;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This example runs a typical daily inventory report.
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the "ads.properties" file.
 * See README for more info.
 */
@Component
@Order(value = 3)
public class DashboardHbReportRunner implements CommandLineRunner {

  @Autowired
  private DashboardHbReportRepository dashboardHbReportRepository;


  private static class RunDashboardHbReportRunnerParams extends CodeSampleParams {
    @Parameter(
      names = ArgumentNames.PARENT_AD_UNIT_ID,
      required = true,
      description = "The ID of the order to run the report for.")
    private Long parentId;
  }

  private Date yesterday() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    return cal.getTime();
  }

  private Date thirtyDays() {
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, -30);
    return cal.getTime();
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
  public void runExample(AdManagerServices adManagerServices, AdManagerSession session, long parentId)
    throws IOException, InterruptedException {
    // Get the ReportService.
    ReportServiceInterface reportService =
      adManagerServices.get(session, ReportServiceInterface.class);

    List<String> order = new ArrayList<>();
    order.add("2813565031");
    order.add("2813507675");
    order.add("2813458214");
    order.add("2813646901");
    order.add("2813487542");
    order.add("2813643757");
    order.add("2813643757");
    String orderIds = String.join(",", order);

    // Create statement
    StatementBuilder statementBuilder =
      new StatementBuilder()
        .where("ORDER_ID IN (" + orderIds + ") AND PARENT_AD_UNIT_ID = :id")
        .withBindVariableValue("id", parentId)
        .removeLimitAndOffset();

    // Create report query.
    ReportQuery reportQuery = new ReportQuery();
    reportQuery.setDimensions(new Dimension[]{Dimension.DATE});
    reportQuery.setColumns(
      new Column[]{
        Column.AD_SERVER_IMPRESSIONS,
        Column.AD_SERVER_CLICKS,
        Column.AD_SERVER_CTR,
        Column.AD_SERVER_WITHOUT_CPD_AVERAGE_ECPM,
        Column.AD_SERVER_CPM_AND_CPC_REVENUE,
        Column.AD_SERVER_ACTIVE_VIEW_ELIGIBLE_IMPRESSIONS,
        Column.AD_SERVER_ACTIVE_VIEW_MEASURABLE_IMPRESSIONS,
        Column.AD_SERVER_ACTIVE_VIEW_VIEWABLE_IMPRESSIONS,
      });

    // Set the filter statement.
    reportQuery.setStatement(statementBuilder.toStatement());


    // Set the dynamic date range type or a custom start and end date.
//    reportQuery.setDateRangeType(DateRangeType.YESTERDAY);

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String yesterdayDateString = dateFormat.format(yesterday());
    String thirtyDaysDateString = dateFormat.format(thirtyDays());

    // Set the start and end dates or choose a dynamic date range type.
    reportQuery.setDateRangeType(DateRangeType.CUSTOM_DATE);
    reportQuery.setStartDate(DateTimes.toDateTime(yesterdayDateString+"T00:00:00", "America/New_York").getDate());
    reportQuery.setEndDate(DateTimes.toDateTime(thirtyDaysDateString+"T00:00:00", "America/New_York").getDate());

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
    File file = File.createTempFile("dashboard-hb-report-", ".csv");

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
      List<DashboardHb> beans = new CsvToBeanBuilder(new FileReader(fileName))
        .withType(DashboardHb.class)
        .withSkipLines(1)
        .build()
        .parse();

      for (DashboardHb obj : beans) {
        System.out.println(obj.toString());
        try {
          DashboardHbReport dashboardHbReport = new DashboardHbReport();
          dashboardHbReport.setParentId(parentId);
          dashboardHbReport.setDimensionDate(obj.getDate());
          dashboardHbReport.setImpression(obj.getImpression());
          dashboardHbReport.setAverageECPM(obj.getAverageECPM());
          dashboardHbReport.setClick(obj.getClick());
          dashboardHbReport.setCtr(obj.getCtr());
          dashboardHbReport.setRevenue(obj.getRevenue());
          dashboardHbReport.setEligibleImpressions(obj.getEligibleImpressions());
          dashboardHbReport.setMeasurableImpressions(obj.getMeasurableImpressions());
          dashboardHbReport.setViewableImpressions(obj.getViewableImpressions());
          dashboardHbReportRepository.save(dashboardHbReport);
        } catch (Exception e) {
          System.out.println("Error in data save");
          System.out.println("e = " + e);
          e.printStackTrace();
        }
      }

    } catch (IOException e) {
      System.err.printf("Request failed unexpectedly due to IOException: %s%n", e);
    }
  }

  @Override
  public void run(String... args) {
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
    DashboardHbReportRunner.RunDashboardHbReportRunnerParams params = new DashboardHbReportRunner.RunDashboardHbReportRunnerParams();
    if (!params.parseArguments(args)) {
      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.parentId = Long.parseLong("21875886579");
    }

    try {
      try {
        runExample(adManagerServices, session, params.parentId);
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
  }
}
