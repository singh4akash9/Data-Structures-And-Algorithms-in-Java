import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

class NodeS {
    int val;
    NodeS next;

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(NodeS next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public NodeS getNext() {
        return next;
    }

    NodeS(int val, NodeS next) {
        this.val = val;
        this.next = next;
    }

}

class NodeD
{
    int val;
    NodeD next;
    NodeD prev;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public NodeD getNext() {
        return next;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public NodeD getPrev() {
        return prev;
    }

    public void setPrev(NodeD prev) {
        this.prev = prev;
    }

    NodeD(int val, NodeD next, NodeD prev)
    {
        this.val=val;
        this.next=next;
        this.prev=prev;
    }

}

class singlyLinkedList
{
    NodeS front=null;
    NodeS rear=null;

    public NodeS getFront() {
        return front;
    }

    public void setFront(NodeS front) {
        this.front = front;
    }

    public NodeS getRear() {
        return rear;
    }

    public void setRear(NodeS rear) {
        this.rear = rear;
    }

    singlyLinkedList(NodeS front,NodeS rear)
    {
        this.front=front;
        this.rear=rear;
    }

    void display(NodeS nodeS)
    {
        NodeS node=nodeS;
        int count=0;
        while(node!=null&&count<10)
        {
            System.out.print(node.val+" ");
            node=node.next;
            count++;
        }

        System.out.println();

    }

    void linearSearch(NodeS nodeS,int target)
    {
        NodeS node=nodeS;
        while(node!=null)
        {
            if(node.val==target)
            {
                System.out.println("Value "+target+" found");
                return;
            }
            node=node.next;
        }
        System.out.println("Value "+target+" not found");

    }

    void insertFront(int val)
    {
        NodeS node=new NodeS(val,null);
        node.next=front;
        front=node;
    }

    void insertRear(int val)
    {
        NodeS node=new NodeS(val,null);
        rear.next=node;
        rear=node;
    }

    void insertAfterK(int val,int K)
    {
        NodeS node=new NodeS(val,null);
        NodeS node2=front;
        int count=1;
        while(count<K)
        {
         node2=node2.next;
        }
        node.next=node2.next;
        node2.next=node;
    }

    void deleteFront()
    {
        front=front.next;
    }

    void deleteRear()
    {
        NodeS nptr=front;
        while(nptr.next.next!=null)
        {
            nptr=nptr.next;
        }
        rear=nptr;
        nptr.next=null;

    }

    void deleteAtK(int K)
    {
        if(K==1)
        {
            this.deleteFront();
            return;
        }
        if(K==2)
        {
            if(front.next==rear)
            {
                front.next=null;
                rear=front;
                return;
            }
            NodeS nptr=front.next;
            front.next=nptr.next;
            return;
        }
        NodeS nptr=front;
        while(K>2)
        {
            nptr=nptr.next;
            K--;
        }
        NodeS nptr2=nptr.next;
        nptr.next=nptr2.next;
        return;
    }

    boolean detectCycle()
    {
        NodeS node1=front;
        NodeS node2=front;

        while(true)
        {
            if(node1.next==null)
            {
                return false;
            }
            if(node2.next==null)
            {
                return false;
            }
            if(node2.next.next==null)
            {
                return false;
            }
            node1=node1.next;
            node2=node2.next.next;
            if(node1==node2)
            {
                return true;
            }
        }
    }

}
class doublyLinkedList
{
    NodeD front=null;
    NodeD rear=null;

    public NodeD getFront() {
        return front;
    }

    public void setFront(NodeD front) {
        this.front = front;
    }

    public NodeD getRear() {
        return rear;
    }

    public void setRear(NodeD rear) {
        this.rear = rear;
    }

    doublyLinkedList(NodeD front,NodeD rear)
    {
        this.front=front;
        this.rear=rear;
    }

