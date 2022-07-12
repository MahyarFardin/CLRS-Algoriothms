import java.util.*;

public class App {

    public static int[] minimum(int[][] graph, ArrayList<Integer> visitedNodes) {
        int[] result = new int[3];
        result[2] = Integer.MAX_VALUE;

        for (int node : visitedNodes) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[node][j] != 0 && graph[node][j] < result[2]) {
                    result[0] = node;
                    result[1] = j;
                    result[2] = graph[node][j];
                }
            }
        }

        graph[result[0]][result[1]] = Integer.MAX_VALUE;
        graph[result[1]][result[0]] = Integer.MAX_VALUE;
        return result;
    }

    public static void primesAlgorithm(int[][] graph) {

        ArrayList<Integer> visitedNodes = new ArrayList<>();
        int result = 0;

        visitedNodes.add(0);

        for (int i = 0; i < graph.length-1; i++) {

            int[] node = minimum(graph, visitedNodes);
            visitedNodes.add(node[1]);
            result += node[2];
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int rooms = scan.nextInt();
        int doors = scan.nextInt();

        int[][] graph = new int[rooms][rooms];

        for (int i = 0; i < doors; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            graph[x - 1][y - 1] = scan.nextInt();
            graph[y - 1][x - 1] = graph[x - 1][y - 1];
        }

        scan.close();
        primesAlgorithm(graph);
    }

}
