import java.io.*;
import java.util.*;

public class recursion_in_arrays {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ;i++){
            arr[i] = sc.nextInt();
        }
        displayArr(arr , 0);
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        
        solve();
    }

    public static void displayArr(int[] arr, int idx){
        if(idx==arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx==arr.length){
            return;
        }
        displayArrReverse(arr , idx+1);
        System.out.println(arr[idx]);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        int max =0;
        
        int rr = maxOfArray(arr , idx+1);
  
        if(rr>arr[idx]){
            max = rr;
        }else{
            max = arr[idx];
        }
      
        return max;
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx==arr.length){
            return -1;
        }
        if(arr[idx] == x){
            return idx;
        }else{
        int rr = firstIndex(arr , idx+1 , x);
        return rr;
            
        }
        
    }

    


    



}