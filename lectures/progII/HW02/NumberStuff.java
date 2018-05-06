public class NumberStuff {
  public static void main(String[] args) {
    int sum = 0;
    int a[]=new int[100];//declaration and instantiation  
    for(int i=0;i <a.length;i++) {
      a[i]=i;//initialization
      sum+=i;
    }
    System.out.println(sum);
    for(int i=0;i<a.length;i++) {
      System.out.println(a[i]);
    }
  }
}
