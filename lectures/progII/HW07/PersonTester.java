import java.util.*;

public class PersonTester{
    public static void main(String[] args) {
        TreeMap<String, Integer> people = new TreeMap<>();

        // Init Objects
        MyDate date1 = new MyDate(16, 4, 1990);
        Name name1 = new Name("Boi", "Kid", "Man");
        Person person1 = new Person(name1, date1);
        people.put(name1.toString(), person1.hashCode());

        MyDate date2 = new MyDate(16, 4, 1990);
        Name name2 = new Name("Don", "Juan", "Juan");
        Person person2 = new Person(name2, date2);
        people.put(name2.toString(), person2.hashCode());

        MyDate date3 = new MyDate(16, 4, 1991);
        Name name3 = new Name("Ein", "Dicker", "Bu");
        Person person3 = new Person(name3, date3);
        people.put(name3.toString(), person3.hashCode());

        MyDate date4 = new MyDate(17, 5, 1992);
        Name name4 = new Name("Konis", "Hupen", "Lalalallll");
        Person person4 = new Person(name4, date4);
        people.put(name4.toString(), person4.hashCode());

        MyDate date5 = new MyDate(18, 6, 1993);
        Name name5 = new Name("LaLaLaLaLa", "LaLaLaLaLa", "LaLaLaLa");
        Person person5 = new Person(name5, date5);
        people.put(name5.toString(), person5.hashCode());

        MyDate date6 = new MyDate(19, 7, 1994);
        Name name6 = new Name("LoLoLoLoLoLo", "LoLoLoLo", "LoLoLo");
        Person person6 = new Person(name6, date6);
        people.put(name6.toString(), person6.hashCode());

        // Output
        TreeMap<String, TreeMap<String, Integer>> birthdayMap = new TreeMap<>();
        birthdayMap.put(date1.toString(), new TreeMap<String, Integer>());
        birthdayMap.put(date2.toString(), new TreeMap<String, Integer>());
        birthdayMap.put(date3.toString(), new TreeMap<String, Integer>());
        birthdayMap.put(date4.toString(), new TreeMap<String, Integer>());
        birthdayMap.put(date5.toString(), new TreeMap<String, Integer>());
        birthdayMap.put(date6.toString(), new TreeMap<String, Integer>());

        birthdayMap.get(date1.toString()).put(name1.toString(), person1.hashCode());
        birthdayMap.get(date2.toString()).put(name2.toString(), person2.hashCode());
        birthdayMap.get(date3.toString()).put(name3.toString(), person3.hashCode());
        birthdayMap.get(date4.toString()).put(name4.toString(), person4.hashCode());
        birthdayMap.get(date5.toString()).put(name5.toString(), person5.hashCode());
        birthdayMap.get(date6.toString()).put(name6.toString(), person6.hashCode());

        System.out.println("Alle Geburtstage");
        for (Map.Entry<String, TreeMap<String,Integer>> entry : birthdayMap.entrySet()) {
            System.out.println("Birthday: "+entry.getKey()+"     Person(s): "+entry.getValue());
        }

        TreeMap<String, TreeMap<String, Integer>> daymoMap = new TreeMap<>();
        daymoMap.put(date1.toString().substring(0,5), new TreeMap<String, Integer>());
        daymoMap.put(date2.toString().substring(0,5), new TreeMap<String, Integer>());
        daymoMap.put(date3.toString().substring(0,5), new TreeMap<String, Integer>());
        daymoMap.put(date4.toString().substring(0,5), new TreeMap<String, Integer>());
        daymoMap.put(date5.toString().substring(0,5), new TreeMap<String, Integer>());
        daymoMap.put(date6.toString().substring(0,5), new TreeMap<String, Integer>());

        daymoMap.get(date1.toString().substring(0,5)).put(name1.toString(), person1.hashCode());
        daymoMap.get(date2.toString().substring(0,5)).put(name2.toString(), person2.hashCode());
        daymoMap.get(date3.toString().substring(0,5)).put(name3.toString(), person3.hashCode());
        daymoMap.get(date4.toString().substring(0,5)).put(name4.toString(), person4.hashCode());
        daymoMap.get(date5.toString().substring(0,5)).put(name5.toString(), person5.hashCode());
        daymoMap.get(date6.toString().substring(0,5)).put(name6.toString(), person6.hashCode());

        System.out.println("");
        System.out.println("Birthdays by Month and Day");
        for (Map.Entry<String, TreeMap<String,Integer>> entry : daymoMap.entrySet()) {
            System.out.println("Birthday: "+entry.getKey()+"     Person(s): "+entry.getValue());
        }
    }
}
