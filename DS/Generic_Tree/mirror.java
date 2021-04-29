import java.util.*;
package DS.Generic_Tree;

public class mirror {
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
    public static void mirror(Node node){
        // write your code here
        int left  =0; 
        int right = node.children.size()-1;
        while(left<right){
            Node lval = node.children.get(left);
            Node rval = node.children.get(right);
            node.children.set(left,rval);
            node.children.set(right , lval);
            left++;
            right--;
        }
            
            for(Node child:node.children){
                mirror(child);
            }
       
        
      }

    //   using collection reverse
      public static void mirror_01(Node node){
        for(Node child:node.children){
            mirror_01(child);
        }
        Collections.reverse(node.children);
      } 
    
}
