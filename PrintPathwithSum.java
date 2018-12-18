import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author teva
 */
public class PrintPathwithSum {
    Node root;
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            this.data = d;
            this.left = null;
            this.right = null;
        }     
    }
    static int sum = 0;
    static Stack<Integer> s = new Stack<>();
    
    public static void pathWithSum(Node root, int k)
    {
        if (root==null) return;       
        
        sum = sum + root.data;  
        s.push(root.data);              
        if(sum==k)
        {
            System.out.println(Arrays.toString(s.toArray()));
        }
        
        pathWithSum(root.left, k);
        pathWithSum(root.right, k);
        
        sum = sum - root.data;
        s.pop();        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        PrintPathwithSum BTree = new PrintPathwithSum();
        BTree.root = new Node(50);
        
        BTree.root.left = new Node(40);
        BTree.root.right = new Node(80);
        
        BTree.root.left.left = new Node(20);
        BTree.root.right.right = new Node(30);
         
        BTree.root.left.left.left = new Node(60);
        BTree.root.right.right.right = new Node(70);
        
        pathWithSum(BTree.root, 170);

    }
    
}
