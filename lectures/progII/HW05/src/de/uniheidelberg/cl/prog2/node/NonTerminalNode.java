package de.uniheidelberg.cl.prog2.node;

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

        if (closingParens > 0 && closingParens >= openingParens) {
          if (i + 1 == ch.length) {
            String[] res = {
              new String(Arrays.copyOfRange(ch, 0, i)),
              ""
            };
            return res;
          } else {
            String[] res = {
              new String(Arrays.copyOfRange(ch, 0, i)),
              new String(Arrays.copyOfRange(ch, i + 2, ch.length + 1))
            };
            return res;
          }
        }
      }
      return null;
    }

    private static Boolean  containsParen(String str) {
      return Pattern.compile( ".*\\(.*" ).matcher( str ).matches();
    }

    public static String join(String[] str) {
      String res = "";
      for(int i=0;i<str.length;i++){
        res += " " + str[i];
      }
      return res;
    }

    public static ArrayList<Node> parseInner( String inner ) {
      // split the contents of the child area into tokens
      String[] innerTokens = findContentByParen(inner)[0].split("\\s");
      ArrayList<Node> children = new ArrayList();

      for(int i=0;i<innerTokens.length;i++){
        String maybeToken = innerTokens[i];
        // if a token has a paren, it's expected to be a NTnode
        if (containsParen(maybeToken)) {
          // get the content of our NTnode except the tokens already processed
          String rest = join(Arrays.copyOfRange(innerTokens, i, innerTokens.length));
          String[] partitionedRest = findContentByParen(rest, 0);
          StringBuilder rawNTNode = new StringBuilder(partitionedRest[0] + ")");
          ArrayList<Node> restNodes = parseInner(partitionedRest[1] + ")");
          children.add(NonTerminalNode.parse(rawNTNode));
          for(int j=0;j<restNodes.size();j++){
            children.add(restNodes.get(j));
          }
          break;
        } else {
          children.add(TerminalNode.parse(new StringBuilder(maybeToken)));
        }
      }
      return children;
    }

    public static Node parse( StringBuilder nodeRepr ) {

    Matcher m = Pattern.compile( "\\s*([^\\s:()]+):\\(\\s*(.+)\\s*" ).matcher( nodeRepr );
    if (m.matches() && m.groupCount() == 2) { // both label and children matched
      String label = m.group(1); // already got the label
      // parse children
      ArrayList<Node> children = parseInner(m.group(2));
      // remove unparseable stuff
      children.removeAll(Collections.singleton(null));
      // return new instance
      return new NonTerminalNode(label, children);
    }

    return null;
    }

}
