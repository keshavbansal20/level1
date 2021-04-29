package DS.Generic_Tree;
import java.util.*;

public class tree {
    public static class Node{
        int data;
        ArrayList<Node> children;
        
        Node(){

        }
        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static Node construct(Integer[] data) {
        Stack<Node> st = new Stack<>();
        Node root = new Node(data[0]);
        st.push(root);
        for(int i = 1; i < data.length; i++) {
            if(data[i] != null) {
                // 1. create a new node
                Node nn = new Node(data[i]);
                // 2. add yourself in children of top of stack
                st.peek().children.add(nn);
                // 3. add yourself in stack
                st.push(nn);
            } else {
                st.pop();
            }
        }

        return root;
    }

    
    public static void display(Node root){
        if(root==null){
            return;
        }
        System.out.print(" [ "+root.data+" ] ");
        for(int i = 0 ; i<root.children.size();i++){
            Node child =root.children.get(i);
            System.out.print(" -> "+child.data+" , ");
        }
        System.out.println(" . ");
        
        for(Node child:root.children){
            display(child);
        }

    }
    public static void fun(){
        Integer[] data = {10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null,
            120, null, null, 90, null, null, 40, 100, null, null, null};

        Node root = construct(data);
        display(root);
    }


    public static void main(String[] args){
        fun();
    }
}
