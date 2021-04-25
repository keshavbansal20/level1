import java.util.*;
public class recursion_backtracking{
    //5
    // 10
    // 20
    // 30
    // 40
    // 50
    // 60
    // Sample Output
    // 10, 20, 30, .
    // 10, 50, .
    // 20, 40, .
    
    public static void printTargetSumSubsets(int[] arr, int idx, String asf, int ssf, int tar) {
        if( idx == arr.length){
            if(ssf == tar){
            System.out.println(asf+".");
            }
            return;
        }
        
        if(ssf > tar){
            return;
        }     
            // yes or no wali call
             printTargetSumSubsets(arr , idx + 1 , asf + arr[idx]+", " , ssf + arr[idx] , tar );
             printTargetSumSubsets(arr , idx + 1 , asf , ssf , tar);
             
             
    }

    // Sample Input
    // 3 3
    // 0 0 0
    // 1 0 1
    // 0 0 0
    // Sample Output
    // rddr
    //fourr calls on every (row,col) ,jate time visited ko true aur aate time false if there is no way
    public static void floodfill(int[][] maze , int sr , int sc , String psf, boolean[][] visited) {
    
        if(sr<0 || sr>=maze.length || sc<0 || sc>=maze[0].length || visited[sr][sc] == true || maze[sr][sc] == 1 ){
            return;
        }
        
        if( sr == maze.length - 1  && sc == maze[0].length -1 ){
            System.out.println(psf);
            return;
        }
        visited[sr][sc] = true;
        floodfill(maze , sr -1 ,  sc , psf +"t" , visited);
        floodfill(maze , sr  ,  sc - 1, psf +"l" , visited);
        floodfill(maze , sr + 1 ,  sc , psf +"d" , visited);
        floodfill(maze , sr  ,  sc + 1 , psf +"r" , visited);
        visited[sr][sc] = false;

    }


    //queen safe
    public static void printNQueens(boolean[][] chess, String asf, int row) {
        if(row == chess.length){
            System.out.println(asf+".");
            return;
        }
        
        for(int col = 0 ; col < chess.length; col++){
            if(isQueenSafe(chess , row , col) == true){
                chess[row][col] = true;
                printNQueens(chess , asf + row +"-"+col+", "  , row + 1);
                chess[row][col] = false;
            }
        }

    }
    
    
    public static boolean isQueenSafe(boolean[][] chess, int row ,int col){
        for(int i= row - 1 ; i >= 0 ; i--){
            if(chess[i][col] == true){
                return false;
            }
        }
        //checking d1
        for(int i = row -1 , j = col+1 ; i>=0 && j< chess.length; i-- , j++){
            if(chess[i][j] == true){
                return false;
            }
        }
        //checking d2
        for(int i = row -1 , j = col - 1 ; i>=0 && j>=0 ; i-- , j--){
            if(chess[i][j] == true){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){

    }
}