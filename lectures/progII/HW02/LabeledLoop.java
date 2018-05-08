public class LabeledLoop {
    public static void main(String[] args) {

        String[] names = new String[]{"Harry", "Peter", "Michael", "Franz"};
        String[] pseudonyms = new String[]{"Mike", "Peter", "Hans", "Xaver"};

        for (String s : names) {
            for (String p : pseudonyms) {
                if (s == p) {
                    System.out.println("Schlechtes Pseudonym: "+s);
                }
            }
            System.out.println("Checked "+s);
        }
    }
}
