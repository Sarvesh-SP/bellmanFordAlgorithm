package bellmanFord;

import java.util.Scanner;

public class bellman {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int v, E = 1, chck = 0;
        int w[][] = new int[20][20];
        int edge[][] = new int[50][2];

        System.out.println("Enter the number of vertices: ");
        v = in.nextInt();

        System.out.println("Enter the weights: ");
        for (int i = 1; i <= v; i++){
            for (int j = 1; j <=v; j++){
                w[i][j] = in.nextInt();

                if (w[i][j]!=0){
                    edge[E][0] = i;
                    edge[E++][1] = j;
                }
            }
        }

        chck = bellmanFord(w, v, E, edge);

        if (chck == 1)
            System.out.println("No negative weights");
        else
            System.out.println("Negative found");
    }

    public static int bellmanFord(int w[][], int V, int E, int edge[][]) {
        int u, v, S, flag = 1;
        int distance[] = new int[20];
        int parent[] = new int[20];

        for (int i = 1; i <= V; i++) {
            distance[i] = 999;
            parent[i] = -1;

        }

        System.out.println("Enter the source ");
        S = in.nextInt();

        distance[S] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (int k = 1; k <= E; k++) {
                u = edge[k][0];
                v = edge[k][1];

                if (distance[u] + w[u][v] < distance[v]) {
                    distance[v] = distance[u] + w[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int k = 1; k <= E; k++){
            u = edge[k][0];
            v = edge[k][1];

            if (distance[u] + w[u][v] < distance[v])
                flag = 0;
        }
        if (flag == 1){
            for(int i=1;i<=V;i++)
                System.out.println("Vertex " + i + " -> cost = " + distance[i] + " parent = "+ (parent[i]));

        }
        return flag;
    }
}
