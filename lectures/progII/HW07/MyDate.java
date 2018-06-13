import java.util.*;
import java.util.Comparator;

public class MyDate implements Comparable <MyDate> {

  private int day;
  private int month;
  private int year;

  public int getDay () { return this.day; };
  public int getMonth () { return this.month; };
  public int getYear () { return this.year; };

  public static void main (String[] args) {
    MyDate d = new MyDate(11, 8, 2034);
    MyDate e = new MyDate(11, 8, 2034);
    MyDate f = new MyDate(5, 8, 2035);
    MyDate g = new MyDate(11, 12, 2035);
    MyDate h = new MyDate(5, 9, 1995);
    MyDate i = new MyDate(5, 5, 2018);
    System.out.println(d);
    System.out.println(d.hashCode());
    System.out.println(d.getYear());
    System.out.println(d.equals(e));
    System.out.println(d.equals(f));

    ArrayList<MyDate> al=new ArrayList<MyDate>();
    al.add(d);
    al.add(e);
    al.add(f);
    al.add(g);
    al.add(h);
    al.add(i);

    System.out.println("");
    System.out.println("REGULAR");
    // Test sorting
    Collections.sort(al);
    for (MyDate date : al) {
      System.out.println(date);
    }

    // Test comparator
    System.out.println("");
    System.out.println("MONTHDAY");
    Collections.sort(al, MonthDayComparator);
    for (MyDate date : al) {
      System.out.println(date);
    }
    // MyDate bad = new MyDate(110, 8, 2035);
  }

  public static Comparator <MyDate> MonthDayComparator = new Comparator<MyDate>() {
    public int compare(final MyDate lhs,MyDate rhs) {
      return lhs.comparableHashCodeMonthDay() - rhs.comparableHashCodeMonthDay();
    }
  };

  public MyDate (int day, int month, int year){
    if (0 < month &&  month <= 12) {
      this.month = month;
    } else {
      throw new IllegalArgumentException("There are exactly 12 months a year.");
    }

    if (0 < day && day <= getMaxDays(month)) {
      this.day = day;
    } else {
      throw new IllegalArgumentException("This month has " + getMaxDays(month) + " days.");
    }

    this.year = year;
  }

  public int compareTo (MyDate d) {
    return this.comparableHashCode() - d.comparableHashCode();
  }

  private int getMaxDays (int month) {
    int nOfDays;
    switch (month) {
      case 1:  nOfDays = 31;
           break;
      case 2:  nOfDays = 28;
           break;
      case 3:  nOfDays = 31;
           break;
      case 4:  nOfDays = 30;
           break;
      case 5:  nOfDays = 31;
           break;
      case 6:  nOfDays = 30;
           break;
      case 7:  nOfDays = 31;
           break;
      case 8:  nOfDays = 31;
           break;
      case 9:  nOfDays = 30;
           break;
      case 10: nOfDays = 31;
           break;
      case 11: nOfDays = 30;
           break;
      case 12: nOfDays = 31;
           break;
      default: nOfDays = 0;
           break;
    }
    return nOfDays;
  }
  public int hashCode () {
    return this.day * 3
         + this.month * 5
         + this.year * 7;
  }

  public int comparableHashCode () {
    return this.day
         + this.month * 100
         + this.year * 10000;
  }

  public int comparableHashCodeMonthDay () {
    return this.day * 1000
         + this.month * 100000
         + this.year;
  }

  public String toString () {
    return String.format("%02d-%02d-%04d", this.day, this.month, this.year);
  }
  public Boolean equals (MyDate d) {
    return this.toString().equals(d.toString());
  }
}
