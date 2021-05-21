package DS.Graph.bfs;

import java.util.*;

public class spreafOfInfection {
    public static class Pair{
        int vtx;
        int t;
        Pair(){
            
        }
        Pair(int vtx, int t){
            this.vtx = vtx;
            this.t = t;
        }
    }
    public static int spreadOfInfection(ArrayList<Edge>[] graph , int src , int t){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src , 1));
        boolean[] vis = new boolean[graph.length];
        int count = 0;
        while(q.size()>0){
            //remove
            Pair rem = q.remove();
            
            
            if(rem.t>t){
                break;
            }
            //mark
            if(vis[rem.vtx] == true){
                continue;
            }
            vis[rem.vtx]=true;
            
            //work
            count++;
            
            //add unvisited nbr
            for(Edge edge:graph[rem.vtx]){
                int nbr = edge.nbr;
                if(vis[nbr] == false){
                    q.add(new Pair(nbr ,rem.t+1));
                }
            }
        }
        return count;
        
    }
    
}
