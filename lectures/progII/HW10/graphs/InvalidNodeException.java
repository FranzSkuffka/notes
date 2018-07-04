package solutions.graphs;

/**
 * An exception type for when a Node searched for by ID was not found in a graph data structure.
 */
public class InvalidNodeException extends Exception {
	/**
	 * serialVersionUID facilitates versioning of serialized data.
	 * Its value is stored with the data when serializing.
	 * When de-serializing, the same version is checked to see how the serialized data matches the current code.
	 * https://stackoverflow.com/a/12702699
	 */
	private static final long serialVersionUID = 1989177576572092814L;

  /**
   * Construct a new InvalidNodeException
   */
	public InvalidNodeException(String message) {
		super(message);
	}
}
