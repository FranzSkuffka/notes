import java.util.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SearchEngine {

  private List<Document> docs;

  private List<List<String>> allContents;
  private List<String> allWords;

  public SearchEngine (String[] filenames) {

    // preprocess docs
    this.docs = Arrays.asList(filenames)
      .stream()
      .map(name -> new Document(name))
      .collect(Collectors.toList());

    // get corpus of each document
    this.allContents = this.docs.stream()
      .map(doc -> doc.content)
      .collect(Collectors.toList());

    // get words across entire corpus
    this.allWords = this.allContents.stream()
      .flatMap(List::stream)
      .collect(Collectors.toList());

  }

  public List<String> search(String term) {
    System.out.println(term);
    System.out.println(this.allWords.get(5));
    System.out.println(this.allWords.get(5).equals(term));
    System.out.println(term.equals(this.allWords.get(5)));
    Boolean termFound = Arrays.asList(this.allWords).contains(term);
    System.out.println(termFound);
    if (termFound) {
      return this.docs.stream()
        .map(doc -> doc.tfIdf(this.allContents, term)) // compute tfIdf
        .sorted((o1, o2)->o1.tfIdf.compareTo(o2.tfIdf)) // sort by it
        .map(doc -> doc.title)
        .collect(Collectors.toList());
    } else {
      return Arrays.asList("Term not recognized");
    }
  }


  public static void main (String[] args) {
    String[] files = new String[]{"example_data/doc1.txt", "example_data/doc2.txt", "example_data/doc3.txt", "example_data/doc4.txt", "example_data/doc5.txt"};
    SearchEngine se = new SearchEngine(files);
    se.searchAndPrint("document");
    se.searchAndPrint("just");
  }

  public void searchAndPrint(String term) {
    System.out.println("\n" + term + "\n");
    System.out.println("\n" + this.allWords + "\n");
    List<String> results = this.search(term);
    System.out.println(results);
  }

}
