package graph;
import java.util.*;
public class Topological {
    int V;
    List<Integer> adj[];

    public Topological (int V){
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0 ; i <V ;i++){
            adj[i] = new ArrayList<>();
        }
    }
        public void addEdge(int u , int v){
            adj[u].add(v);
        
    }
        public void topologicalSort(){
            int indegree[] = new int[V];
            for (int i=0;i<V ;i++){
             
            for (int node : adj[i]){
                indegree[node]++;
            }
        }
        Queue<Integer>q = new LinkedList<Integer>();
        for (int i = 0;i <V;i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        List<Integer> topOrder = new ArrayList <>();
        while(!q.isEmpty()){
            int u = q.poll();
            topOrder.add(u);
            for (int node :adj[u]){
                if(--indegree[node] == 0){
                q.add(node);
                }
            }
            count++;
        }
        if(count!=V){
            System.out.println("there exist a cycle in the graph");
            return ;
        }
        for (int i : topOrder){
            System.out.println(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Topological g = new Topological(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological Sort of the given graph:");
        g.topologicalSort();
    }
}
