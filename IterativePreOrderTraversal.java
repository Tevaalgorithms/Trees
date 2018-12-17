public class IterativePreOrderTraversal 
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
    
    IterativePreOrderTraversal(int d)
    {
        this.root = new Node(10);
    }
    
    IterativePreOrderTraversal()
    {
        this.root = null;
    }   
   
    public static void IterativePreOrder(Node root)
    {
        if(root==null)return;
        Stack<Node> s = new Stack<Node>();
        while(true)
        {
            while(root!=null)
            {
                s.push(root);
                System.out.println(root.data);
                root = root.left;
            }
            
            if(s.isEmpty())
            {
                break;
            }
            Node temp;
            temp = s.pop();           
            root = temp.right;
        }        
    }
    
        
    public static void main(String[] args) 
    {
        // Create a tree
        IterativePreOrderTraversal BTree = new IterativePreOrderTraversal();
        BTree.root = new Node(50);
        
        BTree.root.left = new Node(40);
        BTree.root.right = new Node(80);
        
        BTree.root.left.left = new Node(20);
        BTree.root.left.right = new Node(30);
         
        BTree.root.right.left = new Node(60);
        BTree.root.right.right = new Node(70);
        
        System.out.println("InOreder");
        IterativePreOrder(BTree.root);
    }
    
}
