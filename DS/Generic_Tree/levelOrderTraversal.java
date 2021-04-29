package DS.Generic_Tree;

import java.util.*;

public class levelOrderTraversal{
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
    //using 2 queue remove print addchildren
    public static void levelOrderLinewise01(Node node){
        // write your code here
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();
        while(mq.size()>0){
            node = mq.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                cq.add(child);
            }
            if(mq.size()==0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
        //using a queue  size loop on size then remove print add enter
        public static void levelOrderLinewise02(Node node){
            // write your code here
            
            Queue<Node> q= new ArrayDeque<>();
            q.add(node);
            while(q.size()>0){
                int s = q.size();
                for(int i = 0 ; i<s;i++){
                    node = q.remove();
                    System.out.print(node.data+" ");
                    for(Node child:node.children){
                        q.add(child);
                    }
                }
                System.out.println();
            }

            //using marker approach add node marker (to check level ending) 
            public static void levelOrderLinewise03(Node node){
                // write your code here
                
                Node marker = new Node();
                Queue<Node> q = new ArrayDeque<>();
                q.add(node);
                q.add(marker);
                while(q.size()>0){
                    node = q.remove();
                    if(node==marker){
                        q.add(marker);
                        System.out.println();
                    }else{
                        System.out.print(node.data+" ");
                        for(Node child:node.children){
                            q.add(child);
                        }
                    }
                    if(q.size()==1){
                        break;
                    }
                }
                
              } 
    public static void man(String[] args){

    }
}

