package edu.grinnell.csc207;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;
/**
 * Testing Class for the methods in UshahidiExtensions
 * @author Ameer Shujjah
 * @author Camila Mateo Volkart
 */
public class PrintIncidentExperiment
{
  public static void main(String[] args)
    throws Exception
  {
    // Create the output device
    PrintWriter pen = new PrintWriter(System.out, true);

    //UshahidiTestingClient temp = UshahidiExtensions.createIncidents();
    // One that requires connecting to the server
    UshahidiClient webclient =
        new UshahidiWebClient("http://ushahidi1.grinnell.edu/sandbox/");

    pen.println("-----------Part 3------------");
    //UshahidiExtensions.extremeIncidents(temp);
    //UshahidiExtensions.webClient(pen, "http://ushahidi1.grinnell.edu/sandbox/");

    // Citation : http://stackoverflow.com/questions/22463062/how-to-parse-format-dates-with-localdatetime-java-8

    String strBegin = "2014-10-01 12:30";
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateBegin = LocalDateTime.parse(strBegin, formatter);
    String strEnd = "2014-10-06 12:30";
    LocalDateTime dateEnd = LocalDateTime.parse(strEnd, formatter);
    pen.println("-------------Created Incident-----------");
    //UshahidiExtensions.dateSort(pen, temp, dateBegin, dateEnd);
    pen.println("---------------Web Client---------------");
    //UshahidiExtensions.dateSort(pen, webclient, dateBegin, dateEnd);

    pen.println("------------------Extra 2.a------------------");

    Vector<UshahidiIncident> vec =
        UshahidiExtensions.dateSortVector(webclient, dateBegin, dateEnd);
    UshahidiExtensions.print(vec);

    pen.println("------------------FILTER FUNCTION TEST------------------");

    pen.println("------------------DateSort Predicate------------------");
    // Test with predicate for dateSort
    UshahidiExtensions.print(UshahidiExtensions.filterIncidents(vec,
                                                                (UshahidiIncident incident) ->
                                                                  {
                                                                    return (incident.getDate()
                                                                                    .isAfter(dateBegin) && incident.getDate()
                                                                                                                   .isBefore(dateEnd));
                                                                  }));
    pen.println("------------------IdSort Predicate------------------");
    // Test with predicate for id
    UshahidiExtensions.print(UshahidiExtensions.filterIncidents(vec,
                                                                (UshahidiIncident incident) ->
                                                                  {
                                                                    return incident.getId() <= 26;
                                                                  }));

    pen.println("------------------Textual Interface------------------");
    UshahidiExtensions.print(UshahidiExtensions.sortInterface("http://ushahidi1.grinnell.edu/sandbox/"));

  }; // main(String[])

} // Class PrintIncidentExperiement

