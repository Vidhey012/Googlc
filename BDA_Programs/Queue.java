/*Algorithm 
 
Step 1: Create an array of size MAX and two integer variables that maintains the rear end and front end of the queue. Initialize front and rear to -1. 
Step 2: Enqueue operation: 
If there is space available in the queue,increment rear and insert the element at the index pointed by the rear of the queue, else print an error message. 
Step 3: Pop operation: 
 	If there are any elements present in the queue, increment front and remove the element pointed by the front of the queue, else print an error message. 
 
Source Code */

import java.util.Scanner;

public class Queue {

  int arr[];
  int front;
  int rear;
  int max;

  Queue() {
    max = 10;
    front = rear = -1;
    arr = new int[max];
  }

  public void enqueue(int element) {
    if (rear == max - 1) {
      System.out.println("Queue is full");
      return;
    }
    rear++;
    arr[rear] = element;
  }

  public void dequeue() {
    if (front == rear) {
      System.out.println("Queue is empty");
      return;
    }
    front++;
    System.out.println("Dequeued: " + arr[front]);
  }

  public void print() {
    for (int i = front + 1; i <= rear; i++) {
      System.out.print(arr[i] + " ");

    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Queue q = new Queue();
    System.out.println("1. Enqueue\n2. Dequeue\n3. Print\n4. Exit");
    while (true) {
      System.out.print("Enter option: ");
      int option = scan.nextInt();
      if (option == 1) {
        System.out.print("Enter element: ");
        int element = scan.nextInt();
        q.enqueue(element);
      } else if (option == 2) {
        q.dequeue();
      } else if (option == 3) {
        q.print();
      } else break;
    }
  }
}