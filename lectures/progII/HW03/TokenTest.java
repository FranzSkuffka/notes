import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class TokenTest {
  public static void main(String[] args) {
    File file = new File("dataset.txt");
    ArrayList<Token> tokens =new ArrayList<Token>();
    try {
      Scanner sc = new Scanner(file);

      sc.nextLine(); // omit table header
      while (sc.hasNextLine()) {
          String line = sc.nextLine();
          String[] data = line.split("\\s+");
          tokens.add(new Token(data));
      }
      assert tokens.get(0).equals(tokens.get(1));
      assert !tokens.get(2).equals(tokens.get(1));
      System.out.println("TEST SUCCESSFUL");
    } catch (FileNotFoundException e ) {
      e.printStackTrace();
    }
  }
}

