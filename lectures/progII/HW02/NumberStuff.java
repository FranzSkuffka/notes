public class NumberStuff {
  public static void main(String[] args) {
    int sum = 0;
    int a[]=new int[100];//declaration and instantiation  
    for(int i=0;i <a.length;i++) {
      a[i]=i;//initialization
      if(i % 3 == 0)
        System.err.println(i);
      if(i % 5 == 0)
        System.err.println(i);
      sum+=i;
    }
  }
}
