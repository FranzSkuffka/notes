import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Graph {
  public Graph (String filename) {
    List<String> lines = readFileAsList(filename);
    this.nodes = lines.get(0).split(" ");

  }
  public static void main (String[] args) {
    Graph g = new Graph("example_graph.txt");
  }

  private void readFileAsList(String filename) {
    try {
      URI uri = this.getClass().getResource(filename).toURI();
      List<String> lines = Files.readAllLines(Paths.get(uri),
      Charset.defaultCharset());
      return lines;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

private class Node {
  public Node (String value) {
  }
}
