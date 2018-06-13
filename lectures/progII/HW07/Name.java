public class Name implements Comparable <Name> {

    private String firstName;
    private String lastName;
    private String middleName;

    public static void main (String[] args) {
        System.out.println("Hello World"); // prints Hello World
        Name testName = new Name("Lennard", "Bunki", "Boehnke");
        Name testName2 = new Name("Lennard", "Bunke", "Boehnke");
        System.out.println(testName.toString());
        System.out.println(testName.compareTo(testName2));
    }

    public Name (String firstName, String lastName) {
        // Constructor for only first and last name
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name (String firstName, String lastName, String middleName) {
        // Constructor for first, last and middle name
        this(firstName, lastName);
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String toString() {
        return "First Name: " + this.firstName + " Last Name: " + this.lastName + " Middle Name: " + this.middleName;
    }

    public Boolean equals(String[] input){
        Boolean testBoolean = false;
        for (int i = 0; i < input.length; i++){
            for (int j = 0; j < input.length; j++){
                if (input[i] == input [j]){
                    testBoolean = true;
                }

            }
        }
        return testBoolean;
    }

    public void hashCode(String[] input) {
        int[] intArray = {input.length};
        for (int h = 0; h < intArray.length; h++) {
            if (equals(input) == true) {
                for (int i = 0; i < input.length; i++) {
                    for (int j = 0; j < input.length; j++) {
                        intArray[h] = input[i].hashCode();
                        intArray[h+1] = intArray[h];
                        h++;
                    }
                }
            }
            else{
                for (int i = 0; i < input.length; i++) {
                    for (int j = 0; j < input.length; j++) {
                        intArray[h] = input[i].hashCode();
                    }
                }
            }
        }
    }

    public int compareTo(Name otherName) {
        int lastNameResult = this.lastName.compareTo(otherName.lastName);
        int firstNameResult = this.firstName.compareTo(otherName.firstName);
        int middleNameResult = this.middleName.compareTo(otherName.middleName);

        if (lastNameResult == 0) {
            if (firstNameResult == 0) {
                return middleNameResult;
            } else {
                return firstNameResult;
            }

        } else {
            return lastNameResult;
        }

    }

}