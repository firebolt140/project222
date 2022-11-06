//Christian Flores
//CDF200003

public class Node<T> implements Comparable<T> {
    //Declaring variables for nodes
    T data;
    Node<T> next;

    //Node constructor
    public Node(T dataGiven) {
        data = dataGiven; //When node is created set its data variable to the data passed in during creation
    }

    @Override
    public int compareTo(T tempData) {
        //Set the value of the data to a string
        String holdString1 = String.valueOf(data);

        //Initialize variables
        int index = 0;
        boolean found = false;

        //For the length of the string check if the value equals a "tab" and if it does then set
        //the value of index to the iteration it stopped at
        for(int i = 0; i < holdString1.length() && !found; i++){
            if(holdString1.charAt(i) == '\t'){
                index = i;
                found = true; //Found character stop searching
            }
        }
        //Set the value of the string to only have the string from 0 to where the tab was found
        holdString1 = holdString1.substring(0, index);

        //Set the value of the temporary data to a string
        String holdString2 = String.valueOf(tempData);

        //Reseting variables
        index = 0;
        found = false;
        //For the length of the string check if the value equals a "tab" and if it does then set
        //the value of index to the iteration it stopped at
        for(int i = 0; i < holdString2.length()-1 && !found; i++){
            if(holdString2.charAt(i) == '\t'){
                index = i;
                found = true; //Found character stop searching
            }
        }
        //Set the value of the string to only have the string from 0 to where the tab was found
        holdString2 = holdString2.substring(0, index);

        return holdString1.compareTo(holdString2); //Return the value of the comparison between the first string and the second string
    }
}
