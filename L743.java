import java.util.*;

public class L743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new int[] { times[i][1], times[i][2] });
        }
        
        int[] delays = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        Arrays.fill(delays, Integer.MAX_VALUE);

        delays[k] = 0;

        pq.add(new int[] { k, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int edgedelay = current[1];

            if (edgedelay > delays[node]) {
                continue;
            }

            for (int i = 0; i < adj.get(node).size(); i++) {
                int[] edge = adj.get(node).get(i);
                int next = edge[0];
                int weight = edge[1];
                int newDelay = edgedelay + weight;

                if (newDelay < delays[next]) {
                    delays[next] = newDelay;
                    pq.add(new int[] { next, newDelay });
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (delays[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, delays[i]);
        }

        return result;
    }
}
