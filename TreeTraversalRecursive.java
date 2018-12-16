package trees;


public class TreeTraversalRecursive 
{
    Node root;
    
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            this.data = d;
        }    
    }
    
    TreeTraversalRecursive(int d)
    {
        this.root = new Node(10);
    }
    
    TreeTraversalRecursive()
    {
        this.root = null;
    }
    
    
    public static void PrintInOrder(Node root)
    {
        if(root==null)return;
        PrintInOrder(root.left);
        System.out.println(root.data);
        PrintInOrder(root.right);
    }
    
    public static void PrintPreOrder(Node root)
    {
        if(root==null)return;
        System.out.println(root.data);
        PrintInOrder(root.left);        
        PrintInOrder(root.right);
    }
    
    public static void PrintPostOrder(Node root)
    {
        if(root==null)return;      
        PrintInOrder(root.left);        
        PrintInOrder(root.right);
        System.out.println(root.data);
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Create a tree
        TreeTraversalRecursive BTree = new TreeTraversalRecursive();
        BTree.root = new Node(50);
        
        BTree.root.left = new Node(40);
        BTree.root.right = new Node(80);
        
        BTree.root.left.left = new Node(20);
        BTree.root.left.right = new Node(30);
         
        BTree.root.right.left = new Node(60);
        BTree.root.right.right = new Node(70);
        
        System.out.println("InOreder");
        PrintInOrder(BTree.root);
        
        System.out.println("PreOrder");
        PrintPreOrder(BTree.root);
        
        System.out.println("PostOrder");
        PrintPostOrder(BTree.root);
                
    }
    
}
