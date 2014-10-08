package edu.grinnell.csc207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.function.Predicate;

import edu.grinnell.glimmer.ushahidi.UshahidiCategory;
import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;
/**
 * Implements methods related to the Ushahidi data structure.
 * @author Ameer Shujjah
 * @author Camila Matoe Volkart
 */
public class UshahidiExtensions
{
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Print an incident
   * @param pen, the PrintWriter
   * @param incident, the UshahidiIncident object to be printed
   */
  public static void printIncident(PrintWriter pen, UshahidiIncident incident)
  {
    // Print all the relevant parts of the incident
    pen.println("Incident #:" + incident.getTitle());
    pen.println("Id #:" + incident.getId());
    pen.println("  " + incident.getDescription());
    pen.println("  Location : " + incident.getLocation());
    pen.println("  Status" + "(" + incident.getMode() + ","
                + incident.getActive() + "," + incident.getVerified() + ")");
    pen.println("  Date : " + incident.getDate().toString());
    ;
  }

  /**
   * Creates a UshahidiTestingClient of 12 UshahidiIncidents
   * @return a UshahidiTestingClient
   */
  public static UshahidiTestingClient createIncidents()
  {
    // Initialize the format for LocalDateTime, a UshahidiTestingClient
    // and an array of Strings for descriptions
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    UshahidiTestingClient result = new UshahidiTestingClient();
    String[] descriptions =
        { "Hi", "Bye", "Sure", "CSC207", "Is", "Really", "Cool", "Like",
         "Actually", "Mega", "Though", "bye" };
    for (int i = 0; i < 12; i++)
      {
        String strBegin;
        if (i <= 8)
          {
            strBegin = "2014-10-0" + (i + 1) + " 13:30";
          } // if
        else
          {
            strBegin = "2014-10-" + (i + 1) + " 13:30";
          } // else

        // Generate a UshahidiLocation object and a LocalDateTime based on strBegin
        UshahidiLocation location = new UshahidiLocation(i, "Latitude" + i);
        LocalDateTime date = LocalDateTime.parse(strBegin, formatter);
        // Create a UshahidiCategory
        UshahidiCategory[] categories = { new UshahidiCategory(i) };
        // Create the incident based on i
        UshahidiIncident temp =
            new UshahidiIncident(i, "Incident" + i, date, location,
                                 descriptions[i], categories);
        // Add the incident to the UshahidiTestingClient
        result.addIncident(temp);
      } // for, create 12 different incidents
    return result;
  }

  /**
   * Prints the incidents with the lowest and highest Id
   * @param incidents, a UshahidiClient Object
   * @throws Exception
   */
  public static void extremeIncidents(UshahidiClient incidents)
    throws Exception
  {
    // Initialize relevant variables
    PrintWriter pen = new PrintWriter(System.out, true);
    // Get the first incident and get its id and set it to
    // maxInt and minInt
    UshahidiIncident min = incidents.nextIncident();
    UshahidiIncident max = min;
    int id = min.getId();
    int maxInt = id;
    int minInt = id;
    UshahidiIncident temp;

    while (incidents.hasMoreIncidents())
      {
        temp = incidents.nextIncident();
        if (temp.getId() > maxInt)
          {
            maxInt = temp.getId();
            max = temp;
          } // if the Id is greater than maxInt
        else if (temp.getId() <= minInt)
          {
            minInt = temp.getId();
            min = temp;
          } // else if, the id is less than minInt
      } // while, there are more incidents

    UshahidiExtensions.printIncident(pen, max);
    UshahidiExtensions.printIncident(pen, min);

    pen.close();
  } // extremeIncidents(UshahidiTestingClient)

  /**
   * Given a string and PrintWriter object create a WebClient based on that
   * string and apply the extremeIncidents function on it
   * @param pen, a PrintWriter object
   * @param url, a string
   * @throws Exception
   */
  public static void webClient(PrintWriter pen, String url)
    throws Exception
  {
    UshahidiWebClient webclient = new UshahidiWebClient(url);
    extremeIncidents(webclient);
  } // webClient(PrintWriter, String)

