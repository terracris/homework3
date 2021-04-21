import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int)anum > 10000000;
  }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) {
    return ((int)dateNum % 10000) / 100;
  }

    public boolean isValid(double value) {
        return (0 <= value) && (500 >= value);
    }

//  CONSUMES A LIST OF DATA AND A MONTH
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
   LinkedList<Double> validValues = new LinkedList<Double>();
//    filter all invalid data
   for (int i = 0; i < data.size(); i++) {
       Double currentValue = data.get(i);
     if(isDate(currentValue) || isValid(currentValue)) {
       validValues.add(currentValue);
     }
   }
   return validValues;
  }
}