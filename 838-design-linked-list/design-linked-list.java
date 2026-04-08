class MyLinkedList {
    // Define the Node structure
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    /** Initializes the MyLinkedList object. */
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    /** Get the value of the index-th node. If invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /** Append a node of value val as the last element. */
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }
    
    /** Add a node of value val before the index-th node. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        
        Node newNode = new Node(val);
        Node curr = head;
        // Traverse to the node JUST BEFORE the target index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }
}