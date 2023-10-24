package prog01_aorderedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
/*
*This class is the main program. It reads a file and creates a list of cars that is then writen into an output file and also
*output into the console.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/

class Prog01_aOrderedList {
/*The code firsts asks for a file location. If the location doesn't exists then it asks
*the user to input a different file location or terminate the program.
*    
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/   
        public Scanner GetInputFile (String UserPrompt) throws FileNotFoundException{
        try{//The code first prompts the user for a file location.
        Scanner in = new Scanner(System.in);//Creates an input scanner for the user input.
        System.out.print("Enter input filename:");//Prompts user for input.
        UserPrompt = in.nextLine();
        return new Scanner(new File(UserPrompt));//Attempts to return an instance of an input file so it can be read.
        }    
        catch(Exception e){//Handles exception by prompting the user for different actions.
            Scanner userInput = new Scanner(System.in);
                while(true){//Loops until valid input is input by the user.
                System.out.println("The file specified <" + UserPrompt + "> does not exist. Would you like to continue? <Y/N>");//Prompts user to continue.
                String userConfirmation = userInput.nextLine();    
                switch (userConfirmation) {
                    case "Y":
                        return GetInputFile("");//If the user chooses yes then the method calls itself so it can start over.
                    case "N":
                        throw new FileNotFoundException();//If not a FileNotFoundException is called.
                    default:
                        System.out.println("Invalid input.");//If anything else is chosen then the program lets the user know that the input is invalid
                        break;                                 //and then the program loops back to the "file does not exist" prompt. 
                }
                }
    }
        }
/*    
*Prompts the user for an output file. If it is invalid then it prompts the user to continue or terminate the program.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/           
    public PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException{
        try{//Attempts for the user to provide an outputfile.
            Scanner in = new Scanner(System.in);
            System.out.print("Enter output file:");//Prompts user for output file.
            UserPrompt = in.nextLine();
            return new PrintWriter(UserPrompt);
        }
        catch(Exception e){//If the output file is invalid.(Write protected folder)
            Scanner userInput = new Scanner(System.in);
                while(true){//Loops until valid input.
                System.out.println("The file specified <" + UserPrompt + "> is invalid. Would you like to continue? <Y/N>");//Prompts user to continue
                String userConfirmation = userInput.nextLine();    
                switch (userConfirmation) {
                    case "Y":
                        return GetOutputFile("");//If yes then function calls itself.
                    case "N":
                        throw new FileNotFoundException();//If no then a FileNotFoundException is produced.
                    default:
                        System.out.println("Invalid input.");//If the user inputs invalid input then the prompt loops until otherwise.
                        break;
                }
                }            
        }
    }
/*    
*Reads the input file and adds cars to an ordered list.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/   
    public void readFile(Scanner inputFile, aOrderedList carList){
        String carMake = ""; //carMake variable to be passed into the car constructor
        int carYear; //carYear to be passed into the car constructor.
        int carPrice;//carPrice to be passed into the car constructor
        String strCarPrice = ""; //String representation of price to be converted to int.
        String strCarYear = ""; //String representation of year to be converted to int.
        
        while(inputFile.hasNextLine()){//Reads until it reaches the end of the file.
           String currentLine = inputFile.nextLine();//Turns the current line read into a string so the data can be read.
           int commaNum = 0; //The comma number of commas read is used to determine which variable to save the data in.
           
           if(currentLine.charAt(0) == 'A'){//Start of add statement
           for(int i = 0; i < currentLine.length(); i++){//start of for loop that adds a car
               if (currentLine.charAt(i) == ','){//Checks if the index is on a comma.
                   commaNum++;//Increases the number of commas read
                   i++;//Skips over the comma so the data can be read.
               }
               
               switch (commaNum){
                   case 1:
                        carMake += currentLine.charAt(i);//If we passed 1 comma then we store the data in make.
                       break;
                   case 2:
                        strCarYear += currentLine.charAt(i);//If we pass 2 commas then we save it in the string representing the year.
                       break;
                   case 3:
                        strCarPrice += currentLine.charAt(i);//If we pass 3 commas then we save it in the string representing the price.
                       break;
               }
           }
            carPrice = Integer.parseInt(strCarPrice); //Turns the string representation of the price into an integer to be stored into carPrice
            carYear = Integer.parseInt(strCarYear); //Turns the string representation of the year into an integer to be stored into carYear
            carList.add(new Car(carMake, carYear, carPrice)); //Adds a car into the carlist
            carMake = ""; //Resets all the vairables
            strCarPrice = "";//for the next line to be read
            strCarYear = "";
           }else if(currentLine.charAt(0) == 'D'){//If the first index is 'D' then we delete.
               for(int i = 0; i < currentLine.length(); i++){
                if(currentLine.charAt(i) == ','){//Checks that the comma is on an index.
                    commaNum++;//Increases comma number.
                    i++;//Skips over comma so that data can be read properly.
                }
                switch(commaNum){
                    case 1:
                        carMake += currentLine.charAt(i);//If index passes 1 comma then the data gets read to carMake.
                        break;
                    case 2:
                        strCarYear += currentLine.charAt(i);//If index passes 2 commas then the data gets read to the String representation of car year.
                        break;
                }
               }
               carYear = Integer.parseInt(strCarYear);//The string is converted to an int to be stored into car year.
               for(int i = 0; i < carList.size(); i++){//Checks the entire list.
                   if((carMake.equals(((Car)carList.get(i)).getMake()) && (carYear == ((Car)carList.get(i)).getYear()))){//Checks if the years and makes match with any
                       carList.remove(i);//Removes index                                                                             //of the data in the file.
                   }
               }
           }
           carMake = "";//Resets all of the variables
           strCarYear = "";
           commaNum = 0;
        
    }
        inputFile.close();
    }
/*    
*Main program which prompts user for both the input file to be read and output file and then prints output.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/       
    public static void main(String[] args) throws FileNotFoundException {
        Prog01_aOrderedList mainProgram = new Prog01_aOrderedList();//Main program created so input and outputfiles can be read.
        aOrderedList carOList = new aOrderedList();//Car List.
        Scanner in = mainProgram.GetInputFile("");//Creates input file to be read.
        PrintWriter outFile = mainProgram.GetOutputFile("");//Creates out file to be written to.
        mainProgram.readFile(in, carOList);//Reads the file and creates a list of cars.
        System.out.println("Number of cars: " + carOList.size());//Prints the number of cars.
        for(int i = 0; i < carOList.size(); i++){//Goes through the entire list to print the car information to the console.
            System.out.println();
            System.out.println("Make:        " + ((Car)carOList.get(i)).getMake());
            System.out.println("Year:        " + ((Car)carOList.get(i)).getYear()); 
            System.out.printf("Price:       $%,d\n",((Car)carOList.get(i)).getPrice());
            
            outFile.println("Number of cars: " + carOList.size());//Prints the car information to the outfile.
            outFile.println();
            outFile.println("Make:        " + ((Car)carOList.get(i)).getMake());
            outFile.println("Year:        " + ((Car)carOList.get(i)).getYear()); 
            outFile.printf("Price:       $%,d\n",((Car)carOList.get(i)).getPrice());
            outFile.println();
        }
        outFile.close();
        
    }
}
