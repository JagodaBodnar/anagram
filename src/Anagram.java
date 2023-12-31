import java.util.*;

class Anagram {
    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> candidates) {
        List<String> anagrams = new ArrayList<>();
        for(int i = 0; i < candidates.size(); i++){
            if(compare(word, candidates.get(i))){
                anagrams.add(candidates.get(i));
            }
        }
        return anagrams;
    }
    public boolean compare(String word, String candidate){
        String wordLowerCase = word.toLowerCase();
        String candidateLowerCase = candidate.toLowerCase();
        if(wordLowerCase.length() != candidateLowerCase.length() || wordLowerCase.equals(candidateLowerCase)){
            return false;
        }
        else{
            for(int i=0; i < wordLowerCase.length(); i++){
                if(!candidateLowerCase.contains(Character.toString(wordLowerCase.charAt(i)))){
                    return false;
                }
            }
            if(!checkIfCorrectLetters(wordLowerCase, candidateLowerCase)){
                return false;
            }
            return true;
        }
    }
    public boolean checkIfCorrectLetters(String wordLowerCase, String candidateLowerCase){
        Map<Character, Integer> wordLowerCaseMap = new HashMap<>();
        Map<Character, Integer> candidateLowerCaseMap = new HashMap<>();
        for (char c : wordLowerCase.toCharArray()) {
            wordLowerCaseMap.compute(c, (key, value) -> (value == null) ? 1 : value + 1);
        }
        for (char c : candidateLowerCase.toCharArray()) {
            candidateLowerCaseMap.compute(c, (key, value) -> (value == null) ? 1 : value + 1);
        }
       return wordLowerCaseMap.equals(candidateLowerCaseMap);
    }

}