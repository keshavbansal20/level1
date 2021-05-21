package DS.Graph.bfs;
import java.util.*;

public class isGraphBipartite {
    public static class Pair{
        int vtx;
        int set;
        Pair(){
            
        }
        Pair(int vtx, int set){
            this.vtx = vtx;
            this.set = set;
        }
    }
    
    
    public static boolean isSingleCompBipartite(ArrayList<Edge>[] graph, int src,int[] vis){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src , 1));
        while(q.size()>0){
            //remove
            Pair rem = q.remove();
            //mark
            if(vis[rem.vtx]!=0){
                if(vis[rem.vtx] !=rem.set){
                    return false;
                }
                continue;
            }
            vis[rem.vtx]=rem.set;
            
            //add univisited nbr
            for(Edge edge:graph[src]){
                int nbr = edge.nbr;
                if(vis[nbr]==0){
                    int nset = (rem.set==2)? 1 : 2;
                    q.add(new Pair(nbr , nset));
                }
            }
        }
        return true;
        
    }
     public static boolean isGraphBipartite(ArrayList<Edge>[] graph ){
         int[] vis = new int[graph.length];
         for(int src = 0 ; src< graph.length ; src++){
             if(vis[src]==0){
             boolean temp = isSingleCompBipartite(graph , src , vis);
                 if(temp==false){
                     return false;
                 }
             }
         }
         return true;
     }
    
}
