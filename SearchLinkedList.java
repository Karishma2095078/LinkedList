package singlylinkedlist;

public class SearchLinkedList {
    
    //Head of the list
    Node head;

    SearchLinkedList() {
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
    
    //To get length of the Linked List
    public int getLength(){
        int length = 0; 
        Node currentNode = head;
        
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }
    
    //find node in a Linked List
    public void searchNode(int index){
        
        Node currentNode = head;
        int count = 0;
        int length = getLength() - 1;
        
        if(index < 0 || index > length){
            System.out.println("Index not found");
        }
        
        while(currentNode != null){
            if(count == index){
                System.out.println("Element at index " + count + " is " + currentNode.data);
            }
            currentNode = currentNode.next;
            count++;
        }        
    }

    //find node using recursion
    public int recursionSearch(Node head, int index){
        
        int count = 0; 
        
        if(head == null){
            return -1;            
        }
        
        if(count == index){
            return head.data;
        }
                
        return recursionSearch(head.next, index-1);
    }

    public static void main(String[] args) {
        
        SearchLinkedList list = new SearchLinkedList();

        list.insert(4);
        list.insert(3);
        list.insert(0);
        list.insert(2);
        list.insert(12);
        list.insert(45);

        list.display();
        
        list.searchNode(1);
        System.out.println(list.recursionSearch(list.head, 1));
        
    }
    
}
