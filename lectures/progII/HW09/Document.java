import java.util.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Document {
  /**
   * Document is basically a cache layer for operations across a collection texts
   * 1| Document Title
   * 2|
   * 3| First
   * 3| SecondWord
   * 3| (.)
   * Usage: `new Document('foo_dir/foo_text_file.txt')
   */


  // Meta
  public String title;

  // Content
  private List<String> rawContent;
  public List<String> content;

  // last calculation
  public Double tfIdf;
  private TFIDFCalculator tfidfCalculator = new TFIDFCalculator();

  private static String[] STOPWORD_OR_EMPTY = new String[]{"he", "she", "it", "the", "a", "an", ".", ",", ""};

  public Document (String filename) {
    /* read files */
    List<String> data = readFileAsList(filename);

    /* split head and body */
    this.title = data.get(0);
    this.rawContent = data.subList(2, data.size());

    /* filter stopwords or empty lines */
    this.content = this.rawContent.stream()
      .map(word -> word.toLowerCase())
      .filter(word -> !Arrays.asList(this.STOPWORD_OR_EMPTY).contains(word))
      .collect(Collectors.toList());
  }

  private List<String> preprocess (List<String> words) {
    return words.subList(2, words.size());
  }

  private String represent (List<String> words) {
    System.out.println(words);
    return "hi";
  }

  private List<String> readFileAsList(String filename) {
    try {
      URI uri = this.getClass().getResource(filename).toURI();
      List<String> lines = Files.readAllLines(Paths.get(uri),
      Charset.defaultCharset());
      return lines;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }
  public Document tfIdf(List<List<String>> corpus, String term) {
    // Urrrgghhhh :(
    this.tfIdf = this.tfidfCalculator.tfIdf(this.content, corpus, term);
    return this;
  }
}