    void displayForward(NodeD nodeD)
    {
        NodeD node=nodeD;
        while(node!=null)
        {
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();

    }

    void displayBackward(NodeD nodeD)
    {
        NodeD node=nodeD;
        while(node!=null)
        {
            System.out.print(node.val+" ");
            node=node.prev;
        }
        System.out.println();
    }

    void linearSearchForward(NodeD nodeD,int target)
    {
        NodeD node=nodeD;
        while(node!=null)
        {
            if(node.val==target)
            {
                System.out.println("Value "+target+" found");
                return;
            }
            node=node.next;
        }
        System.out.println("Value "+target+" not found");

    }

    void linearSearchBackward(NodeD nodeD,int target)
    {
        NodeD node=nodeD;
        while(node!=null)
        {
            if(node.val==target)
            {
                System.out.println("Value "+target+" found");
                return;
            }
            node=node.prev;
        }
        System.out.println("Value "+target+" not found");

    }

    void insertFront(int val)
    {
        NodeD node=new NodeD(val,null,null);
        node.next=front;
        front.prev=node;
        front=node;
    }

    void insertRear(int val)
    {
        NodeD node=new NodeD(val,null,null);
        rear.next=node;
        node.prev=rear;
        rear=node;
    }

    void insertAtK(int val,int K)
    {
        NodeD node=new NodeD(val,null,null);
        NodeD node2=front;
        int count=1;
        while(count<K)
        {
            node2=node2.next;
        }
        node.next=node2.next;
        node.prev=node2;
        node2.next=node;
    }

    void deleteFront()
    {
        NodeD nptr=front.next;
        nptr.prev=null;
        front=nptr;
    }

    void deleteRear()
    {
       NodeD nptr=rear.prev;
       nptr.next=null;
       rear.prev=null;
       rear=nptr;

    }

    void deleteAfterK(int K)
    {
        if(K==1)
        {
            this.deleteFront();
            return;
        }
        if(K==2)
        {
            if(front.next==rear)
            {
                rear.prev=null;
                front.next=null;
                rear=front;
                return;
            }
            NodeD nptr=front.next;
            front.next=nptr.next;
            nptr.next.prev=front;
            return;
        }
        NodeD nptr=front;
        while(K>2)
        {
            nptr=nptr.next;
            K--;
        }
        NodeD nptr2=nptr.next;
        nptr2.next.prev=nptr;
        nptr.next=nptr2.next;
        return;
    }

}

class cyclicLinkedList
{
    NodeS start=null;
    NodeS end=null;


    int size=0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodeS getStart() {
        return start;
    }

    public void setStart(NodeS start) {
        this.start = start;
    }

    public NodeS getEnd() {
        return end;
    }

    public void setEnd(NodeS end) {
        this.end = end;
    }


    cyclicLinkedList(NodeS start,NodeS end)
    {
        this.start=start;
        this.end=end;
    }
    // always holds the property : rear.next=start

    void display(NodeS nodeS)
    {
        int count=0;
        NodeS node=nodeS;
        while(count<size)
        {
            System.out.print(node.val+" ");
            node=node.next;
            count++;
        }
        System.out.println();

    }

    void linearSearch(NodeS nodeS,int target)
    {
        NodeS node=nodeS;
        int count=0;
        while(count<size)
        {
            if(node.val==target)
            {
                System.out.println("Value "+target+" found");
                return;
            }
            node=node.next;
            count++;
        }
        System.out.println("Value "+target+" not found");

    }

    void insert(int val)
    {
        NodeS node=new NodeS(val,null);
        node.next=start;
        start=node;
        size++;
    }

    void insertAfterK(int val,int K)
    {
        NodeS node=new NodeS(val,null);
        NodeS node2=start;
        int count=0;
        while(count<K)
        {
            node2=node2.next;
        }
        node.next=node2.next;
        node2.next=node;
        size++;
    }

    void deleteStart()
    {
        end.next=start.next;
        start=start.next;
        size--;
    }

    void deleteEnd()
    {
        NodeS nptr=start;
        while(nptr.next!=end)
        {
            nptr=nptr.next;
        }
        nptr.next=start;
        end=nptr;
        size--;

    }

