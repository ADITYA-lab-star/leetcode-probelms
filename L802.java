import java.util.*;

public class L802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        int V=graph.length;
        for(int i=0;i<V;i++){
            ans.add(new ArrayList<>());
        }
        int visit[]=new int[V];
        for(int i=0;i<V;i++){
            for(int it:graph[i]){
                ans.get(it).add(i);
                visit[i]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        ArrayList<Integer>safenode=new ArrayList<>();
        for(int i=0;i<V;i++){
          if(visit[i]==0){
            q.add(i);
          }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            safenode.add(node);
            for(int it:ans.get(node)){
                    visit[it]--;
                    if(visit[it]==0){
                        q.add(it);
                    }
            }
        }
            Collections.sort(safenode);
            return safenode;
        }
    
}
