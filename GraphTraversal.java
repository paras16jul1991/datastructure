
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Node {

	public int id;
	public List<Node> edges = new ArrayList<>();

	Node(int id) {
		this.id = id;
	}

}

public class GraphTraversal {

	HashMap<Integer, Node> set = new HashMap<Integer, Node>();

	public Node getNode(int node) {
		return set.get(node);
	}

	public void addEdge(int vertex, int edge) {
		Node v = getNode(vertex);
		Node e = getNode(edge);
		v.edges.add(e);
	}

	// Method checks for valid path between source and target.

	public boolean bfs_checkValidPath(int source, int target) {

		Node sourceNode = getNode(source);
		Node targetNode = getNode(target);

		LinkedList<Node> nextVisit = new LinkedList<>();

		nextVisit.add(sourceNode);

		while (!nextVisit.isEmpty()) {

			Node queNode = nextVisit.remove();
			for (Node edge : queNode.edges) {
				if (edge.id == targetNode.id) {
					return true;
				} else
					nextVisit.add(edge);
			}
		}
		return false;
	}

	public static void main(String[] args) {

		GraphTraversal graph = new GraphTraversal();
		graph.set.put(1, new Node(1));
		graph.set.put(2, new Node(2));
		graph.set.put(3, new Node(3));
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);

		System.out.println(graph.bfs_checkValidPath(1, 3));
	}
}
