import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        // Build in-degree array
        int[] inDegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency and in-degree
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        // Initialize queue with zero in-degree nodes
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // Create result list
        int[] order = new int[numCourses];
        int idx = 0;

        // Process queue
        while (!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;

            // Reduce in-degree of neighbors
            for (int nei : adj.get(node)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Return order if valid, else empty
        if (idx == numCourses) {
            return order;
        }
        return new int[0];
    }
}
