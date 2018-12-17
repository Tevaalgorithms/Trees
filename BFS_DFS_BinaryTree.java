import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author teva
 */
public class BFS_DFS_BinaryTree 
{
    Node root;
    
    public static class Node
    {
        char data;
        Node left;
        Node right;
        Node(char d)
        {
            this.data= d;
            this.left=null;
            this.right= null;
        }
    }
    
    BFS_DFS_BinaryTree()
    {
        this.root = null;
    }
    
    /*
    Steps:
    First add the root node to the queue
    Second: Until the queue is empty
        a. Get the root node and print the data
        b. Add the left of the root node
        c. Add the right of the root node
    */
    
    public static void BFS(Node root)
    {
        Queue<Node> qu = new LinkedList<>();
        
        if(root!=null)
        {
            qu.add(root);
        }
        while(!qu.isEmpty())
        {
            root = qu.poll();
            System.out.println(root.data);
            
            if(root.left != null)
            {
                qu.add(root.left);
            }
            
            if(root.right!=null)
            {
                qu.add(root.right);
            }
        }        
    }
    
    /*
    this works based on Stack
    */
    public static void DFS(Node root)
    {
        if(root==null)return;
        System.out.println(root.data);
        DFS(root.left);
        DFS(root.right);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
      /*
               a
           b        c
        d    e    f    g
      */
      
      BFS_DFS_BinaryTree BT = new BFS_DFS_BinaryTree();
      BT.root = new Node('a');
      BT.root.left = new Node('b');
      BT.root.right = new Node('c');
      
      BT.root.left.left = new Node('d');
      BT.root.left.right = new Node('e');
      
      BT.root.right.left = new Node('f');        
      BT.root.right.right = new Node('g');
      
      System.out.println("BFS");
      BFS(BT.root);
      
      System.out.println("DFS");
      DFS(BT.root);
    }    
}
