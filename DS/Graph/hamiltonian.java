package DS.Graph;

import DS.Graph.Main.Edge;

public class hamiltonian {
    public static void hamiltonian(ArrayList<Edge>[] graph , int src  , String psf,boolean[] vis , int osrc){
            
        if(graph.length==psf.length()){
            System.out.print(psf);
            for(Edge edge:graph[osrc]){
                int nbr = edge.nbr;
                if(nbr == src){
                    System.out.println("*");
                    return;
                }
                
               
            }
             System.out.println(".");
                return;
        }
         vis[src]=true;
         for(Edge edge:graph[src]){
             if(vis[edge.nbr]==false){
                 hamiltonian(graph , edge.nbr , psf+edge.nbr , vis , osrc);
             }
         }
         vis[src]=false;
        
                
    }
}
