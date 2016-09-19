// A complete working Java program to delete a node in a linked list
// at a given position
class LinkedList
{
    Node head;  // head of list
 
    /* Linked list Node*/
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /* Given a reference (pointer to pointer) to the head of a list
       and a position, deletes the node at the given position */
    void deleteNode(int position)
    {
        // If linked list is empty
        if (head == null)
            return;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
 
        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;  // Unlink the deleted node from list
    } 
 /*
	public static void merge(LinkedList ll2){
		LinkedList result=null;
		LinkedList temp=null;
		
		if(ll2==null || ll2.head==null){
			return;
		}
		
		//check that provided LinkedLists to merge are 
		if(head==null){
			Node temp = head;
			while(temp!=null){
				this.push(temp.data);
			}
		}else {
			
			
		}
		
		
		if(temp!=null){
			result= new LinkedList();
			Node tempNode=temp.head;
			while(tempNode!=null){
				result.push(tempNode.data);
				tempNode=tempNode.next;
			}
		}else{
			result=new LinkedList();
			merge(result,ll1.head, ll2.head);
		}		
		return result;
	}
*/
	public static LinkedList merge(LinkedList ll1, LinkedList ll2){
		LinkedList result=null;
		LinkedList temp=null;
		
		//check that provided LinkedLists to merge are 
		if(ll1==null || ll1.head==null){
			temp=ll2;
		}else if(ll2==null || ll2.head==null){
			temp=ll1;			
		}
		
		if(temp!=null){
			result= new LinkedList();
			Node tempNode=temp.head;
			while(tempNode!=null){
				result.push(tempNode.data);
				tempNode=tempNode.next;
			}
		}else{
			result=new LinkedList();
			merge(result,ll1.head, ll2.head);
		}		
		return result;
	}

	
	private static void merge(LinkedList mergedLinkedList, Node l1Node, Node l2Node){
		if(l1Node==null || l2Node==null){
			Node temp = l1Node==null?l2Node:l1Node;
			while(temp!=null){
				mergedLinkedList.push(temp.data);
				temp=temp.next;
			}
		}else{
			if(l1Node.data<=l2Node.data){
				mergedLinkedList.push(l1Node.data);
				merge(mergedLinkedList, l1Node.next,l2Node);
			}else{
				mergedLinkedList.push(l2Node.data);
				merge(mergedLinkedList, l1Node,l2Node.next);
			}
		}
	}
	
    /* This function prints contents of linked list starting from
        the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
            System.out.println("");
		
    }
	
	public void sort(){
		//TODO:
		
	}
 
    /* Drier program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        llist.push(5);
        llist.push(3);
        llist.push(1);

        LinkedList llist2 = new LinkedList();
        llist2.push(6);
        llist2.push(4);
        llist2.push(2);
 
        System.out.println("\n Created Linked list is: ");
        llist.printList();

        System.out.println("\n 2 Created Linked list is: ");
        llist2.printList();

        System.out.println("\nMerged Linked list is: ");
        merge(llist,llist2).printList();
 
        /*llist.deleteNode(0);   
        System.out.println("\nLinked List after Deletion at position 4: ");
        llist.printList();

		llist.swapNode(7,8);
        System.out.println("\nLinked list after swap(1,2) is: ");
        llist.printList();*/
    }
}