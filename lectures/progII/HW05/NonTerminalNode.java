
import java.util.*;
import java.util.regex.*;



public class NonTerminalNode extends Node {

    static final char OPENPAREN = '(';
    static  final char CLOSINGPAREN = ')';

    private ArrayList<Node> children;

    public NonTerminalNode( String label, ArrayList<Node> children ) {
        super( label );
        this.children = children;
    }

    ArrayList<Node> getChildren() {
        return this.children;
    }

    public String toString() {

        String result = getLabel()+":( ";
        for ( Node c: this.children ) {
            result += c.toString() + " ";
        }
        result += ")";
        return result;
    }
    private static String[] findContentByParen(String afterOpeningParen) {
      return findContentByParen(afterOpeningParen, 1);
    }

    private static String[] findContentByParen(String afterOpeningParen, int openingParens) {
      int closingParens = 0;
      char[] ch=afterOpeningParen.toCharArray();
      for(int i=0;i<ch.length;i++){
        if (ch[i] == '(') {
          openingParens++;
        } else if (ch[i] == ')') {
          closingParens++;
        }

        if (openingParens == closingParens) {
          String[] res = {
            new String(Arrays.copyOfRange(ch, 0, i)),
            new String(Arrays.copyOfRange(ch, i, ch.length - 1))
          };
          return res;
        }
      }
      return null;
    }

    private static Boolean  containsParen(String str) {
      return Pattern.compile( ".*\\(.*" ).matcher( str ).matches();
    }

    public static Node[] parseInner( String inner ) {
      // split the contents of the child area into tokens
      String[] innerTokens = findContentByParen(inner)[0].split("\\s");
      ArrayList<Node> children = new ArrayList();

      for(int i=0;i<innerTokens.length;i++){
        String maybeToken = innerTokens[i];
        // if a token has a paren, it's expected to be a NTnode
        if (containsParen(maybeToken)) {
          // get the content of our NTnode except the tokens already processed
          String rest = String.join(" ", Arrays.copyOfRange(innerTokens, i, innerTokens.length - 1));
          partitionedRest = afterOpeningParen(rest, 0);
          System.out.println(partitionedRest);
          children.add(new NonTerminalNode(partitionedRest[0]), parseInner(partitionedRest[1]));
        } else {
          children.add(TerminalNode.parse(new StringBuilder(maybeToken)));
        }
      }
      return children;
    }

    public static Node parse( StringBuilder nodeRepr ) {
    System.out.println(nodeRepr);

    Matcher m = Pattern.compile( "\\s*([^\\s:()]+):\\(\\s*(.+)\\s*" ).matcher( nodeRepr );
    if (m.matches() && m.groupCount() == 2) { // both label and children matched
      String label = m.group(1); // already got the label
      children = parseInner(m.group(2));
    }

    return null;
    }

}
