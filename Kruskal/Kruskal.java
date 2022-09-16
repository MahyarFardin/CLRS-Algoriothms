import java.util.*;

public class Kruskal{
  
  public static boolean isVisited(int i, int j, int[] visited){
	return (visited[i]==1)&&(visited[j]==1);
  }

  public static void search(int[][] graph, int[] visitedNodes , int total){
	
	boolean flag=false;
	int counter=0;

	for(int node:visitedNodes){
	  if(node>1){
		counter++;
	  }
	}

	if(counter>=(graph.length/2)){
	  System.out.println("Total weight is: "+total);	
	  return;
	}

	int [] minimum={0,0,Integer.MAX_VALUE};

	for(int i=0;i<graph.length; i++){
	  for(int j=i+1;j<graph.length; j++){
		if(graph[i][j]!=0 && graph[i][j]!=0 && !isVisited(i, j, visitedNodes ) && graph[i][j]<minimum[2]){
		  minimum[0]=i;
		  minimum[1]=j;
		  minimum[2]=graph[i][j];
		}  
	  }
	}

	total += graph[minimum[0]][minimum[1]];
	System.out.println("from "+(minimum[0]+1)+" to "+(minimum[1]+1)+" weight is "+minimum[2]);	
	graph[minimum[0]][minimum[1]]=0;
	
	visitedNodes[minimum[0]]+=1;
	visitedNodes[minimum[1]]+=1;

	search(graph, visitedNodes, total);
  }

  public static void main(String args[]){
	Scanner scanner= new Scanner(System.in);

	System.out.println("Enter total number of nodes and vertex: ");
	int nodes=scanner.nextInt();
	int vertex=scanner.nextInt();

	int [][] graph= new int[nodes][nodes];
	int [] visitedNodes=new int[nodes];

	System.out.println("Enter first node second node and weight of vertex connecting these two:");
	for(int i=0; i<vertex; i++){
	  int x=scanner.nextInt();
	  int y=scanner.nextInt();
	  
	  graph[x-1][y-1]=scanner.nextInt();
	  graph[y-1][x-1]=graph[x-1][y-1];
	}

	scanner.close();

	
	System.out.println("\nMatrix of weights based on nodes: ");	
	for(int[] numbers:graph)
	  System.out.println(Arrays.toString(numbers));	

	System.out.println("\nProcess\n");

	search(graph, visitedNodes, 0);
  }
}
