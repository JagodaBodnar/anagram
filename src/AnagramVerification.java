import java.util.Arrays;
import java.util.List;

public class AnagramVerification {
    public static void main(String[] args) {
        Anagram anagram = new Anagram("stone");
        List<String> candidates =  Arrays.asList("stone","tones","banana","tons","notes", "Seton");
        System.out.println(anagram.match(candidates));
        Anagram anagram2 = new Anagram("tapper");
        candidates = Arrays.asList("patter", "potter");
        System.out.println(anagram2.match(candidates));
    }
}
