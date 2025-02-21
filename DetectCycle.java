package graph;
import java.util.*;

class DetectCycle{
    private final int V;
    private final List<List<Integer>> adj ;

    public DetectCycle (int V){
        this.V= V;
        adj = new ArrayList<>(V);
        for (int i = 0;i<V;i++){
            adj.add(new LinkedList<>());
        }
    }
        private boolean isCyclicUtil(int i ,boolean[] visited , boolean[] recStack ){
            if (recStack [i])
            return true;
            if (visited [i])
            return false;

            visited[i]= true;
            recStack[i] = true;

            List<Integer>children = adj.get(i);
            for (Integer c : children ){
                if(isCyclicUtil(c,visited ,recStack))
                return true;
            }
                recStack[i] = false;
                return false;
            }
            private void addEdge (int source,int dest){
                adj.get(source).add(dest);
            }
            private boolean isCycle(){
                boolean [] visited = new boolean [V];
                boolean [] recStack = new boolean [V];

                for (int i =0;i<V;i++){
                    if (isCyclicUtil(i,visited,recStack))
                    return true;
                }
                return false;
            }
        public static void main (String []args){
            DetectCycle graph = new DetectCycle (4);
            graph.addEdge  (0,1);
            graph.addEdge  (0,2);
            graph.addEdge  (1,2);
            graph.addEdge  (2,0);
            graph.addEdge  (2,3);
            graph.addEdge  (3,3);
            if (graph.isCycle ()){
            System.out.println("graph contains cycle");}
            else{
            System.out.println("contains cycle");
        }
    }
    }

