package DS.heap.comparatorAndComparable;

import java.io.*;
import java.util.*;

public class Main {

  public static class MyPriorityQueue<T> {
    ArrayList<T> data;
    Comparator<T> comp;

    public MyPriorityQueue() {
      data = new ArrayList<>();
      comp = null;
    }
    
    public MyPriorityQueue(Comparator<T> comp) {
      data = new ArrayList<>();
      this.comp = comp;
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
        if(comp == null){
            Comparable ith = (Comparable)data.get(i);
            Comparable jth = (Comparable)data.get(j);
            
            if(ith.compareTo(jth) < 0){
                return true;
            }else{
                return false;
            }
        }else{
            T ith = data.get(i);
            T jth = data.get(j);
            
            if(comp.compare(ith, jth) < 0){
                return true;
            }else{
                return false;
            }
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

    public static class Student implements Comparable<Student>{
        String name;
        int marks;
        int ht;
        int wt;
        int rank;
        
        public Student(String name, int ms, int ht, int wt, int rank){
            this.name = name;
            this.marks = ms;
            this.ht = ht;
            this.wt = wt;
            this.rank = rank;
        }
        
        public int compareTo(Student o){
            return o.marks - this.marks;
        }
        
        public String toString(){
            return this.name + " [" + this.marks + "] " + this.ht + ", " +this.wt + ", " + this.rank + ". ";
        }
    }
    
    public static class StHtComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.ht - s2.ht;
        }
    }

  public static void main(String[] args) throws Exception {
    
    MyPriorityQueue<Student> mpq = new MyPriorityQueue<>();
    mpq.add(new Student("a", 56, 170, 68, 5));
    mpq.add(new Student("b", 78, 181, 85, 3));
    mpq.add(new Student("c", 80, 174, 80, 2));
     
     
     while(mpq.size() != 0){
         System.out.println(mpq.remove());
     }
     
     //by deafult -> Comparable -> compareTo
     //to override default behaviour of comaprison
     //Use Comparator(interface)
     MyPriorityQueue<Student> mpq1 = new MyPriorityQueue<>(new StHtComparator());
     mpq1.add(new Student("a", 56, 170, 68, 5));
    mpq1.add(new Student("b", 78, 181, 85, 3));
    mpq1.add(new Student("c", 80, 174, 80, 2));
    
    while(mpq1.size() != 0){
         System.out.println(mpq1.remove());
     }
  }
}
