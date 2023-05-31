package singlylinkedlist;

public class DeletionLinkedList {

    //Head of the list
    Node head;

    DeletionLinkedList() {
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

    //Insert a new Node
    public void insert(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    //Print linkedList
    public void display() {

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    //Delete from beginning
    public void deleteBeginning() {

        Node currentNode = head;
        head = currentNode.next;
//        currentNode = null;

    }

    //Delete from end
    public void deleteEnd() {

        Node end = head;
        Node prev = head;

        while (end.next != null) {
            prev = end;
            end = end.next;
        }

        prev.next = null;
        end = null;
    }
    
    //delete from middle
    public void deleteMiddle(int key){
        
        Node current = head;
        Node prev = head;
        
        if(head == null || head.next == null){
            System.out.println("Empty or single element list");
        }
        
        while(current.next != null){
            prev = current;
            current = current.next;
            
            if(current.data == key){
                prev.next = current.next;
            }
        }
        
    }

    public static void main(String[] args) {

        DeletionLinkedList list = new DeletionLinkedList();

        list.insert(4);
        list.insert(3);
        list.insert(0);
        list.insert(2);
        list.insert(12);
        list.insert(45);

        list.display();

        //Delete from beginning
        System.out.println("\nDelete front");
        list.deleteBeginning();
        list.display();

        //Delete from end
        System.out.println("\nDelete end");
        list.deleteEnd();
        list.display();
        
        //Delete from middle
        System.out.println("\nDelete middle");
        list.deleteMiddle(0);
        list.display();

    }

}
