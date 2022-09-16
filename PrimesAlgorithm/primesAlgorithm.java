import java.util.*;

public class primesAlgorithm {

    public static int[] minimum(int[][] graph, ArrayList<Integer> visitedNodes) {
        int[] result = new int[3];
        result[2] = Integer.MAX_VALUE;

        for (int j = 0; j < graph.length; j++) {
            for (int node : visitedNodes) {
                if (!visitedNodes.contains(j) && graph[node][j] != 0 && graph[node][j] < result[2]) {
                    result[0] = node;
                    result[1] = j;
                    result[2] = graph[node][j];
                }
            }            
        }

        graph[result[0]][result[1]] = 0;
        graph[result[1]][result[0]] = 0;
        return result;
    }

    public static void primesAlgorithm(int[][] graph) {

        ArrayList<Integer> visitedNodes = new ArrayList<>();
        int result = 0;

        visitedNodes.add(0);

        System.out.println("=============================");
        for (int i = 0; i < graph.length - 1; i++) {

            int[] node = minimum(graph, visitedNodes);
            visitedNodes.add(node[1]);
            System.out.println("from " + (node[0] + 1) + " to " + (node[1] + 1));
            result += node[2];
        }

        System.out.println("Total price is: " + result);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter total number of rooms and doors:");
        int rooms = scan.nextInt();
        int doors = scan.nextInt();

        int[][] graph = new int[rooms][rooms];

        System.out.println("Enter first room second room and price: ");
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
