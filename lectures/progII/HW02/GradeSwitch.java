public class GradeSwitch {
  public static void main(String[] args) {
    System.out.println(args);
    switch(args[0]) {
      case "1":
        System.out.println("A");
        break;
      case "2":
        System.out.println("B");
        break;
      case "3":
        System.out.println("C");
        break;
      case "4":
        System.out.println("D");
        break;
      case "5":
        System.out.println("F");
        break;
    }
  }
}
