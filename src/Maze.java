/************************************************
 * Name: Grant Von Hagen (251307427)
 * Class: Graph.java
 * Class: 2210 
 * Description: Graph Node holds int name and boolean marked
 *************************************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Maze {

	
//	instance variables you may need
//	a variable storing the graph, a variable storing the id of the starting node, a variable storing the id of the end node
//	a variable storing the read number of coins, maybe even a variable storing the path so far so that you don't perform accidental 
//	(and unnecessary cycles).
//	if you maintain nodes on a path in a list, be careful to make a list of GraphNodes, 
//	otherwise removal from the list is going to behave in a weird way. 
//	REMEMBER your nodes have a field mark.. maybe that field could be useful to avoid cycles...
	
	Graph graph;
	GraphNode startingNodeId;
	GraphNode endingNodeId;
	int readNumberOfCoins;
	List<GraphNode> path; // variable storing the path so far so that you dont perform accidnetal and uncecessary cycles
			
		
		public Maze(String inputFile) throws MazeException {
		//		initialize your graph variable by reading the input file!
		//		to maintain your code as clean and easy to debug as possible use the provided private helper method
		
			try
			{
				
				if (inputFile.substring(inputFile.length() - 4, inputFile.length()).compareTo(".txt") != 0)
				{
					throw new MazeException("Wrong type");
				}
				else
				{
					BufferedReader br = new BufferedReader(new FileReader(inputFile));
					String S; //Scale Factor
					String A; //Width of Maze
					String L; //Lenght of Maze
					String K; //Number of coins
					
					if ((S = br.readLine()) != null && (A = br.readLine()) != null && (L = br.readLine()) != null && (K = br.readLine()) != null)
					{
						this.readNumberOfCoins = Integer.valueOf(K); //Read Initial number of coins to readNumberOfCoins
					}
					String Line1; // Straight line I think
					String Line2; // Wall every other
					int counter;
					
					while ((Line1 = br.readLine()) != null && (Line2 = br.readLine()) != null)
					{
						readFileLine(Line1, Line2, counter);
					}
					
					
					
					
				}
			} catch (Exception e) {
				throw new MazeException(e.getMessage());
			}

		}
			
		private static void readFileLine(String line1, String line2, int counter)
		{
			for (int i = 0; i < line1.length(); i++ )
			{
				char pos = line1.charAt(i);
				switch (pos)
				{
					case 's':
						this.startingNodeId = new GraphNode(counter);
						counter ++;
						break;
				
				}
				
					
				
			}
			
			
		}
			
			
		
		
		
		
		
		
		
		
		
	}

	public Graph getGraph() {
//		return your graph
	}

	public Iterator<GraphNode> solve() {
//		simply call your private DFS. If you come up with a different approach that's ok too.
//		remember to always return an Iterator or null
	}

	private Iterator<GraphNode> DFS(int k, GraphNode go) throws GraphException {
//		perform a DFS of your graph. Reduce your k which represents the remaining coins
//		start with the base case
//		remember to return null if you didn't find a path
	}

	private void readInput(BufferedReader inputReader) throws IOException, GraphException {
//		Read the values S, A, L, and k
//		pay attention when iterating over the input.. All testing input will be correctly formatted
//		remember to identify the starting and ending rooms
//		The input will have size A + A-1 and L + L-1 because every pair of nodes has its relationship inbetween them in the textual representation!
//		To maintain this method cleaner, you may use the private helper method insertEdge
	}

	private void insertEdge(int node1, int node2, int linkType, String label) throws GraphException {
//		select the nodes and insert the appropriate edge.
	}

}
