import java.io.*;
import java.util.*;

public class downheapify {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    public PriorityQueue(int[] arr){
        data = new ArrayList<>();
        for(int a : arr){
            data.add(a);
        }
        
        for(int i = (data.size() - 2) / 2; i >= 0; i--){
            downheapify(i);
        }
    }

    public void add(int val) {
      data.add(val);
      upheapify(data.size() - 1);
    }
    
    public void upheapify(int ci){
        if(ci == 0){
            return;
        }
        
        int pi = (ci - 1) / 2;
        if(data.get(ci) < data.get(pi)){
            swap(ci, pi);
            upheapify(pi);
        }
    }
    
    public void swap(int ci, int pi){
        int cv = data.get(ci);
        int pv = data.get(pi);
        
        data.set(ci, pv);
        data.set(pi, cv);
    }

    public int remove() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return -1;
      }else{
          int ans = data.get(0);
          swap(0, data.size() - 1);
          data.remove(data.size() - 1);
          downheapify(0);
          return ans;
      }
    }
    
    public void downheapify(int pi){
        
        int lci = (2 * pi) + 1;
        int rci = (2 * pi) + 2;
        
        int minidx = pi;
        if(lci < data.size() && data.get(lci) < data.get(minidx)){
            minidx = lci;
        }
        
        if(rci < data.size() && data.get(rci) < data.get(minidx)){
            minidx = rci;
        }
        
        if(minidx != pi){
            swap(pi, minidx);
            downheapify(minidx);
        }
        
    }

    public int peek() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return -1;
      }else{
          return data.get(0);
      }
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    int[] arr = {5, 7, 11, 13, 17, 91, -5, 16};
    PriorityQueue pq = new PriorityQueue(arr);
    while(pq.size() != 0){
        System.out.println(pq.remove());
    }
    
  }
}