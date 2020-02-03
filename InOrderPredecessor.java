package com.company;

import java.util.Stack;

public class InOrderPredecessor {

    public static void InOrderPredecessor(Tree root, int value){
        // Step 1: Find the node in the Tree
        Tree result = getTreeNode(root, value, false);

        // Step 2: If the left sub Tree of the given node IS NOT NULL then get the last right sub Tree element
        if(result.left != null) {
            result = getLastRightNode(result.left);
        } else{
        // Step 3: If the left sub Tree of the given node is EMPTY then get the last last RIGHT TURN NODE from the root
            result = getTreeNode(root, value, true);
        }
        System.out.print(result.val);
    }

    public static Tree getLastRightNode(Tree root){
        if(root == null) {
            return null;
        }
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static Tree getTreeNode(Tree root, int val, boolean getLastRightTurn){
        if(root == null) {
            return null;
        }
        Tree lastRight = null;
        Tree result = null;
        while(root != null) {
            if(root.val == val) {
                result = root;
                break;
            } else if(root.val < val){
                lastRight = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if(getLastRightTurn == true){
            return lastRight;
        }
        return result;
    }

    public static void main(String args[]){
        Tree obj = Tree.buildTree();
        System.out.println(" ");
        InOrderPredecessor(obj, 50);
    }
}
