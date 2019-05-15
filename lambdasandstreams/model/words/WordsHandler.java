package lambdasandstreams.model.words;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsHandler {
    public Integer uniqueWordsNumber(List<String> words){
        return (int)words.stream().distinct().count();
    }

    public List<String> sortedUniquesWords(List<String> words){
        return words.stream().distinct().sorted().collect(Collectors.toList());
    }

    public Map<String,Long> wordOccurrences(List<String> words){
        return words.stream().collect(Collectors.groupingBy(String::toString,Collectors.counting()));
    }

    public Map<String,Long> characterOccurrences(List<String> words){
        List<String> lowerChars = words.stream()
                .flatMap(a -> Stream.of(a.split("")))
                .filter(c -> c != c.toUpperCase())
                .collect(Collectors.toList());
        return lowerChars.stream()
                .collect(Collectors.groupingBy(c -> c,Collectors.counting()));

    }
public static void main(String[] args) {
    Map<String,Long> occurrences = new WordsHandler().characterOccurrences(Arrays.asList("kreek","ghost","ghost","mirror"));
    System.out.println(occurrences);
}
}
