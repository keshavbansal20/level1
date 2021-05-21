package DS.heap.mypriorityQueue;
import java.io.*;
import java.util.*;

public class Main {

  public static class MyPriorityQueue<T> {
    ArrayList<T> data;

    public MyPriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(T val) {
      data.add(val);
      upheapify(data.size() - 1);
    }
    
    public void upheapify(int ci){
        if(ci == 0){
            return;
        }
        
        int pi = (ci - 1) / 2;
        if(isSmaller(ci, pi) == true){
            swap(ci, pi);
            upheapify(pi);
        }
    }
    
    public boolean isSmaller(int i, int j){
        Comparable ith = (Comparable)data.get(i);
        Comparable jth = (Comparable)data.get(j);
        
        if(ith.compareTo(jth) < 0){
            return true;
        }else{
            return false;
        }
        
    }
    
    public void swap(int ci, int pi){
        T cv = data.get(ci);
        T pv = data.get(pi);
        
        data.set(ci, pv);
        data.set(pi, cv);
    }

    public T remove() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return null;
      }else{
          T ans = data.get(0);
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
        if(lci < data.size() && isSmaller(lci, minidx) == true){
            minidx = lci;
        }
        
        if(rci < data.size() && isSmaller(rci, minidx) == true){
            minidx = rci;
        }
        
        if(minidx != pi){
            swap(pi, minidx);
            downheapify(minidx);
        }
        
    }

    public T peek() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return null;
      }else{
          return data.get(0);
      }
    }

    public int size() {
      return data.size();
    }
  }

    public static class Car implements Comparable<>{
        String brand;
        int maxSpeed;
        
        public Car(String brand, int ms){
            this.brand = brand;
            this.maxSpeed = ms;
        }
        
        public int compareTo(Car o){
            return this.maxSpeed - o.maxSpeed;
        }
    }

  public static void main(String[] args) throws Exception {
    
    MyPriorityQueue<Car> mpq = new MyPriorityQueue<>();
    mpq.add(new Car("Hyundai", 200));
     mpq.add(new Car("Maruti", 120));
     
     
     while(mpq.size() != 0){
         System.out.println(mpq.remove().maxSpeed);
     }
  }
}
