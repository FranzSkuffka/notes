// Models a terminal node in a parse tree
public class TerminalKnoten extends Knoten {

    public String form;

    public String subType;

    public TerminalKnoten(String type, String form, String subType) {
        super(type);

        this.form = form;

        switch (type) {
            case "AFFIX":
                if (subType == "D" || subType == "F") {
                    this.subType = subType;
                } else {
                    System.out.println("Your node is of type " + type + ". Subtype must be either D or F. You gave " + subType + ".");
                }
                break;
            default:
                this.subType = subType;
                break;
        }
    }

    public String getForm() {
        // Return form
        return this.form;
    }

    public String getSubType() {
        // Return subtype
        return this.subType;
    }

    public String toString() {
        // String representation of instance: name, type, form and subtype
        return getClass().getName() + " " + type + ":" + form + ":" + subType;
    }
}
