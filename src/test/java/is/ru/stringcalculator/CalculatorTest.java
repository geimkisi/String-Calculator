package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	public void testMultipleNumbers(){
	 	assertEquals(6, Calculator.add("1,2,3"));
	 }

	@Test
	public void testWithNewLines(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testWithMultibleNewLines(){
		assertEquals(6, Calculator.add("1\n2\n3"));
	}

	@Test
	public void testWithDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test // Test with a delimeter, newline and ","
	public void testDelimiterLinesNumbers(){
		assertEquals(9, Calculator.add("//;\n1;2\n3,3"));
	}

	@Test //(expected = NegativesNotAllowed.class) 
	public void negativeNotAllowed(){

		NegativesNotAllowed caughtException = null;

		try {
			Calculator.add("-1,2");
		}
		catch (NegativesNotAllowed e){
			caughtException = e;
		}
		assertEquals(caughtException.getMessage(), "Negatives not allowed: -1");
	}

	@Test
	public void MultibleNegativesNotAllowed(){

		NegativesNotAllowed caughtException = null;

		try {
			Calculator.add("2,-4,3,-5");
		}
		catch (NegativesNotAllowed e){
			caughtException = e;
		}
		assertEquals(caughtException.getMessage(), "Negatives not allowed: -4,-5");
	}
	
}








