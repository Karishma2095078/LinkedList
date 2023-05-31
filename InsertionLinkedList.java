package singlylinkedlist;

//Java program to implement 
//a Singly Linked List
public class InsertionLinkedList {

    //Head of the list
    Node head;

    InsertionLinkedList() {
        head = null;
    }

    //LinkedList Node class
    //This inner class is made static
    //so that main() can access it
    static class Node {

        int data;
        Node next;  //pointer to next node

        //Constructor to create a new Node
        //next is by deafult initialize to null
        Node(int d) {
            data = d;
            next = null;
        }
    }

    //method to print values of LinkedList
    public void display() {

        Node currentNode = head;

        if (currentNode == null) {
            System.out.println("Empty LinkedList");
        }

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

        System.out.println();

    }

    //************************* INSERTION ***************************//
    //Method to add node at the front
    public void insertFront(int data) {

        // 1 & 2: Allocate the Node & Put in the data
        Node newNode = new Node(data);

        // 3. Make next of new Node as head 
        newNode.next = head;

        // 4. Move the head to point to new Node 
        head = newNode;
    }

    //Method to add node after given node
    public void insertAfter(int key, int data) {

        Node newNode = new Node(data);
        Node currentNode = head;

        while (currentNode != null) {

            if (currentNode.data == key) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
            currentNode = currentNode.next;
        }
    }

    //Method to add node at the end
    public void insertEnd(int data) {

        Node newNode = new Node(data);
        Node currentNode = head;

        //If the Linked List is empty, then make the
        //  new node as head
        if(head == null){
            head = newNode;
        }
        
        while (currentNode != null) {

            if (currentNode.next == null) {
                currentNode.next = newNode;
                newNode.next = null;
            }

            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {

        InsertionLinkedList list = new InsertionLinkedList();

        //add valus to the LinkedList
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        list.head.next = second;
        second.next = third;

        //print Linked List
        list.display();

        System.out.println("\nAdd node at the front");
        list.insertFront(5);
        list.insertFront(6);
        list.display();

        System.out.println("\nAdd node after a given node");
        list.insertAfter(5, 0);
        list.display();

        System.out.println("\nAdd node at the end");
        list.insertEnd(4);
        list.insertEnd(5);
        list.display();

    }

}