  /**
   * Prints the filtered incidents from a UshahidiClient by the input begin and end date
   * @param pen, a PrintWriter object
   * @param incidents, a UshahidiClient object
   * @param begin, the begin date, a LocalDateTime object
   * @param end, the end date, a LocalDateTime object
   * @throws Exception
   */
  public static void dateSort(PrintWriter pen, UshahidiClient incidents,
                              LocalDateTime begin, LocalDateTime end)
    throws Exception
  {
    UshahidiIncident temp;
    while (incidents.hasMoreIncidents())
      {
        temp = incidents.nextIncident();
        if (temp.getDate().isAfter(begin) && temp.getDate().isBefore(end))
          {
            UshahidiExtensions.printIncident(pen, temp);
          } // if, the incident is within the specified dates
      } // while, there are more incidents
  } // datesSort(PrintWriter, UshahidiClient, LocalDateTime, LocalDateTime)

  /**
   * Sorts a UshahidiClient by the input begin and end date
   * @param incidents, a UshahidiClient object
   * @param begin, the begin date, a LocalDateTime object
   * @param end, the end date, a LocalDateTime object
   * @return a Vector<UshahidiIncident> with the filtered incidents.
   * @throws Exception
   */
  public static Vector<UshahidiIncident>
    dateSortVector(UshahidiClient incidents, LocalDateTime begin,
                   LocalDateTime end)
      throws Exception
  {
    UshahidiIncident temp;
    Vector<UshahidiIncident> result = new Vector<UshahidiIncident>();
    while (incidents.hasMoreIncidents())
      {
        temp = incidents.nextIncident();
        if (temp.getDate().isAfter(begin) && temp.getDate().isBefore(end))
          {
            result.addElement(temp);
          } // if, the incident is within the specified dates
      } // while, there are more incidents
    return result;
  } // datesSort(PrintWriter, UshahidiClient, LocalDateTime, LocalDateTime)

