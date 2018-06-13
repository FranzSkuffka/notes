class Person implements Comparable<Person> {
  public MyDate birthday;
  private Name name;
  public Person (Name name, MyDate birthday) {
    this.name = name;
    this.birthday = birthday;
  }
  public static void main (String[] args) {
    Person p = new Person(new Name("Lennard", "Bennard Löhnke", "Böhnke"), new MyDate(01, 01, -3000));
    Person q = new Person(new Name("Lennard", "Bennard Löhnke", "Böhnke"), new MyDate(01, 01, -3000));
    Person j = new Person(new Name("Jesus", "Cheesus Christ", "Christus"), new MyDate(01, 01, 0));
  }
  public String toString () {
    return String.format("%30d  %10d", this.name, this.birthday);
  }
  public int hashCode () {
    return name.hashCode() + birthday.hashCode();
  }
  public int compareTo (Person otherPerson) {
    int nameResult = this.name.compareTo(otherPerson.name);
    if (nameResult == 0) {
      return this.birthday.compareTo(otherPerson.birthday);
    } else {
      return nameResult;
    }
  }

}
