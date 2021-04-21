import java.util.LinkedList;

//TODO right second version of this function
class ShowManager2 {

	ShowManager2() {
	}
	/* 1. Inputs and Outputs
	Input: List of Shows
	Output: ShowSummary -> 3 lists

	 empty -> empty

	 futurama, sesamestreet -> daytimelist(seasamestreet) , primetimelist(futurama) , latenight(empty)

	 startrek2, futurama -> daytimelist() , primetimelist(futurama) , latenight(empty)


	2. subtasks

	- filter list to remove overnight shows and to remove special shows
	- from filtered list and create 3 sublists
		- to divide into sublists determine broadcast time

	3. Psuedo Code

	-  if show time is 1 => x => 6 remove show from list
	-  if show isSpecial == true remove show from list
	-  if show time is 6 > x => 17 add to daytime list
	-  if show time is 17 > x => 22 add to day time list
	-  if show time is 22 > x => 24 && 0 > x > 1 add to late night list

	*/

	/**
	 *  given a list, it organizes it into valid shows during appropriate time intervals
	 * @param shows -- list of unorganized/invalid shows
	 * @return -- Show Manager -- 3 list that depend on time intervals
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows) {
		LinkedList<Show> nonSpecialShows = new LinkedList<Show>();
		for (Show aShow : shows) {
			if (!aShow.isSpecial && isValid(aShow)) {
				nonSpecialShows.add(aShow);
			}
		}

		LinkedList<Show> daytime = new LinkedList<Show>();
		LinkedList<Show> primetime = new LinkedList<Show>();
		LinkedList<Show> latenight = new LinkedList<Show>();

		for (int j = 0; j < nonSpecialShows.size(); j = j + 1) {
			Show thisShow = nonSpecialShows.get(j);
				if (determineTime(thisShow).equals("daytime")) {
					daytime.add(thisShow);
				} else if (determineTime(thisShow).equals("primetime")) {
					primetime.add(thisShow);
				} else {
					latenight.add(thisShow);
				}
			}

		return new ShowSummary(daytime, primetime, latenight);
	}

	/**
	 *
	 * @param aShow Consumes a particular Show
	 * @return returns the string name of the associated broadcast time
	 */
	public String determineTime(Show aShow) {
		if( aShow.broadcastTime > 600 &&  aShow.broadcastTime <= 1700) {
			return "daytime";
		} else if (aShow.broadcastTime > 1700 &&  aShow.broadcastTime <= 2200) {
			return "primetime";
		} else
			return "latenight";

	}

	/**
	 * determines if a show has a valid broadcast time
	 * @param aShow Consumes a particular Show
	 * @return True if a show is within the appropriate time interval
	 */
	boolean isValid (Show aShow) {
		return !(100 > aShow.broadcastTime && aShow.broadcastTime < 600);
	}
}
