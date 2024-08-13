/************************************************
 * Name: Grant Von Hagen (251307427)
 * Class: Graph.java
 * Class: 2210 
 * Description: Graph Node holds int name and boolean marked
 *************************************************************/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Graph implements GraphADT {
	
//	Create an adjacency list or an adjacency matrix, a list is probably easier
	private Map<GraphNode, List<GraphEdge>> adjlist;
	private ArrayList<GraphNode> nodeList;

	
	

	public Graph(int n) {
		adjlist = new HashMap<>(n);
		nodeList = new ArrayList<>(n);
		for (int i = 0 ; i < n; i++)
		{
			GraphNode temp = new GraphNode(i);
			adjlist.put(temp, new ArrayList<>());
			nodeList.add(temp);
		}
		
		
	}

	/**
	 * Desc: Takes two nodes, and its type and inserts an edge inbetween the nodes
	 */
	public void insertEdge(GraphNode nodeu, GraphNode nodev, int type, String label) throws GraphException {
//		create and insert the edge
//		REMEMBER, an edge is accessible from both endpoints, so make sure you add it as an edge for both end nodes
		if (nodeu == null || nodev == null)
		{
			throw new GraphException("Nodeu or Nodev are null");
		}
		
		try {
	
		
		if (!nodeList.contains(nodev) || !nodeList.contains(nodeu))
		{
			throw new GraphException("nodev or nodeu doesnt exist");
		
		}
		
		adjlist.get(nodeu).add(new GraphEdge(nodeu,nodev,type,label)); //Assign the Edge
		adjlist.get(nodev).add(new GraphEdge(nodeu,nodev,type,label)); //Assign the Edge
		
		}
		catch(Exception e)
		{
			throw new GraphException(e.getMessage());
		}
	}

	/**
	 * Desc: gets the node from nodeList, because I couldn't find a way to pull it out of hashmap (i dont think there is a way to)
	 */
	public GraphNode getNode(int u) throws GraphException {
//		Return the node with the appropriate name

		try
		{
			for (GraphNode node : nodeList)
			{
				if (node.getName() == u)
				{
					return node;
				}
			}
			throw new GraphException("Node doesnt exist");
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new GraphException("Out of Bounds");
		}
		
	}
	
		
	/**
	 * Desc: returns an iterator over the incident edges, the arrayList, over the collection for that particular node
	 */

	public Iterator<GraphEdge> incidentEdges(GraphNode u) throws GraphException {
//		Select from your adjacency list the appropriate Node and return an iterator over the collection.
//		Usually a call to .iterator() should work, unless you do something really exotic
		
		if (u == null)
		{
			throw new GraphException("param cannot be null");
		}
		else
		{
			try
			{
				Iterator<GraphEdge> temp = adjlist.get(u).iterator();
				return temp;
			}
			catch(Exception e)
			{
				throw new GraphException(e.getMessage());
			}
		}
		
		
	}

	/**
	 *  Check if the edge exists, first chck if node exists, then if it does have any edges, and then returns whether it has or not 
	 */
	public GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException {
//		check if those nodes exist, then check if they have edges, then who has the least number of edges.
//		find the appropriate edge and return it, if no such edge exists remember to return null 
//		there are faster ways too ;)
		
		try
		{
		List<GraphEdge> temp = adjlist.get(u).size() <= adjlist.get(v).size() ? adjlist.get(u) : adjlist.get(v);

		for (GraphEdge edge : temp) {
			if (edge.firstEndpoint().equals(u) && edge.secondEndpoint().equals(v)
					|| edge.firstEndpoint().equals(v) && edge.secondEndpoint().equals(u)) {
				return edge;
			}
		}

		return null;
		} catch (Exception e) // probably was an empty adjlist on either u or v
		{
			throw new GraphException(e.getMessage());
		}

	}

	/**
	 *  Throws true if they are adjacent and null if they are not, I think this works, because it will iterate through the list and pass through 
	 *  GraphEdge, and null if it couldnt find the Edge
	 */
	public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException {
//		maybe you could use a previously written method to solve this one quickly...
		try
		{
			if (getEdge(u,v) != null)
			{
				return true;
			}
			return false;
		}
		catch (Exception e)
		{
			throw new GraphException("In are Adjacent: " + e.getMessage());
		}
		
	}

}
