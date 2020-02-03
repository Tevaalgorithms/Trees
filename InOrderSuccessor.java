package com.company;

public class InOrderSuccessor {
    public static void InOrderSuccessor(Tree root, int value){
        if(root == null) {
            return;
        }
        // Step 1: Get the value node
        Tree result = findNode(root, value, false);

        // Step 2: if the Right subtree is NOT EMPTY get the last LEFT node from right sub tree
        if(result.right != null) {
            result = getLastLeftNode(root.right);
        } else{
            // Step 3: if the Right subtree is EMPTY get the last LEFT node from root to this tree
            result = findNode(root,value, true);
        }
        System.out.print(result.val);
    }

    private static Tree findNode(Tree root, int value, boolean getLastLeftTurn) {
        Tree result = null;
        Tree lastLeftTurn = null;
        while(root != null){
            if(root.val == value) {
                result = root;
                break;
            } else if(root.val < value){
                root = root.right;
            } else {
                lastLeftTurn = root;
                root =root.left;
            }
        }
        if(getLastLeftTurn){
            return lastLeftTurn;
        }
        return result;
    }

    private static Tree getLastLeftNode(Tree node){
        if(node == null){
            return  null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String args[]){
        Tree obj = Tree.buildTree();
        System.out.println(" ");
        InOrderSuccessor(obj, 50);
    }

}
