package testingDates;
import org.junit.*;
import static org.junit.Assert.*;

public class DateSetDateTest {

	// Test for legal values, changes to the Date should occur
	
	@Test
	public void testLegalValueJan() {
		Date legalValueJan = new Date(1, 3, 2019);
		Date dateLegalValueTest = new Date();
		dateLegalValueTest.setDate("January", 3, 2019);
		assertTrue(legalValueJan.equals(dateLegalValueTest));	
	}
	
	@Test
	public void testLegalValueMar() {
		Date legalValueMar = new Date(3, 15, 2024);
		Date dateLegalValueTest = new Date();
		dateLegalValueTest.setDate("March", 15, 2024);
		assertTrue(legalValueMar.equals(dateLegalValueTest));	
	}
	
	@Test
	public void testLegalValueJun() {
		Date legalValueJun = new Date(6, 20, 2435);
		Date dateLegalValueTest = new Date();
		dateLegalValueTest.setDate("June", 20, 2435);
		assertTrue(legalValueJun.equals(dateLegalValueTest));	
	}
		
	// Test for illegal values, changes to the Date should not occur
	
	@Test
	public void testIllegalValueJan() {
		Date illegalValueJan = new Date(1, 32, 2025);
		Date dateIllegalValueTest = new Date();
		dateIllegalValueTest.setDate("January", 32, 2025);
		// Check to see if the date was changed to our test value
		// Assert false, as expected behaviour is the date was not
		// changed and the values are not equal
		assertFalse(illegalValueJan.equals(dateIllegalValueTest));	
	}
	
	@Test
	public void testIllegalValueFeb() {
		Date illegalValueFeb = new Date(2, 30, 2026);
		Date dateIllegalValueTest = new Date();
		dateIllegalValueTest.setDate("February", 30, 2026);
		// Check to see if the date was changed to our test value
		// Assert false, as expected behaviour is the date was notJanuary
		// changed and the values are not equal
		assertFalse(illegalValueFeb.equals(dateIllegalValueTest));	
	}
	
	@Test
	public void testIllegalValueApr() {
		Date illegalValueApr = new Date(4, 31, 2492);
		Date dateIllegalValueTest = new Date();
		dateIllegalValueTest.setDate("April", 31, 2492);
		// Check to see if the date was changed to our test value
		// Assert false, as expected behaviour is the date was not
		// changed and the values are not equal
		assertFalse(illegalValueApr.equals(dateIllegalValueTest));	
	}
	
}
