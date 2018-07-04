package solutions.graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A graph data structure that also exposes an adjacency list
 */
public class GraphWithAdjacencyList implements Graph {
    /**
     * Keep the adjacencyList as a map of String onto a List of Strings
     */
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    /**
     * Read a graph from a given file path
     * @throws IOException
     */
    public GraphWithAdjacencyList(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        
        String[] nodes = lines.get(0).split(" ");
        
        for (String node : nodes) {
            addNode(node);
        }
        
        for (String edge : lines.subList(1, lines.size())) {
            String[] splitted = edge.split(" ");
            String sourceNode = splitted[0];
            String targetNode = splitted[1];
            
            adjacencyList.get(sourceNode).add(targetNode);
        }
    }

    /**
     * Check if two nodes are connected by an edge
     * @throws InvalidNodeException
     * @return true if two nodes are connected
     */
    @Override
    public boolean containsEdge(String sourceNode, String targetNode) throws InvalidNodeException {
        if (!adjacencyList.containsKey(sourceNode)) {
            throw new InvalidNodeException("");
        }        
        
        if (adjacencyList.get(sourceNode).contains(targetNode)) {
            return true;
        }
        else {
            return false;
        }
    }
    

    /**
     * Get neighbours of a node
     * @return A collection of nodes
     * @throws InvalidNodeException
     */
    @Override
    public Collection<String> getNeighbours(String i) throws InvalidNodeException {
        if (!adjacencyList.containsKey(i)) {
            throw new InvalidNodeException("");
        }        
        
        List<String> neighbours = adjacencyList.get(i);
        
        return neighbours;
    }

    /**
     * Add a new edge between two nodes
     * @throws InvalidNodeException
     * @return false if the nodes were connected already
     */
    @Override
    public boolean addEdge(String sourceNode, String targetNode) throws InvalidNodeException {
        if (!adjacencyList.containsKey(sourceNode) || !adjacencyList.containsKey(targetNode)) {
            throw new InvalidNodeException("");
        }        
        
        if (containsEdge(sourceNode, targetNode)) {
            return false;
        }
        else {
            adjacencyList.get(sourceNode).add(targetNode);

            return true;            
        }       
    }
    
    /**
     * Add a new edge between two nodes
     * @return false if the nodes exists already
     */
    @Override
    public boolean addNode(String i) {

    	if (!adjacencyList.containsKey(i)) {
            adjacencyList.put(i, new ArrayList<String>());
            return true;
        }
        else {
            return false;
        }
    }           
}
