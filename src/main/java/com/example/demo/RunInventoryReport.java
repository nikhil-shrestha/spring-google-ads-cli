package com.example.demo;

import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

import com.beust.jcommander.Parameter;
import com.example.demo.dao.entity.DashboardReport;
import com.example.demo.dao.repository.DashboardReportRepository;
import com.google.api.ads.admanager.axis.factory.AdManagerServices;
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

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.*;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This example runs a typical daily inventory report.
 *
 * <p>Credentials and properties in {@code fromFile()} are pulled from the "ads.properties" file.
 * See README for more info.
 */
public class RunInventoryReport {

  private static DashboardReportRepository dashboardRepository;

  @Autowired
  DashboardReportRepository dashboardReportRepository;

  @PostConstruct
  public void init() {
    this.dashboardRepository = dashboardReportRepository;
  }

  private static class RunInventoryReportParams extends CodeSampleParams {
    @Parameter(
      names = ArgumentNames.PARENT_AD_UNIT_ID,
      required = true,
      description = "The ID of the order to run the report for.")
    private Long parentId;
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
  public static void runExample(AdManagerServices adManagerServices, AdManagerSession session, long parentId)
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
    reportQuery.setDimensions(new Dimension[]{Dimension.DATE});
    reportQuery.setColumns(
      new Column[]{
        Column.TOTAL_INVENTORY_LEVEL_UNFILLED_IMPRESSIONS,
        Column.TOTAL_LINE_ITEM_LEVEL_IMPRESSIONS,
        Column.TOTAL_LINE_ITEM_LEVEL_CLICKS,
        Column.TOTAL_LINE_ITEM_LEVEL_CPM_AND_CPC_REVENUE,
        Column.TOTAL_AD_REQUESTS,
        Column.TOTAL_RESPONSES_SERVED,
        Column.TOTAL_FILL_RATE,
        Column.AD_SERVER_CLICKS
      });

    // Set the filter statement.
    reportQuery.setStatement(statementBuilder.toStatement());

    // Set the dynamic date range type or a custom start and end date.
    reportQuery.setDateRangeType(DateRangeType.YESTERDAY);

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
    File file = File.createTempFile("inventory-report-", ".csv");

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
      List<Dashboard1> beans = new CsvToBeanBuilder(new FileReader(fileName))
        .withType(Dashboard1.class)
        .withSkipLines(1)
        .build()
        .parse();

      for (Dashboard1 obj : beans) {
        System.out.println(obj.toString());
        try {
          DashboardReport dashboardReport = new DashboardReport();
          dashboardReport.setDimensionDate(obj.getDate());
          dashboardReport.setUnfilledImpression(obj.getUnfilledImpression());
          dashboardReport.setImpression(obj.getImpression());
          dashboardReport.setRevenue(obj.getRevenue());
          dashboardReport.setAdRequest(obj.getAdRequest());
          dashboardReport.setResponses(obj.getServed());
          dashboardReport.setAdClicks(obj.getClicks());
          dashboardRepository.save(dashboardReport);
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

  public static void main(String[] args) {
    AdManagerSession session;
    try {
      // Generate a refreshable OAuth2 credential.
      Credential oAuth2Credential =
        new OfflineCredentials.Builder()
          .forApi(Api.AD_MANAGER)
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
    RunInventoryReportParams params = new RunInventoryReportParams();
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
