package DS.Graph.bfs;
import DS.Graph.Main.Edge;
import java.util.*;
public class isGraphCyclic {
    public static boolean isSingleCompCylic(ArrayList<Edge>[] graph , int src ,boolean[] vis){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);

        while(q.size()>0){
            //remove
            int rem = q.remove();
            //mark
            if(vis[rem]==true){
                return true;
            }
            vis[rem]=true;
            //work
            
            //add nbr
            for(Edge edge:graph[rem]){
                int nbr  = edge.nbr;
                if(vis[nbr]==false){
                    q.add(nbr);
                }
            }
        }
        return false;
    }
    public static boolean isCyclic(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int src = 0 ; src < graph.length ; src++){
            if(vis[src]==false){
                boolean temp = isSingleCompCylic(graph , src ,vis);
            
                if(temp==true){
                    return true;
                }
            }
        }   
        return false;
    }
}
