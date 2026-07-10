public class TestL1334 {
    public static void main(String[] args) {
        L1334 sol = new L1334();
        int[][] edges = {{0,1,3},{1,2,2},{2,3,1},{3,4,1},{0,4,2}};
        System.out.println(sol.findTheCity(5, edges, 4));
    }
}