    void deleteAtK(int K)
    {
        if(K==1)
        {
            this.deleteStart();
            return;
        }
        if(K==2)
        {
            if(start.next==end)
            {
                start.next=start;
                size--;
                return;
            }
            NodeS nptr=start.next;
            start.next=nptr.next;
            size--;
            return;
        }
        NodeS nptr=start;
        while(K>2)
        {
            nptr=nptr.next;
            K--;
        }
        NodeS nptr2=nptr.next;
        nptr.next=nptr2.next;
        size--;
        return;
    }

}

public class LinkedLists
{
    // correct this
    public static NodeS mergeSortedLinkedLists(NodeS node1,int s1,int e1,NodeS node2,int s2,int e2)
    {

        for(int i=1;i<s1;i++)
        {
            node1=node1.next;
        }
        for(int i=1;i<s2;i++)
        {
            node2=node2.next;
        }
        NodeS n1=node1;
        NodeS n2=node1;
        for(int i=s1+1;i<=e1;i++)
        {
            node1=node1.next;
        }
        for(int i=s2+1;i<=e2;i++)
        {
            node2=node2.next;
        }
        node1.next=null;
        node2.next=null;
        node1=n1;
        node2=n2;
        NodeS start=node1;
        NodeS curr=new NodeS(-1,null);
        start.next=curr;
        while(true)
        {
            if(node1==null)
            {
                break;
            }
            if(node2==null)
            {
                break;
            }
            if(node1.val<=node2.val)
            {

                curr.next=node1;
                curr=curr.next;
                node1=node1.next;
            }
            else
            {
                curr.next=node2;
                curr=curr.next;
                node2=node2.next;
            }
        }
        if(node1!=null)
        {
            curr.next=node1;
        }
        if(node2!=null)
        {
            curr.next=node2;
        }
        return start.next;
    }

