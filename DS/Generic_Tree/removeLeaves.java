package DS.Generic_Tree;

import java.util.*;
public class removeLeaves {
    public static class Node{
        int data;
        ArrayList<Node> children;
        Node(){

        }
        Node(int data){
            this.data = data;
            this.children = children;
        }
    }
    public static void removeLeaves(Node node) {
        // write your code here
        for(int i = 0 ; i< node.children.size();i++){
            Node child = node.children.get(i);
            if(child.children.size()==0){
                node.children.remove(i);
                i--;
            }
        }
        for(Node child:node.children){
            removeLeaves(child);
        }
        public static void main(String[] args){
            removeLeaves(root);
        }
    
}
