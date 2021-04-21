import java.util.LinkedList;

/*
		1. sample cases 
		
		list(empty) , 10 -> empty

		list( nov11(11, 12, 9) dec(13) , 11) -> (nov11, 12) 

		list( nov11(11, 12, 9) nov15(1, 22, 4), 11 ) -> (nov11, 12), (nov15, 22) 


2.

--given a list of doubles that contains both dates and data
	--have a helper function that activates once a date is reconginzed to find max
		--run helper that finds date, then maxValue keeps updating until new date entry
			--upon date being found add current max, reset accum. maxValue, add date to list
				--remove the instanciating 0
					--feed list to another filter helper func., that filters out data points that follow the month were not looking for
					--feed to helper function that takes the filtered list of doubles and turns it into a list of MaxHzReading


3.

--if num is date - find max till next date
 	--once list is empty, run through list again and remove any invalid results( the 0 at the beginning)
 		--if date has month were looking for, add the data and the next value(reading) to a new list
 			--make the list of doubles a list of MaxHzReport




*/

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
  
  /**
   * given a list of data and a month, finds the max of each day of that month
   * @param data -- list of doubles that contains an 8-digit date, and recorded data
   * @param month -- int that is the month we look to filter by
   * @return for every recorded day in that month,
   *  give a list of MaxHzReport of the day and the max reading
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
   LinkedList<Double> holder = new LinkedList<Double>();
   Double maxValue = 0.0;
   for(Double aNum : data) {
	   if (this.isDate(aNum)) {
		   holder.add(maxValue);
		   maxValue = 0.0;
		   holder.add(aNum);
	   }
	   else
	   {
		   if( aNum > maxValue) {
			   maxValue = aNum;
		   }
	   }
   }
   holder.add(maxValue);
   return this.makeValidOutput(filterByMonth(removeInvalid(holder), month));
  }
  
  
  /**
   * helper function that is the first in the series of chain, to filter invalid data
   * @param inputList  -- raw list of data 
   * @return a filtered list that removes 0's and negative numbers
   */
  private LinkedList<Double> removeInvalid(LinkedList<Double> inputList) {
	  LinkedList<Double> filteredList = new LinkedList<Double>();
	  for (Double aDouble : inputList) {
		  if (aDouble > 0) {
			  filteredList.add(aDouble);
		  }
	  }
	  return filteredList;
  }
  
  /**
   * filter list by month
   * @param inputList -- filtered list with only valid data
   * @param month -- month to filter by
   * @return a filtered list contains a date for every maxValue
   */
  private LinkedList<Double> filterByMonth(LinkedList<Double> inputList, int month){
	  LinkedList<Double> filteredList = new LinkedList<Double>();
	  for(int i = 0; i < inputList.size(); i = i + 2) {
		  if( this.extractMonth(inputList.get(i)) == month) {
			  filteredList.add(inputList.get(i));
			  filteredList.add(inputList.get(i+1));
		  }
	  }
	  return filteredList;
  }
  
  /**
   * converts from list of doubles to list of MaxHzReport
   * @param inputList -- the final version of the list of Doubles
   * @return a list of MaxHzReport
   */
  private LinkedList<MaxHzReport> makeValidOutput(LinkedList<Double> inputList){
	  LinkedList<MaxHzReport> finalList = new LinkedList<MaxHzReport>();
	  for(int i = 0; i < inputList.size(); i = i + 2) {
		  finalList.add( new MaxHzReport(inputList.get(i), inputList.get(i+1)));
	  }
  return finalList;
  }
}  
