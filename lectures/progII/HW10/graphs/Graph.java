package solutions.graphs;

import java.util.Collection;

/**
 * An interface for Graph
 */
public interface Graph {
    /**
     * Check whether an edge between i and j exists in the graph.
     *
     * If i and j are nodes of the graph, the function should return
     *      * true if an edge between i and j exists in the graph, 
     *      * false otherwise.
     *
     * @throw an InvalidNodeException if i and j are not both contained in the graph.
     */
    public boolean containsEdge(String i, String j) throws InvalidNodeException;

    /**
     * Return all nodes j for which there exists an edge from i to j.
     *
     * @throw an InvalidNodeException if i is not contained in the graph.
     */
    public Collection<String> getNeighbours(String i) throws InvalidNodeException;
    
    /**
     * Add an edge between i and j to the graph.
     * 
     * If i and j are nodes of the graph, the function should return
     *      * true if an edge between i and j was not present in the graph and
     *        was added, 
     *      * false if an edge between i and j already existed in the graph.
     *
     * @throw an InvalidNodeException if i and j are not both contained in the graph.
     */
    public boolean addEdge(String i, String j) throws InvalidNodeException;
    
    /**
     * Add a node i to the graph.
     *
     * The function should return
     *      * true if a node i was not present in the graph and
     *        was added, 
     *      * false if it already existed in the graph.
     *
     */
    public boolean addNode(String i);
}

