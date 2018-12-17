public class MaximumValueinBinaryTree 
{
    Node root;
    
    MaximumValueinBinaryTree()
    {
        this.root = null;
    }
    
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            this.data = d;
            left = null;
            right = null;
        }        
    }
    
    public static int FidMaximum(Node root)
    {
        if(root == null) return -1;
        int max;
        int leftMax = FidMaximum(root.left);
        int rightMax = FidMaximum(root.right);
       if(leftMax > rightMax)
           max = leftMax;
       max = rightMax;
       if(root.data>max)
       {
           return root.data;
       }
       return max;        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaximumValueinBinaryTree BTree = new MaximumValueinBinaryTree();
        
        BTree.root = new Node(50);
        
        BTree.root.left = new Node(40);
        BTree.root.right = new Node(80);
        
        BTree.root.left.left = new Node(20);
        BTree.root.left.right = new Node(30);
         
        BTree.root.right.left = new Node(60);
        BTree.root.right.right = new Node(70);
        
        System.out.println("Max value: " + FidMaximum(BTree.root));      
                
    }
    
}
