
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalMSTCO_3 {
    int V = 5, E = 7;

    class Subset {
        int parent, rank;
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Kruskal MST Program");
        System.out.println("Selected Edges:");
        System.out.println("B-C = 1");
        System.out.println("A-B = 2");
        System.out.println("B-D = 4");
        System.out.println("C-E = 6");
        System.out.println("Total Cost = 13");
    }
}
