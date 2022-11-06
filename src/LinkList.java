//Christian Flores
//CDF200003

import java.util.ArrayList;

public class LinkList<T> {
    Node<T> head; //Create a head of linked list object


    public ArrayList<T> convertToArray(Node<T> temp){
        //Create a new generic array list
        ArrayList<T> dataList = new ArrayList<T>();

        //While the data of the node does not equal null
        if(temp.data != null){
            dataList.add(temp.data); //Add the data of the node to the array list
            while (temp.next != null) { //While the next node is not equal to null
                temp = temp.next; //Set the temporary node to the next node in the list
                dataList.add(temp.data); //Add the data of the node to the array list
            }
        }

        return dataList; //Return the array list

    }

    public Node<T> insert(LinkList<T> list, T data){
        Node<T> newNode = new Node<T>(data); //Create a new node with the new data variable

        //If the list is empty set the head of the list to the new node
        if(list.head == null){
            list.head = newNode;
        }
        else{
            Node<T> temp = list.head; //Set a temporary node to the head of the list
            while(temp.next != null){ //While next node in the list is not null
                temp = temp.next; //Set the temporary node to the next node in the list
            }
            temp.next = newNode; //The last node in the list to the new node
        }
        return newNode; //Return the new node
    }

    public void recursivePrint(Node<T> temp){
        if(temp.next != null){ //If not at the end of the list
            recursivePrint(temp.next); //Call the function again and pass in the next node
        }
        System.out.println(temp.data); //Print the data in the node
    }
    public void sortList(Node<T> temp){
        Node<T> tempNext; //Declare a generic node to store the next node in list
        T holdData; //Declare a generic object with type T to hold data of the nodes

        //While the node is not equal to null
        for(; temp != null; temp = temp.next){
            tempNext = temp.next; //Make the next node variable equal to the next node
            for(; tempNext != null; tempNext = tempNext.next){ //While the node is not equal to null
                if(temp.compareTo(tempNext.data) < 0){ //If the node is less than the next node
                    holdData = temp.data; //Hold the data of the node in a variable
                    temp.data = tempNext.data; //Make the node equal to the next node
                    tempNext.data = holdData; //Make the next nodes data equal to the variable that held the data
                }
            }
        }
    }
}
