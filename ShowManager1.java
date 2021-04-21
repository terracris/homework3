import java.util.LinkedList;

	// Takes in a list of shows
class ShowManager1 {
	
	ShowManager1() {}

	
	/* 1. Inputs and Outputs
	Input: List of Shows
	Output: ShowSummary -> 3 lists
	
	 empty -> empty
	 
	 futurama, sesamestreet -> daytimelist(seasamestreet) , primetimelist(futurama) , latenight(empty)
	 
	 startrek2, futurama -> daytimelist() , primetimelist(futurama) , latenight(empty)
	
	
	2. subtasks
	
	- filter list to remove overnight shows
	- filter list to remove special shows
	- take filtered list and divide into sublists
		- to divide into sublists look at times
		
	3. Psuedo Code
	
	-  if show time is 1 => x => 6 remove show from list
	-  if show isSpecial == true remove show from list 
	-  if show time is 6 > x => 17 add to daytime list
	-  if show time is 17 > x => 22 add to day time list
	-  if show time is 22 > x => 24 && 0 > x > 1 add to late night list
	
	*/
	
	/**
	 *  given a list, it organizes it into valid shows during appropriate time intervals
	 * @param shows -- list of unorganized//invalid shows
	 * @return -- Show Manager -- 3 list that depend on time intervals
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
	LinkedList<Show> filteredList =  this.isValidShow(shows);
	ShowSummary finalList = new ShowSummary();
	
	for (Show aShow : filteredList) {
		if(  aShow.broadcastTime > 600 &&  aShow.broadcastTime <= 1700) {
			finalList.daytime.add(aShow);
		}
		else if (aShow.broadcastTime > 1700 &&  aShow.broadcastTime <= 2200){
			finalList.primetime.add(aShow);
			}
			else
				finalList.latenight.add(aShow);

	}
	
	return finalList;
	}
	
	// subtasts 1 and 2
	//will be chain fed a list 

/**
 * helper functions -- to remove invalid//surplus info
 * given a list of shows, filters through the list looking for time and if its special
 * @param shows -- list of shows
 * @return returns an organized list of valid shows
 */
			
	private LinkedList<Show> isValidShow( LinkedList<Show> shows ){
		
		LinkedList<Show> filteredList = new LinkedList<Show>();
		for (Show aShow :shows) {
			if ((100 > aShow.broadcastTime && aShow.broadcastTime < 600) || aShow.isSpecial) {

			}
			else
			filteredList.add(aShow);
		}
		return filteredList;
	}
}
