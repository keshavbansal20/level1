
package DS.Generic_Tree;

import java.util.*;

public class zigzag{
    public static class Node{
        int data;
        ArrayList<Node> children;
        Node(){

        }
        Node(int data){
            this.data= data;
            this.children = children;
        }
    }
    public static void levelOrderLinewiseZZ(Node node){
        // write your code here
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.add(node);
        int level = 0;
        while(ms.size()>0){
            node = ms.pop();
            System.out.print(node.data+" ");
            if(level%2==0){
                for(int i = 0 ; i < node.children.size();i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }else{
                for(int i  = node.children.size()-1;i>=0;i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if(ms.size()==0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
            
        }
      }
    public static void main(String[] args){

    }
}





