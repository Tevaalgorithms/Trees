import java.util.*;
import java.util.Map.Entry;
/**
 *
 * @author teva
 */
 
public class VerticalOrderTraversal 
{
    public static class Node
    {
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
    
    static class Pair{
        int hd;
        Node n;
    }
    
    public static void VerticalOrder_Iterative(Node root)
    {
        if(root==null) return;
        
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair();
        p.hd = 0;
        p.n = root;                
        q.add(p);
        
        int lefthd;
        int righthd;
        
        
        TreeMap<Integer, ArrayList<Integer>> tmp = new TreeMap<>();
        ArrayList<Integer> alist= new ArrayList<>();        
        alist.add(root.data);        
        tmp.put(0, alist);       
       
        
        while(!q.isEmpty())
        {   
            ArrayList<Integer> aa;
            Pair temp = q.poll();
            if(temp.n.left!=null)
            {
                lefthd = temp.hd - 1;
                aa = tmp.get(lefthd);
                if(aa == null)
                {
                    aa = new ArrayList<>();
                    aa.add(temp.n.left.data);
                    tmp.put(lefthd, aa);
                }
                else
                {
                  aa.add(temp.n.left.data);
                  tmp.put(lefthd, aa);  
                }
                Pair pl = new Pair();
                pl.hd = lefthd;
                pl.n = temp.n.left;                        
                q.add(pl);             
            }
            if(temp.n.right != null)
            {
                righthd = temp.hd + 1;
                aa = tmp.get(righthd);
                if(aa == null)
                {
                    aa = new ArrayList<>();
                    aa.add(temp.n.right.data);
                    tmp.put(righthd, aa); 
                }
                else
                {
                   aa.add(temp.n.right.data);
                   tmp.put(righthd, aa);   
                }
                Pair pr = new Pair();
                pr.hd = righthd;
                pr.n = temp.n.right;                        
                q.add(pr);  
            }
        }
        
        // print the results
        for(Entry<Integer, ArrayList<Integer>> e : tmp.entrySet())
        {
             System.out.println(e.getValue());   
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
        root.right.right.right = new Node(9); 
        System.out.println("Vertical Order traversal is");        
              
        System.out.print("Vertical Iterative Order \n");
        VerticalOrder_Iterative(root);
       
    }
    
}
