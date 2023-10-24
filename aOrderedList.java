package prog01_aorderedlist;

import java.util.Arrays;

/*
*This class creates a list of cars that can be added and deleted. It also increases based on the amount of elements needed. 
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/

public class aOrderedList{
    private final int SIZEINCREMENTS = 20; //Size of the increments for increasing ordered list.
    private Comparable[] oList; //The ordered list.
    private int listSize; //The size of the ordered list.
    private int numObjects; //The number of objects in the ordered list.
    private int curr; //Index of current element accessed via iterator methods.
                 
    
/*
*Instatiates the number of objects, listSize, and the oList
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/    
    
    public aOrderedList(){
        numObjects = 0;//Instantiates the number of objects.
        listSize = SIZEINCREMENTS;//Sets the initial list size.
        oList = new Comparable[SIZEINCREMENTS];//Sets the list the the initial size.
    }

    
/*    
*Adds a car to the list
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/           
    public void add(Comparable newObject){
        if((numObjects + 1) >= oList.length){//Checks if the number of objects will exceed the list's limit.
            Comparable[] newValues = Arrays.copyOf(oList, SIZEINCREMENTS + oList.length);//Creates new array that is a copy of the last array plus an increased size based on the size increments.
            oList = newValues;//Changes reference to the new array.
            listSize = oList.length;//Updates the listSize.
        }
        oList[numObjects] = newObject;//Adds new object based on the number of elements.
        numObjects++;//Increases the number of objects counter by one.
    }
/*    
*Returns the size of the elements.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/       
    int size(){
        return numObjects;//Returns an int based on number of objects.
    }
    
/*    
*Returns a variable at the specified index.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/   
    
    Comparable get(int index){
        return oList[index];//Returns the object in the list on the specific index.
    }
    
/*    
*Checks if the list is empty.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/       
    
    boolean isEmpty(){//Checks if list is empty.
        for(int i = 0; i < listSize; i++){//Goes through the entire list.
            if (oList[i] != null)//Checks if list is null.
                return false;//If it finds at least one element then it returns false.
        }
        return true;//If it cannot find an element then it returns the list as empty.
    }
    
/*    
*Removes a an element at the specified index.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/   
    
    
    void remove(int index){//
        for(int i = index + 1;i <= numObjects; i++){//Gets the index after the one that the user wants to delete.
            oList[i-1] = oList[i];//It replaces the current element with the previous one until it gets to the end of the list.
        }
        numObjects--;//Decreases the number of objects counter by one.
    }
    
/*Resets the current index    
*Adds a car to the list
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/   
    
    
    void reset(){
        curr = 0;//Resets the current index.
    }
    
/*    
*Increases current index by one.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/       
    
    Comparable next(){
        curr++; //Increases current index by one.
        return oList[curr];//Returns the next element in iteration.
    }
    
/*    
*Checks if there is another value after the current index.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/       
    
    boolean hasNext(){
        if ((curr + 1) < listSize)//Checks if the next index value is under the listSize.
            return true;//If so then the list has a next value.
        return false;//If not then the list doesn't have anymore values.
    }
    
/*    
*Removes an object based on what next() returns. 
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/   
    void remove(){
        for(int i = curr + 1;i <= numObjects; i++){//Gets the index to delete based on what the next() returns (curr).
            oList[i-1] = oList[i];//It replaces the current element with the previous one until it gets to the end of the list.
        }
        numObjects--;//Decreases number of objects counter by one.        
    }
    
/*    
*Returns a toString of every car in the list as one string.
*
* CSC 1351 Programming Project No 1a
*
* Section 2
*
* @author Brent Bolden
* @since 10/23/2023
*/   
    
    @Override
    public String toString(){
        String listToString = ""; //the toStrings of every car method in the list is added here
                                  //so it can returned at the end of the method.
        
        for(int i = 0; i < numObjects; i++){
            if (oList[i] != null)//Makes sure that the current index is not null.
                listToString += "[" + oList[i].toString() + "]"; //Adds the toString of the current object to the toString of the list.
        }
        return listToString;
    }
}
