package DS.Generic_Tree;
import java.util.*;
public class linearize {
    //method 1 =---> post order m second last chld se loop start krna hai
    // 2.gettail se tail Node mangana hai
    // 3.uske baad secondlastkitail ke children m children ko add krna hai
    // last m chilren ke last index ko remove krna hai

    public static Node getTail(Node node){
       
        while(node.children.size()>0){
            node = node.children.get(0);
        }
        return node;
    }
  public static void linearize(Node node){
    // write your code here
    for(Node child:node.children){
        linearize(child);
    }
    for(int i = node.children.size()-2;i>=0;i--){
        Node slkitail = getTail(node.children.get(i));
        slkitail.children.add(node.children.get(i+1));
        node.children.remove(i+1);
    }
  }

  //method2 faith h ki linearize tail return aur passing node ke tree ko linearize bhi krdega
    // 
  
  public static Node linearize2(Node node){
    // write your code here
    if(node.children.size()==0){
        return node;
    }
    Node otail = linearize2(node.children.get(node.children.size()-1));
    for(int i = node.children.size()-2;i>=0;i--){
        Node slkitail = linearize2(node.children.get(i));
        Node last = node.children.get(i+1);
        slkitail.children.add(last);
        node.children.remove(i+1);
    }
    return otail;
  }
}
