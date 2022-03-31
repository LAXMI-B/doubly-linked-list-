// Class for Doubly Linked List
public class DLL {
    Node head;
	
 
    /* Doubly Linked list Node*/
    class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) { data = d; }
    }
 
    //Add node first
    public void push(int new_data)
    {
        
        Node Node1 = new Node(new_data);
 
       
        Node1.next = head;
        Node1.prev = null;
 
        if (head != null)
            head.prev = Node1;
 
        
        head = Node1;
    }
   
    // Add a node before the given node
    public void InsertBefore(Node next_node, int new_data)
    {
       
        if(next_node == null)
        {
            System.out.println("The given next node can not be NULL");
            return;
        }
         
        Node new_node = new Node(new_data);
         
        
        new_node.prev = next_node.prev;
         
        
        next_node.prev = new_node;
         
        
        new_node.next = next_node;
        
        if(new_node.prev != null)
            new_node.prev.next = new_node;
        else
            head = new_node;
    }
 

    public void InsertAfter(Node prev_Node, int new_data)
    {
 
       
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }
 
        Node new_node = new Node(new_data);
        new_node.next = prev_Node.next;
        prev_Node.next = new_node;
        new_node.prev = prev_Node;
 
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }
 
   //Add node last
    void append(int new_data)
    {
        Node last_node = new Node(new_data);
 
        Node last = head; 
 
        last_node.next = null;
 
        if (head == null) {
            last_node.prev = null;
            head = last_node;
            return;
        }
 
        while (last.next != null)
            last = last.next;
 
        
        last.next = last_node;
 
        
        last_node.prev = last;
    }
 
    // This function prints contents of
    // linked list starting from the given node
    public void printlist(Node node)
    {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();

    }
 
    void deleteNode(Node del)
    {
 
        if (head == null || del == null) {
            return;
        }
        
        if (head == del) {
            head = del.next;
        }
 
        if (del.next != null) {
            del.next.prev = del.prev;
        }
 
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        return;
    }
   
    public void position(int value) {  
        int i = 1;  
        boolean flag = false;  
        
        Node current = head;  
          
        
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
             
            if(current.data == value) {  
                flag = true;  
                break;  
            }  
            current = current.next;  
            i++;  
        }  
        if(flag)  
             System.out.println("Node is present in the list at the position : " + i);  
        else  
             System.out.println("Node is not present in the list");  
    }  
      
    public static void main(String[] args)
    {
        DLL dll = new DLL();
         
       
        dll.append(6);
        dll.push(7);
        dll.push(1);
        dll.append(4);
        dll.InsertAfter(dll.head.next, 8);
        dll.InsertBefore(dll.head.next.next, 5);
 
        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);
        
     // Deleting first node
        dll.deleteNode(dll.head);
        System.out.print("\nList after deleting first node: ");
        dll.printlist(dll.head);
        //deleting index node
        dll.deleteNode(dll.head.next);
        System.out.print("\nList after Deleting middle node: ");
        dll.printlist(dll.head);
        //deleting last node	
        dll.deleteNode(dll.head.next.next.next);
        System.out.print("\nList after deleting last node: ");
        dll.printlist(dll.head);
        
        //Find a node in O (1)
        dll.position(7);
        }
}
 
