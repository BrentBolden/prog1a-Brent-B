package prog01_aorderedlist;

/**
*This class creates a car object that contains information for the make, year and price of the
* car.
*
* CSC 1351 Programming Project No 1a
7
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
 * @author Brent
 */

public class Car implements Comparable<Car>{
    private String make; //Represetns car make
    private int year; //Represents car year.
    private int price;//Represents the car price.

   
    
/*
*This method instantiates the make, year, and price.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/
    public Car(String Make, int Year, int Price){
        make = Make;//instantiates the variables
        year = Year;
        price = Price;
    }
/*
*These methods return the make, year, and price.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/
    public String getMake(){
        return make;//Returns make to be used outside of class.
    }
    public int getYear(){
        return year;//Returns year to be used outside of the class.
    }
    public int getPrice(){
        return price;//Returns the price to be used outside of the class.
    }
    
/*
*This compares the Cars based on make first and then the year.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/    
    @Override
    public int compareTo(Car other){
        if (make.compareTo(other.make) == -1){//Checks if car 1 is less than car2.
            return -1;//If so then car1 is less than car 2.
        }
        else if (make.compareTo(other.make) == 0 && Integer.compare(year, other.year) == -1)//Checks if both makes are equal and then checks if car1's
        {                                                                                                  //year is less than car2's year 
            return -1;//If so then car1 is less than car 2.
        }
        else
            return 1;//In any other situation(car1.make > car2.make or (car1.make == car2.make and car1.year > car2.year) car1 is greater.
    }
    
/*
*Returns the make, year and price of the car. 
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/    
    
    public String toString(){
        return "Make: " + make + ", Year: " + year + ", Price: " + price +";";//Returns model information.
    }
}
