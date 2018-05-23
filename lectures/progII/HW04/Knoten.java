// An more or less abstract class of a Node in a Parse Tree
public class Knoten {
    public String type;

    public Knoten (String type) {
        if (type == "BASE" || type == "WORD" || type == "ROOT" || type == "AFFIX") {
            this.type = type;
        } else {
            System.err.println("You entered an invalid type:'" + type + "'. It must be one of 'BASE', 'WORD', 'ROOT' or 'AFFIX'.");
        }
    }

    public String getType() {
        // Getter of 'type' property
        return this.type;
    }

    public String toString() {
        // string representation of Knoten instance including type
        return getClass().getName() + " of type " + type;
    }
}
