package DS.Graph.Prim's;

public class Prim {
    public static class Pair implements Comparable<Pair>{
        int v;
        int acv;
        int wt;
        Pair(){
            
        }
        Pair(int v , int acv , int wt){
            this.v = v;
            this.acv = acv;
            this.wt = wt;
        }
        
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
        
    }
    
    public static void Prim(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0 ,-1 , 0));
        while(pq.size()>0){
            //remove
            Pair rem = pq.remove();
            //mark
            if(vis[rem.v]==true){
                continue;
            }
            vis[rem.v]=true;
            //work
            if(rem.acv!=-1){
                System.out.println("["+rem.v+"-"+rem.acv+"@"+rem.wt+"]");    
            }
            
            
            //add unvisited nbr
            for(Edge edge:graph[rem.v]){
                if(vis[edge.nbr]==false){
                    pq.add(new Pair(edge.nbr , rem.v , edge.wt));
                }
            }
        }
    }
    
}
