/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verticalordertraversal;
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
    
    
    public static void VerticalOrder_Recursive(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> tmp)
    {
        if(root == null)
            return;
        
        ArrayList<Integer> alist = tmp.get(hd);
        
        if(alist == null)
        {
            alist = new ArrayList<Integer>();
            alist.add(root.data);            
        }
        else
        {
            alist.add(root.data);
        }
        
        tmp.put(hd, alist);
        
        
        if(root.left!=null)
        {
            VerticalOrder_Recursive(root.left, hd - 1 , tmp);
        }
        
        if(root.right != null)
        {
            VerticalOrder_Recursive(root.right, hd + 1 , tmp);  
        }
    }
    
    public static void VerticalOrder(Node root)
    {
      if(root == null) return;
      TreeMap<Integer, ArrayList<Integer>> tmp = new TreeMap<>();
      int hd = 0;
      VerticalOrder_Recursive(root, hd, tmp);
      
      for(Entry<Integer, ArrayList<Integer>> entry: tmp.entrySet())
      {
        System.out.println(entry.getValue());   
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
                       
        System.out.print("Vertical Recursive Order \n");
        VerticalOrder(root);
    }
    
}
