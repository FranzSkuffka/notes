public class NichtTerminalKnoten extends Knoten {

    public Knoten[] children;

    public NichtTerminalKnoten(String type, Knoten[] children) {
        super(type);
        this.children = children;

    }

    public Knoten[] getChildren () {
        // Returns children array
        return this.children;
    }
}
