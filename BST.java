import java.io.IOException;

class TNode
{
    int data;
    TNode left;
    TNode right;

    public TNode(int val,TNode left,TNode right)
    {
        this.data=val;
        this.left=left;
        this.right=right;
    }
}
// this binary search tree contains distinct values
class BinarySearchTree
{
    TNode root;

    BinarySearchTree(TNode root)
    {
        this.root=root;
    }

    public static TNode addNode(TNode node,int val)
    {
        if(node==null)
            return new TNode(val,null,null);
        if(node.data<val)
        {
            node.right=addNode(node.right,val);
            return node;
        }
        else
        {
            node.left=addNode(node.left,val);
            return node;
        }
    }

    public static int minimum(TNode node)
    {
        if(node==null)
            return Integer.MAX_VALUE;
        else
            return Math.min(node.data,Math.min(minimum(node.left),minimum(node.right)));
    }

    public static TNode deleteNode(TNode node,int val)
    {
        if(node==null)
            return null;
        if(node.data>val)
        {
            node.left=deleteNode(node.left,val);
        }
        else if(node.data<val)
        {
            node.right=deleteNode(node.right,val);
        }
        else
        {
            if(node.left==null&&node.right==null)
                return null;
            else if(node.left==null&&node.right!=null)
                return node.right;
            else if(node.left!=null&&node.right==null)
                return node.left;
            else
            {
                int min=minimum(node.right);
                node.data=min;
                node.right=deleteNode(node.right,min);
            }
        }
        return node;

    }

    public static boolean search(TNode node,int val)
    {
        if(node==null)
            return false;
        if(node.data==val)
            return true;
        else if(node.data>val)
            return search(node.left,val);
        else
            return search(node.right,val);
    }

    public static int height(TNode node)
    {
        if(node==null)
            return 0;
        else if(node.left==null&&node.right!=null)
        {
            return 1+height(node.right);
        }
        else if(node.left!=null&&node.right==null)
        {
            return 1+height(node.left);
        }
        else
        {
            return 1+Math.max(height(node.left),height(node.right));
        }

    }

    public static TNode clone(TNode node)
    {
        if(node==null)
            return null;
        TNode node2=new TNode(node.data,null,null);
        node2.left=clone(node.left);
        node2.right=clone(node.right);
        return node2;
    }

    public static void traversal(TNode node,int type)
    {
        if(node==null)
            return;
        switch(type)
        {
            case 1:
                System.out.print(node.data+" ");
                traversal(node.left,type);
                traversal(node.right,type);
                break;
            case 2:
                traversal(node.left,type);
                System.out.print(node.data+" ");
                traversal(node.right,type);
                break;
            case 3:
                traversal(node.left,type);
                traversal(node.right,type);
                System.out.print(node.data+" ");
        }
    }

}

public class BST
{
    public static void main(String[] args)throws IOException
    {

        Reader.init(System.in);
        System.out.println("This is a program for BST");
        BinarySearchTree tree=new BinarySearchTree(null);
        System.out.println("Choose an option from the following list");

        int choice=0;
        do
        {
            System.out.println("1. Insert a node in tree");
            System.out.println("2. Delete a node from the tree");
            System.out.println("3. Find height of the tree");
            System.out.println("4. Traverse tree in Pre-Order manner");
            System.out.println("5. Traverse tree in In-Order manner");
            System.out.println("6. Traverse tree in Post-Order manner");
            System.out.println("7. Search an element in the tree");
            System.out.println("0. Exit");
            choice=Reader.nextInt();
            switch(choice)
            {
                case 1:
                        System.out.println("Enter value");
                        int val=Reader.nextInt();
                        tree.root=tree.addNode(tree.root,val);
                        break;
                case 2:
                        System.out.println("Enter value");
                        val=Reader.nextInt();
                        tree.root=tree.deleteNode(tree.root,val);
                        break;
                case 3:
                        System.out.println(tree.height(tree.root));
                        break;
                case 4:
                        tree.traversal(tree.root,1);
                        System.out.println();
                        break;
                case 5:
                        tree.traversal(tree.root,2);
                        System.out.println();
                        break;
                case 6:
                        tree.traversal(tree.root,3);
                        System.out.println();
                    break;
                case 7:
                        System.out.println("Enter value");
                        val=Reader.nextInt();
                        System.out.println(tree.search(tree.root,val));
                        break;
                default:
                        break;


            }
            System.out.println("Do you want to continue ? (1/0)");
            choice=Reader.nextInt();
        }while(choice!=0);

    }
}
