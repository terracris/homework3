import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>(); 
  LinkedList<Double> negValues = new LinkedList<Double>(); 
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> negValuesAnswers = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    
    negValues.add(20200812.0);
    negValues.add(32.7);
    negValues.add(21.4);
    negValues.add(-1111.1);
    negValues.add(20200817.0);
    negValues.add(-2.4);
    negValues.add(2.7);
    negValues.add(-211.1);
    negValues.add(20200828.0);
    negValues.add(13.0);
    negValues.add(9.09);
    negValues.add(13.0);
    negValues.add(20200421.0);
    negValues.add(66.0);
    negValues.add(.09);
    negValues.add(-3.0);
    negValues.add(20200424.0);
    negValues.add(99.9);
    negValues.add(24.09);
    negValues.add(42.0);
    
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    
    OctReports.add(new MaxHzReport(2.0151013E7,10.0));
    OctReports.add(new MaxHzReport(2.015102E7,50.0));
    
    negValuesAnswers.add(new MaxHzReport(20200812.0, 32.7));
    negValuesAnswers.add(new MaxHzReport(20200817.0, 2.7));
    negValuesAnswers.add(new MaxHzReport(20200828.0, 13.0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void TestEQ_OctBase() { 
    assertEquals(OctReports, 
                 E1.dailyMaxForMonth(threeDates, 10));
  }

  @Test
  public void TestEQ_empty() { 
    assertEquals(noData, 
                 E1.dailyMaxForMonth(noData, 10));
  }
  
  @Test
  public void TestEQ_NegInputs() { 
    assertEquals(negValuesAnswers, 
                 E1.dailyMaxForMonth(negValues, 8));
  }


}
