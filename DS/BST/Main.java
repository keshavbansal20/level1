package DS.BST;
import java.util.*;

public class Main{
    

    //lowest common ancestor
    public static int lca(Node node, int d1, int d2) {
        // write your code here
        
        if(d1>node.data && d2>node.data){
            return lca(node.right,d1 ,d2);
        }else if(d1<node.data && d2<node.data){
            return lca(node.left,d1,d2);
        }else {
            return node.data;
        }
      }

      //print IN Range
      //optimise than BT , check on node data make it optimise and calls smartly to reduce TC
      public static void pir(Node node, int lo, int hi) {
        // write your code here
        if(node==null){
            return;
        }
        if(node.data>=lo&&node.data<=hi){
            pir(node.left , lo , hi);
            System.out.println(node.data);
            pir(node.right , lo , hi);
        }else if(node.data>lo && node.data>hi){
            pir(node.left ,lo , hi);
        }else if(node.data<lo && node.data<hi){
            pir(node.right , lo , hi);
        }else{
            
        }
      }

      //targetsumPair
      public static boolean find(Node node , int data){
        if(node==null){
            return false;
        }
        if(node.data>data){
            return find(node.left , data);
        }else if(node.data<data){
           return  find(node.right  ,data);
        }else{
            return true;
        }
    }
    public static void tsp(Node node , int tar,Node oroot){
        if(node==null){
            return;
        }
        tsp(node.left , tar ,oroot);
        int comp = tar-node.data;
        if(comp>node.data){
            if(find(oroot , comp)==true){
                System.out.println(node.data+" "+comp);
            }
        }
        tsp(node.right , tar , oroot);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }





    public static Node construct(int[] arr , int lo , int hi){
        if(lo>hi){
            return null;
        }
        
        int mid = (lo+hi)/2;
        Node node = new Node(arr[mid]);
        node.left = construct(arr ,0 , mid-1);
        node.right = construct(arr , mid+1 , hi);
        return node;
    }
    public static void display(Node node){
        if(node==null){
            return;
        }
        String str = " <- "+ node.data+" -> ";
        String left = node.left!=null?""+node.left.data:".";
        String right = node.right!=null?""+node.right.data:".";
        str = left+str+right;
        System.out.println(str);
        
        display(node.left);
        display(node.right);
        
        
    }
    public static void main(String[] args){
        int[] arr = {12,25,30,37,40,50,60,70,75,87};
    
        Node root = construct(arr , 0 , arr.length-1);
        display(root);
        
    }
}