import java.util.Arrays;

public class AnagrammCheck {
  public static void main(String[] args) {

    // normalize
    char[] a = args[0].replaceAll("\\s","").toLowerCase().toCharArray();
    char[] b = args[1].replaceAll("\\s","").toLowerCase().toCharArray();

    // sort
    Arrays.sort(a);
    Arrays.sort(b);

    // compare
    System.out.println(Arrays.equals(a, b));
  }
}