    public static NodeS getMiddleNodeOfALinkedList(NodeS node)
    {
        NodeS slow=node;
        NodeS fast=node;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;

    }


    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        System.out.println("Linked Lists Program");
        System.out.println("Which type of Linked List do you want to make");
        System.out.println("1.Singly Linked List");
        System.out.println("2.Doubly Linked List");
        System.out.println("3. Cyclic Linked List");
        System.out.println("Choose 1/2/3");
        int ch=Reader.nextInt();
        if(ch==1)
        {
            singlyLinkedList list=new singlyLinkedList(null,null);
            int choice1=0;
            do
            {   System.out.println("   Enter your choice");
                System.out.println("1. Insert new element at front");
                System.out.println("2. Insert new element at rear");
                System.out.println("3. Insert new element after k positions");
                System.out.println("4. Delete element at front");
                System.out.println("5. Delete element at rear");
                System.out.println("6. Delete element at kth position");
                System.out.println("7. Linear Search an element");
                System.out.println("8. Binary Search an element [Not implemented yet]");
                System.out.println("9. Detect cycle in the list");
                System.out.println("10.Sort the List [Not implemented yet]");
                System.out.println("11.Display the linked list");

                System.out.println("0. Exit");
                choice1=Reader.nextInt();
                switch (choice1)
                {
                    case 0:
                            break;
                    case 1:
                            System.out.println("Enter value");
                            int value=Reader.nextInt();
                            list.insertFront(value);
                            break;
                    case 2:
                            System.out.println("Enter value");
                            value=Reader.nextInt();
                            list.insertRear(value);
                            break;

                    case 3:
                            System.out.println("Enter value");
                            value=Reader.nextInt();
                            System.out.println("Enter K");
                            int K=Reader.nextInt();
                            list.insertAfterK(value,K);
                            break;
                    case 4:
                            list.deleteFront();
                            break;
                    case 5:
                            list.deleteRear();
                            break;
                    case 6:
                            System.out.println("Enter the value of K");
                            K=Reader.nextInt();
                            list.deleteAtK(K);
                            break;
                    case 7:
                            System.out.println("Enter the value to be searched");
                            int val=Reader.nextInt();
                            list.linearSearch(list.front,val);
                            break;
                    case 8:
                            System.out.println("Enter the value to be searched for");
                            val=Reader.nextInt();
                            System.out.println("[Not implemented yet]");
                            break;
                    case 9:
                            list.detectCycle();
                            break;
                    case 10:
                            System.out.println("[Not implemented yet]");
                            break;
                    case 11:
                            list.display(list.front);
                            break;
                    default :
                            break;
                }
            }while(choice1!=0);
        }
        if(ch==2)
        {
            doublyLinkedList list=new doublyLinkedList(null,null);
            int choice1=0;
            do
            {   System.out.println("   Enter your choice");
                System.out.println("1. Insert new element at front");
                System.out.println("2. Insert new element at rear");
                System.out.println("3. Insert new element after k positions");
                System.out.println("4. Delete element at front");
                System.out.println("5. Delete element at rear");
                System.out.println("6. Delete element at kth position");
                System.out.println("7. Linear Search an element");
                System.out.println("8. Linear Search (Backwards) an element");
                System.out.println("9. Display the linked list (forward)");
                System.out.println("10.Display the linked list (backward)");
                System.out.println("0. Exit");
                choice1=Reader.nextInt();
                switch (choice1)
                {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Enter value");
                        int value=Reader.nextInt();
                        list.insertFront(value);
                        break;
                    case 2:
                        System.out.println("Enter value");
                        value=Reader.nextInt();
                        list.insertRear(value);
                        break;

                    case 3:
                        System.out.println("Enter value");
                        value=Reader.nextInt();
                        System.out.println("Enter K");
                        int K=Reader.nextInt();
                        list.insertAtK(value,K);
                        break;
                    case 4:
                        list.deleteFront();
                        break;
                    case 5:
                        list.deleteRear();
                        break;
                    case 6:
                        System.out.println("Enter the value of K");
                        K=Reader.nextInt();
                        list.deleteAfterK(K);
                        break;
                    case 7:
                        System.out.println("Enter the value to be searched");
                        int val=Reader.nextInt();
                        list.linearSearchForward(list.front,val);
                        break;
                    case 8:
                        System.out.println("Enter the value to be searched for");
                        val=Reader.nextInt();
                        list.linearSearchBackward(list.rear,val);
                        break;
                    case 9:
                            list.displayForward(list.front);
                        break;
                    case 10:
                            list.displayBackward(list.rear);
                        break;
                    default:
                        break;
                }
            }while(choice1!=0);
        }
        if(ch==3)
        {
            cyclicLinkedList list=new cyclicLinkedList(null,null);
            int choice1=0;
            do{
                System.out.println("   Enter your choice");
                System.out.println("1. Insert new element");
                System.out.println("2. Insert new element after k positions");
                System.out.println("3. Delete element at start");
                System.out.println("4. Delete element at end");
                System.out.println("5. Delete element at kth position");
                System.out.println("6. Linear Search an element");
                System.out.println("7. Display the linked list");
                System.out.println("0. Exit");
                choice1=Reader.nextInt();
                switch (choice1)
                {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Enter value");
                        int value=Reader.nextInt();
                        list.insert(value);
                        break;
                    case 2:
                        System.out.println("Enter value");
                        value=Reader.nextInt();
                        System.out.println("Enter K");
                        int K=Reader.nextInt();
                        list.insertAfterK(value,K);
                        break;
                    case 3:
                        list.deleteStart();
                        break;
                    case 4:
                        list.deleteEnd();
                        break;
                    case 5:
                        System.out.println("Enter the value of K");
                        K=Reader.nextInt();
                        list.deleteAtK(K);
                        break;
                    case 6:
                        System.out.println("Enter the value to be searched");
                        int val=Reader.nextInt();
                        list.linearSearch(list.start,val);
                        break;
                    case 7:
                        list.display(list.start);
                        break;
                    default:
                        break;
                }
            }while(choice1!=0);
        }
    }
}
