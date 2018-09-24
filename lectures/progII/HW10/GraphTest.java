import solutions.graphs.GraphWithAdjacencyList;
import solutions.graphs.InvalidNodeException;
import java.io.IOException;
import org.junit.Test;

public class GraphTest {

  @Test
  private static void testGraphWithAdjacencyList() {
    System.out.println("OK");
    try {
      GraphWithAdjacencyList g = new GraphWithAdjacencyList("example_graph.txt");
      try {
        System.out.println(g.getNeighbours("Berg"));
      } catch (InvalidNodeException e) {
        return;
      }
      try {
        System.out.println(g.getNeighbours("noberg"));
      } catch (InvalidNodeException e) {
        return;
      }
      try {
        System.out.println(g.containsEdge("Berg", "Mont_Blanc"));
      } catch (InvalidNodeException e) {
        return;
      }
      try {
        System.out.println(g.containsEdge("Berg", "Alpen"));
      } catch (InvalidNodeException e) {
        return;
      }
    } catch (IOException e) {
      System.out.println("file not found");
    }
  }

}
