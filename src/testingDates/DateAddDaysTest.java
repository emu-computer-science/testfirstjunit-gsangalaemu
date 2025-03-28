package testingDates;
// Step 2 said to use the same name as the package in Date.java,
// which is "buildToTestLab", however step 3 says to name the
// package "testingDates". I wasn't sure which I was supposed to
// use, so I followed step 3
// Step 7 hash: fefdb00

import org.junit.*;
import static org.junit.Assert.*;

public class DateAddDaysTest {
	
	// Test adding one day in the same month
	
	@Test
	public void testDaySameMonthJan() {
		Date sameMonthJan = new Date(1, 3, 2019);
		Date sameMonthJanExpectedNew = new Date(1, 4, 2019);
		sameMonthJan.addOneDay();
		assertTrue(sameMonthJan.equals(sameMonthJanExpectedNew));		
	};
	
	@Test
	public void testDaySameMonthFeb() {
		Date sameMonthFeb = new Date(2, 20, 2024);
		Date sameMonthFebExpectedNew = new Date(2, 21, 2024);
		sameMonthFeb.addOneDay();
		assertTrue(sameMonthFeb.equals(sameMonthFebExpectedNew));		
	};
	
	@Test
	public void testDaySameMonthOct() {
		Date sameMonthOct = new Date(10, 30, 2025);
		Date sameMonthOctExpectedNew = new Date(10, 31, 2025);
		sameMonthOct.addOneDay();
		assertTrue(sameMonthOct.equals(sameMonthOctExpectedNew));		
	};
	
	// Test adding one day crossing a month boundary
	
	@Test
	public void testDayAcrossMonthAprilMay() {
		Date acrossAprilMay = new Date(4, 30, 2025);
		Date acrossAprilMayExpectedNew = new Date(5, 1, 2025);
		acrossAprilMay.addOneDay();
		assertTrue(acrossAprilMay.equals(acrossAprilMayExpectedNew));		
	};
	
	@Test
	public void testDayAcrossMonthOctNov() {
		Date acrossMonthOctNov = new Date(10, 31, 2025);
		Date acrossMonthOctNovExpectedNew = new Date(11, 1, 2025);
		acrossMonthOctNov.addOneDay();
		assertTrue(acrossMonthOctNov.equals(acrossMonthOctNovExpectedNew));		
	};
	
	// Test adding one day crossing a year boundary
	
	@Test
	public void testDayAcrossYear() {
		Date acrossMonthYear = new Date(12, 31, 2025);
		Date acrossMonthYearExpectedNew = new Date(1, 1, 2026);
		acrossMonthYear.addOneDay();
		assertTrue(acrossMonthYear.equals(acrossMonthYearExpectedNew));		
	};	
}
