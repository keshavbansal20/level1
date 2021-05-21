package DS.Graph.Djikstra_Algo;

import java.util.*;

// Sample Input
//  7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0

//sample output
// 0 via 0 @ 0
// 1 via 01 @ 10
// 2 via 012 @ 20
// 5 via 0125 @ 25
// 4 via 01254 @ 28
// 6 via 01256 @ 28
// 3 via 012543 @ 30
public class shortesPathInwt {
    public static class Pair implements Comparable<Pair>{
        int vtx;
        String psf;
        int wsf;
        Pair(int vtx , String psf , int wsf){
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }
        
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    
    public static void Djikstra(ArrayList<Edge>[] graph , int src){
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src , src+"" , 0));
        while(pq.size()>0){
            Pair rem = pq.remove();
            
            
            //mark
            if(vis[rem.vtx]==true){
                continue;
            }
            vis[rem.vtx] = true;
            
            //work
            System.out.println(rem.vtx + " via " + rem.psf + " @ "+rem.wsf);
            //add unvisited nbr
            for(Edge edge:graph[rem.vtx]){
                if(vis[edge.nbr]==false){
                    pq.add(new Pair(edge.nbr , rem.psf+edge.nbr+"" , rem.wsf+edge.wt));
                }
            }
        }
    }
    
}
