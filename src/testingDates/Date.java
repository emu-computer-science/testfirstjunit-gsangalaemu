package testingDates;

import java.util.Scanner;

public class Date
{
    private String month;
    private int day;
    private int year; //a four digit number.

    public Date( )
    {
        this("January", 1, 1000);  // Could have used setDate instead
    }

    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    public Date(int year)
    {
        month = "January";
        day = 1;
        this.year = year;
    }

    public Date(Date aDate)
    {
        if (aDate == null)//Not a real date.
        {
             System.out.println("Fatal Error in Date(Date).");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    public void setDate(int monthInt, int day, int year)
    {    	
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error in setDate(int, int, int)");
            System.exit(0);
        }
    }

    public Object setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
            return this;
        }
        else
        {            
            return null;          
        }
    }

    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error in setYear(int)");
            System.exit(0);
        }
        else
            this.year = year;
    }
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error in setMonth(int)");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error in setDay(int)");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error in getMonth");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    public int getDay( )
    {
        return day;
    }

    public int getYear( )
    {
        return year;
    }

    public String toString( )
    {
        return (month + " " + day + ", " + year);
    }

    public boolean equals(Date otherDate)
    {
        return ( (month.equals(otherDate.month))
                  && (day == otherDate.day) && (year == otherDate.year) );
    }

    public boolean precedes(Date otherDate)
    {	
    	return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
              System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt)    
    {
    	
    	// Arrays to hold the integer value of months
    	// with 30 and 31 days
        String monthsWith30Days[] = {"April", "June", "September", "November"};
        String monthsWith31Days[] = {"January", "March", "May", "July", "August", "October", "December"};

        // Check if the month string name is valid
        if (!monthOK(monthString)) {
        	return false;
        }
        
        // Check if the day is in the range of 1-31
        if (dayInt < 1 || dayInt > 31) {
        	return false;
        }
        
     // Check if valid day for months with 30 days
        for (String s : monthsWith30Days) {
        	if (s.equals(monthString) && dayInt > 30) {
        		return false;
        	}
        }
        
        // Check if valid day for months with 31 days
        for (String s : monthsWith31Days) {
        	if (s.equals(monthString) && dayInt > 31) {
        		return false;
        	}
        }
        
        // Check if valid day for February
        if (monthString.equals("February") && dayInt > 28) {
        	return false;
        }
        
        // Check if within a valid year range
        if (yearInt < 1000 || yearInt > 9999) {
        	return false;
        }
        
        return true;
    }

    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error in monthString");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }
    public static void main(String[] args) {
        System.out.println("Main in Date.");
        Date tester = new Date();
        System.out.println("tester is "+tester);
    }
    
    public Date addOneDay(){
    	
    	// Arrays to hold the integer value of months
    	// with 30 and 31 days
    	String monthsWith30Days[] = {"April", "June", "September", "November"};
        String monthsWith31Days[] = {"January", "March", "May", "July", "August", "October", "December"};

    	// Boolean value if we need to increase the month,
    	// ie: If the addOneDay method is called when it is
    	// the last day of the month
    	boolean increaseMonth = false;
    	    	
    	int currentDay = this.day;
    	String currentMonth = this.month;
    	int currentYear = this.year;  	
    	    	
    	// Check if it is the last day of a 30 day month
    	if (currentDay == 30) {
    		for (String s : monthsWith30Days) {
    			if (s.equals(currentMonth)) {
    				increaseMonth = true;
    			}
    		}
    	}
    	
    	// Check if it is the last day of a 31 day month
      	if (currentDay == 31) {
    		for (String s : monthsWith31Days) {
    			if (s.equals(currentMonth)) {
    				increaseMonth = true;
    			}
    		}
    	}
      	
      	// Check if it is the last day of February
      	if (currentDay == 28 && currentMonth.equals("February")) {
      		increaseMonth = true;
      	}
      	
      	// If we do not need to increase the month, simply
      	// increase the day
      	if (increaseMonth == false) {
      		currentDay++;
      		this.setDate(currentMonth, currentDay, currentYear);
      		
      	}
      	
      	// If it is not December and we do need to increase
      	// the month then increment to the next month and set
      	// the day value to the first day of the month
      	int currentMonthAsInt = getMonth();
      	if (increaseMonth == true && currentMonthAsInt != 12) { 
      		this.setDate(currentMonthAsInt + 1, 1, currentYear);
      	}
      	
      	// If it is December increment the year value and
      	// set the day value to the first of the month and
      	// the month value to January
      	if (increaseMonth == true && currentMonth.equals("December")) {
      		currentYear++; // Increment the year by one
      		this.setDate(1, 1, currentYear);
      	}
    	
      	// Return the modified date
    	return this;    	
    	
    	}
}
