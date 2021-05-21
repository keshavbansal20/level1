package DS.Graph;

import java.util.*;
public class BFS {
    public static class Pair{
        int v;
        String psf;
        Pair(){
            
        }
        Pair(int v , String psf){
            this.v = v;
            this.psf = psf;
        }
    }
    
    public static void BFS(ArrayList<Edge>[] graph , int src){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src , src+""));
        boolean[] vis = new boolean[graph.length];
        while(q.size()>0){
            //remove
            Pair rem = q.remove();
            
            //mark
            if(vis[rem.v]==true){
                continue;
            }
            vis[rem.v] = true;
            
            //work
            System.out.println(rem.v+"@"+rem.psf);
            
            //add nbr
            for(Edge edge:graph[rem.v]){
                int nbr = edge.nbr;
                if(vis[nbr] == false){
                    q.add(new Pair(nbr , rem.psf + nbr));
                }
            }
        }
    }


    //BFS linewise
    //0 -> 2 
    // 1 -> 1 3 
    // 2 -> 0 4 
    // 3 -> 5 6 
    // 4 -> 


    public static void BFS_L(ArrayList<Edge>[] graph, int src){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[graph.length];
        q.add(src);
        int lev = 0;
        while(q.size()>0){
            int s = q.size();
            System.out.print(lev+" -> ");
            for(int i = 0 ;i < s ; i++){
                //remove
                int rem = q.remove();
                
                //mark
                if(vis[rem]==true){
                    continue;
                }
                vis[rem] = true;
                //work
                System.out.print(rem+" ");
                //add nbr
                for(Edge edge:graph[rem]){
                    int nbr = edge.nbr;
                    if(vis[nbr]==false){
                        q.add(nbr);
                    }
                }
            }
            lev++;
            System.out.println();
        }
    }
    
}


