/*Algorithm 
 
Step 1: Create a class, “Node” which contains the data element to be stored and a pointer to the next node. Step 2: Insert operation: 
1.	If there are no elements in the linked list, create a new node and make it a head node. 
2.	Else traverse to the end of the list, create a new node and add it to the end of the list. 
Step 3: Remove operation: 
1.	If there are no elements in the list, print the error message. 
2.	Else search for the required element in the list. Let the node be x. Make the previous node of x to point to the next node of x. 
Step 4: Print operation: 
1.	Traverse through the list and print every element. 
2.	If the list is empty, print an error message. 
 
 
Source Code */

import java.util.Scanner;

class Node {
  int data;
  Node next;
  Node(int d) {
    data = d;
    next = null;
  }
}

public class LinkedList {

  Node head;

  LinkedList() {
    head = null;
  }

  public void insert(int element) {
    Node temp = head;
    if (head == null) {
      head = new Node(element);
      return;
    }
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new Node(element);
  }

  public void remove(int element) {
    Node temp = head;
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    if (head.data == element) {
      head = head.next;
      return;
    }
    while (temp.next != null) {
      if (temp.next.data == element) {
        temp.next = temp.next.next;
        break;
      }
      temp = temp.next;
    }
  }

  public void print() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList l = new LinkedList();
    System.out.println("1. Insert\n2. Remove\n3. Print\n4. Exit");
    while (true) {
      System.out.print("Option: ");
      int option = scanner.nextInt();
      if (option == 1) {
        System.out.print("Enter element: ");
        int element = scanner.nextInt();
        l.insert(element);
      } else if (option == 2) {
        System.out.print("Enter element: ");
        int element = scanner.nextInt();
        l.remove(element);
      } else if (option == 3) {
        l.print();
      } else {
        break;
      }
    }
  }

}