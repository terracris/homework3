import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

//TODO go over edge cases with chris
public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();                  //takes in a list of shows
	LinkedList<Show> shows = new LinkedList<Show>();        //creates a list of shows by adding shows
	ShowSummary report1 = new ShowSummary();                //contains 3 lists which classifies shows by timing

	Show startrek = new Show("Star Trek", 1800, 45.0, false);
	Show futurama = new Show("Futurama", 1900, 23.0, false);
	Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
	Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);
	Show southpark = new Show("South Park", 2300, 22.0, false);
	Show twoandahalfmen = new Show("Two and a Half Men", 1800, 24.0, false);
	Show ppv = new Show("Pay per View", 2000, 180.0, true);
	Show ff5 = new Show("Fast and Furious 5", 0, 110.0, true);
	Show animalplanet = new Show("Animal Planet", 2, 80.0, false);
	Show ancientaliens = new Show("Ancient Aliens", 3, 45.0, false);

	
	/*
	-  if show time is 6 > x => 17 add to daytime list
	-  if show time is 17 > x => 22 add to prime time list
	-  if show time is 22 > x => 24 && 0 > x > 1 add to late night list
	 */
	
	public ShowExamples()
	{
		shows.add(startrek);
		report1.primetime.add(startrek);

		shows.add(futurama);
		report1.primetime.add(futurama);

		shows.add(animaniacs);
		report1.daytime.add(animaniacs);

		shows.add(sesamestreet);
		report1.daytime.add(sesamestreet);
	}
	
	@Test
	public void instructorTestShowSummary_EmptyReport() {
		ShowSummary report2 = new ShowSummary();
		assertFalse(report1.equals(report2));
	}


	@Test
	public void instructorTestShowSummary_WrongOrder() {
		ShowSummary report2 = new ShowSummary();

		report2.primetime.add(futurama);
		report2.primetime.add(startrek);
		report2.daytime.add(animaniacs);
		report2.daytime.add(sesamestreet);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_DifferentInstances() {
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);

		assertTrue(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_SameInstances() {
		ShowSummary report2 = report1;
		assertTrue(report1.equals(report2));
	}


	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}

	
	@Test
	public void UserTest() 
	{
		ShowSummary report3 = new ShowSummary();
		ShowSummary reportNotEqual = new ShowSummary();
		
		report3.latenight.add(ff5);
		report3.latenight.add(southpark);
		report3.primetime.add(twoandahalfmen);
		report3.primetime.add(ppv);
		
		reportNotEqual.latenight.add(southpark);
		reportNotEqual.latenight.add(ff5);
		reportNotEqual.primetime.add(ppv);
		reportNotEqual.primetime.add(twoandahalfmen);
		
		assertFalse(report3.equals(reportNotEqual));
		
		
	}

	@Test
	public void ShowManagerSpecial() 
	{
		LinkedList<Show> showsInput = new LinkedList<Show>();
		ShowSummary reportEqual = new ShowSummary();
		
		showsInput.add(ff5);
		showsInput.add(southpark);
		showsInput.add(twoandahalfmen);
		showsInput.add(ppv);
		
		reportEqual.latenight.add(southpark);
		reportEqual.primetime.add(twoandahalfmen);
		
		assertEquals(reportEqual, sm1.organizeShows(showsInput));
		
		
	}
	
	@Test
	public void ShowManagerlatelateNight() 
	{
		LinkedList<Show> showsInput = new LinkedList<Show>();
		ShowSummary reportEqual = new ShowSummary();
		
		showsInput.add(ff5);
		showsInput.add(southpark);
		showsInput.add(animalplanet);
		showsInput.add(twoandahalfmen);
		showsInput.add(ppv);
		showsInput.add(ancientaliens);
		
		reportEqual.latenight.add(southpark);
		reportEqual.primetime.add(twoandahalfmen);
		
		assertEquals(reportEqual, sm1.organizeShows(showsInput));
		
		
	}


}
