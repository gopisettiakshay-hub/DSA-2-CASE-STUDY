import java.util.*;

public class PrimsMSTCO_3 {
    static final int V = 5;

    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }

        return minIndex;
    }

    void primMST(int graph[][]) {
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !mstSet[v]
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i +
                    "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        PrimsMST t = new PrimsMST();

        int graph[][] = {
                {0, 2, 3, 0, 0},
                {2, 0, 1, 4, 0},
                {3, 1, 0, 5, 6},
                {0, 4, 5, 0, 7},
                {0, 0, 6, 7, 0}
        };

        t.primMST(graph);
    }
}
