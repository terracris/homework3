import java.util.LinkedList;
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ShowManager1 sm1 = new ShowManager1();                  //takes in a list of shows
	LinkedList<Show> shows = new LinkedList<Show>();        //creates a list of shows by adding shows
	ShowSummary report1 = new ShowSummary();                //contains 3 lists which classifies shows by timing
	LinkedList<Show> shows1 = new LinkedList<Show>(); 

	Show startrek = new Show("Star Trek", 1800, 45.0, false);
	Show futurama = new Show("Futurama", 1900, 23.0, false);
	Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
	Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);
	
	Show startrek2 = new Show("Star Trek", 1801, 60.0, true);
	Show futurama2 = new Show("Futurama", 1900, 20.0, false);
	Show animaniacs2 = new Show("Animaniacs", 1631, 9.0, true);
	Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

	shows.add(startrek);
	report1.primetime.add(startrek);

	shows.add(futurama);
	report1.primetime.add(futurama);

	shows.add(animaniacs);
	report1.daytime.add(animaniacs);

	shows.add(sesamestreet);
	report1.daytime.add(sesamestreet);

	
	
	shows1.add(startrek2);
	shows1.add(futurama2);
	shows1.add(animaniacs2);
	shows1.add(sesamestreet2);
	
	ShowSummary report2 = new ShowSummary();

	report2.primetime.add(startrek);		//futurama
	report2.primetime.add(futurama);		//startrek
	report2.daytime.add(animaniacs);		 //animaniacs
	report2.daytime.add(sesamestreet);         //sesamestreet
	
	System.out.println(report2.daytime.get(0).equals(report1.daytime.get(0)));
	System.out.println(report2.daytime.get(0));
	System.out.println(report1.daytime.get(0));

	System.out.println(report2.primetime.get(0).equals(report1.primetime.get(0)));
	System.out.println(report2.primetime.get(0).title);
	System.out.println(report1.primetime.get(0).title);
	System.out.println(startrek.equals(startrek2));//false
	System.out.println(futurama.equals(futurama2));//true
	
	System.out.println(report2.equals(report1));
	
	
	System.out.println(sm1.organizeShows(shows1)); //ShowSummary containing 3 lists
	System.out.println(sm1.organizeShows(shows1).daytime); //list of valid daytime shows
	System.out.println(sm1.organizeShows(shows1).primetime); //list of valid primetime shows
	System.out.println(sm1.organizeShows(shows1).latenight); //list of valid late night shows
	
	System.out.println(futurama2); 
	System.out.println(sesamestreet2);
	System.out.println(startrek2); 
	System.out.println(animaniacs2);
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	Earthquake1 E1 = new Earthquake1();
	  LinkedList<Double> noData = new LinkedList<Double>();
	  LinkedList<Double> threeDates = new LinkedList<Double>();  
	  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
	  
	  threeDates.add(20151013.0);
	    threeDates.add(10.0);
	    threeDates.add(5.0);
	    threeDates.add(20151020.0);
	    threeDates.add(40.0);
	    threeDates.add(40.0);
	    threeDates.add(50.0);
	    threeDates.add(40.0);
	    threeDates.add(45.0);
	    threeDates.add(20151101.0);
	    threeDates.add(6.0);
	  
	    
	    
	    LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
	    OctReports.add(new MaxHzReport(20151013.0,5.0));
	    OctReports.add(new MaxHzReport(20151020.0,45.0));
	 
	  
	  
	  
	  
	  
	System.out.println(E1.extractMonth(20151011));
	System.out.println(E1.extractMonth(20151611));
	System.out.println(E1.dailyMaxForMonth(threeDates, 10));
	System.out.println(E1.dailyMaxForMonth(threeDates, 12));
	System.out.println(E1.dailyMaxForMonth(noData, 10));
	System.out.println(NovReports);
	System.out.println(E1.dailyMaxForMonth(threeDates, 10).get(0).date);
	System.out.println(E1.dailyMaxForMonth(threeDates, 10).get(0).maxReading);
	System.out.println(E1.dailyMaxForMonth(threeDates, 10).get(1).date);
	System.out.println(E1.dailyMaxForMonth(threeDates, 10).get(1).maxReading);
	System.out.println(E1.dailyMaxForMonth(threeDates, 10));
	System.out.println(OctReports);
	}
}
