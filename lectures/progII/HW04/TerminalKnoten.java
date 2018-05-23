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
                    System.out.println("Your knot is of type " + type + ". Subtype can only be D or F! You gave " + subType + "!");
                }
                break;
            default:
                this.subType = subType;
                break;
        }
    }

    public String getForm() {
        // Returns form of terminal knot
        return this.form;
    }

    public String getSubType() {
        // Returns subtype of terminal knot
        return this.subType;
    }

    public String toString() {
        // Return string representation of instance including of what type, form and subtype it is
        return getClass().getName() + " " + type + ":" + form + ":" + subType;
    }
}
