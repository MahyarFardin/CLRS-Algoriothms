import java.util.*;

class App{
	public static void main(String args[]){

		Queue tempNodes = new PriorityQueue();
		Scanner cin = new Scanner(System.in);

		System.out.println("How many nodes do you have?");
		int numberOfNodes = cin.nextInt();

		System.out.println("Enter which node is connected to which node (starting from 0) and add \"end\" in the end");
		int [][] adj = new int[numberOfNodes][numberOfNodes];

		
		while (true){
			String tmp0 =  new String();
			String tmp1 =  new String();

			tmp0 = cin.next();
			
			if(tmp0.equals("end"))	break;

			tmp1 = cin.next();

			adj[Integer.parseInt(tmp0)][Integer.parseInt(tmp1)] = 1;			
		}

	}
}
