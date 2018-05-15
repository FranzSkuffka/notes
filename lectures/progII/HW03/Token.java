public class Token {
  public int id;
  public String surface;
  public String lemma;
  public String pos;
  public int head;
  public String rel;

  public Token(String[] data) {
    this.id = Integer.parseInt(data[0]);
    this.surface = data[1];
    this.lemma = data[2];
    this.pos = data[3];
    this.head = Integer.parseInt(data[4]);
    this.rel = data[5];
    // System.out.println([id, surface, lemma, pos, head, rel]);
  }

  public void print() {
    System.out.println(this.surface + " " + this.pos + " " + this.lemma);
  }

  public Boolean equals(Token otherToken) {
    return true;
  }
}