  /**
   * Prints all the incidents in the input Vector<UshahidiIncident> object.
   * @param vector, a Vector<UshahidiIncident> object.
   */
  public static void print(Vector<UshahidiIncident> vector)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(vector.size());
    for (int i = 0; i < vector.size(); i++)
      {
        UshahidiExtensions.printIncident(pen, vector.elementAt(i));
      } // for
  } // print(Vector<UshahidiIncident>)

  // Citation : http://stackoverflow.com/questions/837872/calculate-distance-in-meters-when-you-know-longitude-and-latitude-in-java

  /**
   * Calculates the distance in meters between two points expressed in 
   * latitudes and longitudes
   * @param lat1, latitude of the first point
   * @param lng1, longitude of the first point
   * @param lat2, latitude of the second point
   * @param lng2, longitude of the second point
   * @return a double, the distance in meters between the two points.
   */
  public static double distFrom(double lat1, double lng1, double lat2,
                                double lng2)
  {
    double earthRadius = 6371; //kilometers
    double dLat = Math.toRadians(lat2 - lat1);
    double dLng = Math.toRadians(lng2 - lng1);
    double a =
        Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(dLng / 2) * Math.sin(dLng / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double dist = (earthRadius * c);
    return dist;
  } // distFrom(double, double, double, double)

  /**
   * Returns a Vector<UshahidiIncident> object with all the filtered incidents
   * within the specified distance from the input latitude and longitude
   * @param vector, the Vector<UshahidiIncident> object with all the incidents
   * @param latitude, the latitude
   * @param longitude, the longitude
   * @param distance, the distance
   * @return a Vector<UshahidiIncident> with the filtered incidents.
   */
  public static Vector<UshahidiIncident>
    sortLocation(Vector<UshahidiIncident> vector, double latitude,
                 double longitude, double distance)
  {
    Vector<UshahidiIncident> result = new Vector<UshahidiIncident>();
    for (int i = 0; i < vector.size(); i++)
      {
        double incLatitude = vector.elementAt(i).getLocation().getLatitude();
        double incLongitude = vector.elementAt(i).getLocation().getLongitude();
        if (distFrom(incLatitude, latitude, incLongitude, longitude) < distance)
          {
            result.addElement(vector.elementAt(i));
          } // if, the incident lies within the specified distance
      } // for, all the incidents
    return result;
  } // sortLocation(Vector<UshahidiIncident>, double, double, double)

  /**
   * A generalized filter for Vector<UshahidiIncident> objects.
   * @param incidents, a Vector<UshahidiIncident>
   * @param predicate, a predicate to test the incidents with
   * @return a Vector<UshahidiInicident> with the filtered incidents.
   * @throws Exception
   */
  public static Vector<UshahidiIncident>
    filterIncidents(Vector<UshahidiIncident> incidents,
                    Predicate<UshahidiIncident> predicate)
      throws Exception
  {
    Vector<UshahidiIncident> result = new Vector<UshahidiIncident>();
    int length = incidents.size();
    for (int i = 0; i < length; i++)
      {
        if (predicate.test(incidents.get(i)))
          {
            result.add(incidents.get(i));
          } // if, incident is true for predicate
      } // for, loop through all incidents in vector
    return result;
  } // filterIncidents(Vector<UshahidiIncident>, Predicate <UshahidiIncident>)

  /**
   * A generalized filter for UshahidiClient objects.
   * @param incidents, a UshahidiClient object.
   * @param predicate, a predicate to test 
   * @return a Vector<UshahidiInicident> with the filtered incidents.
   * @throws Exception
   */
  public static Vector<UshahidiIncident>
    filterClientIncidents(UshahidiClient incidents,
                          Predicate<UshahidiIncident> predicate)
      throws Exception
  {
    // Initialize a temp UshahidiIncident and a Vector<UshahidiIncident>.
    UshahidiIncident temp;
    Vector<UshahidiIncident> result = new Vector<UshahidiIncident>();
    while (incidents.hasMoreIncidents())
      {
        temp = incidents.nextIncident();
        if (predicate.test(temp))
          {
            result.addElement(temp);
          } // if, the incident passes the predicate
      } // while, there are more incidents
    return result;
  } // filterIncidents(Vector<UshahidiIncident>, Predicate <UshahidiIncident>)

  /**
   * A textual interface for filtering Ushahidi Incidents from a webClient based on the 
   * input criteria.
   * @param url, The url of the webClient
   * @return a Vector<UshahidiClient>, the filtered vector
   * @throws Exception
   */
  public static Vector<UshahidiIncident> sortInterface(String url)
    throws Exception
  {
    // Initialize the webClient using the input Url, a PrintWriter and
    // a BufferedReader for input.
    UshahidiClient webclient = new UshahidiWebClient(url);
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes1 = new BufferedReader(new InputStreamReader(System.in));

    // Initialize the output vector and print the menu.
    Vector<UshahidiIncident> result = null;
    pen.println("Please select the number of one of the following options");
    pen.println("1 - DateSort, to filter incidents by a begin and end date.");
    pen.println("2 - IdSort, to filter incidents by id");
    pen.println("3 - TitleSort, to filter incidents by title");
    pen.println("4 - VerifiedSort, to filter all the verified incidents");
    pen.println("5 - LocaltionSort, to filter all incidents by location");
    int response = eyes1.read();
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

    // A switch statement based on the input  criterion.
    switch (response)
      {
      // For DateSort
        case '1':
          // Define a format for LocalDateTime
          DateTimeFormatter formatter =
              DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
          // Prompt the user for begin and end dates and convert them into
          // LocalDateTime objects.
          pen.println("Please enter the begin date (yyyy-MM-dd HH:mm)");
          String strBegin = eyes.readLine();
          LocalDateTime beginDate = LocalDateTime.parse(strBegin, formatter);
          pen.println("Please enter the end date (yyyy-MM-dd HH:mm)");
          String strEnd = eyes.readLine();
          LocalDateTime endDate = LocalDateTime.parse(strEnd, formatter);
          // Use the generalized filter created in the previous part and an
          // anonymous function to sort by dates.
          result =
              filterClientIncidents(webclient,
                                    (UshahidiIncident incident) ->
                                      {
                                        return (incident.getDate()
                                                        .isAfter(beginDate) && incident.getDate()
                                                                                       .isBefore(endDate));
                                      });
          pen.println("Incidents filtered according to dates " + strBegin
                      + " and " + endDate);
          break;
        // For IdSort
        case '2':
          // Prompt the user for begin and end id's
          pen.println("Please enter the begin id (an int)");
          int beginId = Integer.parseInt(eyes.readLine());
          pen.println("Please enter the end id (an int)");
          int endId = Integer.parseInt(eyes.readLine());
          if ((beginId < 0) || (endId < 0))
            {
              throw new Exception("Please enter valid input ids");

            } // if id less than 0, throw exception
          // Use the generalized filter created in the previous part and an
          // anonymous function to sort by id.
          result =
              filterClientIncidents(webclient,
                                    (UshahidiIncident incident) ->
                                      {
                                        return (incident.getId() > beginId && incident.getId() < endId);
                                      });
          pen.println("Incidents filtered according to id's " + beginId
                      + " and " + endId);
          break;
        // For TitleSort
        case '3':
          // Prompt the user for the input title
          pen.println("Please enter the title of the incident (a String)");
          String title = eyes.readLine();
          // Use the generalized filter created in the previous part and an
          // anonymous function to sort by title.
          result =
              filterClientIncidents(webclient,
                                    (UshahidiIncident incident) ->
                                      {
                                        return (incident.getTitle().equals(title));
                                      });
          pen.println("Incidents filtered according to title = " + title);
          break;
        case '4':
          // Prompt the user for the verified status
          pen.println("VerifiedFiler: Please enter the verified status, true or false");
          String verified = eyes.readLine();
          boolean ver;
          if (verified.equals("true"))
            {
              ver = true;
            } // if, verified is true
          else if (verified.equals("false"))
            {
              ver = false;
            } // else if, verified is false
          else
            {
              throw new Exception("Invalid Input");
            } // else
          // Use the generalized filter created in the previous part and an
          // anonymous function to sort by verification.
          result =
              filterClientIncidents(webclient, (UshahidiIncident incident) ->
                                      {
                                        return (incident.getVerified() == ver);
                                      });
          pen.println("Incidents filtered according to verified status = "
                      + verified);
          break;
        case '5':
          // Prompt the user for the latitude, longitude and distance
          pen.println("Please enter the latitude (type double)");
          double latitude = Double.parseDouble(eyes.readLine());
          pen.println("Please enter the longitude (type double)");
          double longitude = Double.parseDouble(eyes.readLine());
          pen.println("Please enter the distance (in meters)");
          double distance = Double.parseDouble(eyes.readLine());
          // Use the generalized filter created in the previous part and an
          // anonymous function to sort by location.
          result =
              filterClientIncidents(webclient,
                                    (UshahidiIncident incident) ->
                                      {
                                        return (distFrom(incident.getLocation()
                                                                 .getLatitude(),
                                                         latitude,
                                                         incident.getLocation()
                                                                 .getLongitude(),
                                                         longitude) < distance);
                                      });
          pen.println("Incidents filtered by location, Latitude =  " + latitude
                      + " longitude = " + longitude + " distance/radius = "
                      + distance);

          break;
        // Default : invalid input.
        default:
          pen.println("Please enter a valid menu option.");
          sortInterface(url);
          break;
      } // switch

    return result;
  } // sortInterface(String)

} // UshahidiExtensions
