import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.lang.Character;
import java.util.function.Function;
import java.util.stream.Collectors;
import ex11.streams.Token;


public class DataReader {
	public static List<Token> readTokensFromFile(String filename) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filename));
		
		List<Token> tokens = new ArrayList<>();
		
		for (String line : lines) {
			if (!line.isEmpty()) {
				String[] splitted = line.split("\t");
				Token t = new Token(splitted[0], splitted[1], splitted[2], Double.parseDouble(splitted[3]));
				tokens.add(t);
			}
		}
		
		return tokens;
	}
	
	public static void main(String[] args) throws IOException {
		List<Token> tokens = readTokensFromFile("./schachnovelle.corpus");

    // get words across entire corpus
    List<Token> ners = tokens.stream()
      .filter(t -> !t.getNamedEntityType().equals("NONE"))
      .collect(Collectors.toList());

    Map<String, List<Token>> byPosTag = tokens.stream()
      .distinct()
      .collect(Collectors.groupingBy(t -> t.getPosTag()));

    String allChars = "arseitnarstoien";

    Map<String, Long> frequentChars = Arrays.stream(
            tokens.stream().map(t -> t.getContent()).collect(Collectors.joining(""))
            .toLowerCase().split("")).collect(
            Collectors.groupingBy(c -> c, Collectors.counting()));

    frequentChars.forEach((k, v) -> System.out.println(k + ":" + v));

    // get words across entire corpus
    // Map<Character, Integer> charFreq = tokens.stream()
    //   .map(t -> t.getContent())
    //   .collect(Collectors.joining("")).chars()
    //   .collect(Collectors.groupingBy(t -> t), Collectors.counting());
		
		// implement stream computations here		
	}
}
