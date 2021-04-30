package DS.Generic_Tree;

import java.util.*;

public class generictree{
    public static class Node{
        int data;
        ArrayList<Node> children;
        Node(){

        }
        Node(int data){
            this.data = data;
            this.children= children;
        }
    }
    //find a node in the tree
    public static boolean find(Node node, int data) {
        // write your code here
        if(node.data==data){
            return true;
        }
        for(Node child:node.children){
            boolean rr = find(child,data);
            if(rr==true){
                return true;
            }
        }
        return false;
      }

    //Node to root path
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // write your code here
        if(node.data == data){ //if data is found then add in arraylist and return
            ArrayList<Integer> res = new ArrayList<>();
            res.add(node.data);
            return res;
        }
        for(Node child:node.children){
            ArrayList<Integer> rr = nodeToRootPath(child , data); //recursion reuslt store in rr then if rr size is greater than 0 then node is find add parent to res and return it.
            if(rr.size()>0){
                rr.add(node.data);
                return rr;
            }
        }
        return new ArrayList<>();  //if neither the node nor theirr child have the node then return empty list;z
     }

     //lca --> lowestst common ancestor
     public static int lca(Node node, int d1, int d2) {
        // write your code here
        ArrayList<Integer> list1 = nodeToRootPath(node, d1);//get path for d1
        ArrayList<Integer> list2 = nodeToRootPath(node , d2);//get path for d2
        int p =  list1.size()-1;//iterate from last and stop at non equal node data
        int q = list2.size()-1;
        while(p>=0&&q>=0&&list1.get(p)==list2.get(q)){
            p--;
            q--;
        }
        return list1.get(p+1);//return the last common element
      }

      //distance between two nodes is equal to the numbr of edges between them
    //   find nodetorootpath of both the nodes then get lca from the return lists
    // return sum of index of both list at lca point
    public static int distanceBetweenNodes(Node node, int d1, int d2){
        // write your code here
        ArrayList<Integer> list1 = nodeToRootPath(node , d1);
        ArrayList<Integer> list2 = nodeToRootPath(node , d2);
        int p = list1.size()-1;
        int q = list2.size()-1;
        while(p>=0&&q>=0&&list1.get(p)==list2.get(q)){
            p--;
            q--;
        }
        return (p+q+2);
      }

      //areSimilar
      public static boolean areSimilar(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i = 0 ; i < n1.children.size();i++){
            Node cn1 = n1.children.get(i);
            Node cn2 = n2.children.get(i);
            if(areSimilar(cn1 , cn2)==false){
                return false;
            }
            
        }
        return true;
      }

      //areSimilar
      public static boolean areSimilar(Node n1, Node n2) {
    // write your code here
    if(n1.children.size()!=n2.children.size()){
        return false;
    }
    for(int i = 0 ; i < n1.children.size();i++){
        Node cn1 = n1.children.get(i);
        Node cn2 = n2.children.get(i);
        if(areSimilar(cn1 , cn2)==false){
            return false;
        }
        
    }
    return true;
  }
    //are tree mirror in shape
    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i = 0 ; i< n1.children.size();i++){
            int j = n1.children.size()-i-1;//last index on another node
            Node cn1 = n1.children.get(i);
            Node cn2 = n2.children.get(j);
            if(areMirror(cn1, cn2)==false){
                return false;
            }
        }
        return true;
      }

     //symmetri --> if give node is mirror image to itself then its symmetic
     public static boolean areMirror(Node n1 , Node n2){
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i =0 ; i<n1.children.size();i++){
            int j = n1.children.size()-1-i;
            Node cn1 = n1.children.get(i);
            Node cn2 = n2.children.get(j);
            if(areMirror(cn1 , cn2)==false){
                return false;
            }
        }
        return true;
    } 
    public static boolean IsSymmetric(Node node) {
      return areMirror(node ,node);
    }
    
    //predecessot and successor ---> travel and startegty
    static Node predecessor;
    static Node successor;
    static int state = 0;
    public static void predecessorAndSuccessor(Node node, int data) {
    // write your code here
        if(state==0){
            if(node.data == data){
                state = 1;
            }else{
                predecessor = node;
            }
        } else if(state==1){
            successor = node;
            state =2;
        }
        for(Node child:node.children){
            predecessorAndSuccessor(child , data);
        }
    
  }


  //ceil and Floor value

    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data) {
        // Write your code here
        if(node.data<data){
            floor = Math.max(node.data , floor);
        }
        if(node.data>data){
            ceil = Math.min(node.data , ceil);
        }
        for(Node child :node.children){
            ceilAndFloor(child , data);
        }
    }

        
}