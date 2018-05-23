// This class tests all the Knoten classes and subclasses in this directory
public class KnotenTest {
    public static void main (String[] args) {

        // 1. Construct terminals
        Knoten anti = new TerminalKnoten("AFFIX", "anti", "D");
        Knoten establish = new TerminalKnoten("ROOT", "establish", "V");
        Knoten ment = new TerminalKnoten("AFFIX", "ment", "D");
        Knoten protest = new TerminalKnoten("ROOT", "protest", "N");
        Knoten s = new TerminalKnoten("AFFIX", "s", "I");

        // 2. Construct non-terminals
        Knoten[] base1Children = {establish, ment};
        Knoten base1 = new NichtTerminalKnoten("BASE", base1Children);
        Knoten[] base2Children = {anti, base1};
        Knoten base2 = new NichtTerminalKnoten("BASE", base2Children);
        Knoten[] base3Children = {base2, protest};
        Knoten base3 = new NichtTerminalKnoten("BASE", base3Children);
        Knoten[] wordChildren = {base3, s};
        Knoten word = new NichtTerminalKnoten("BASE", wordChildren);

        // 3. Print out root node
        System.out.println(word.toString());
    }
}
