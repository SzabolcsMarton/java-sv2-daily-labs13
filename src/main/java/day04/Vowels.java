package day04;

import java.util.*;

public class Vowels {

    //List<Character> vowels = Arrays.asList('a','e', 'i', 'o', 'u');

    private static final String VOWELS = "aeiou";

    public Map<Character, Integer> countVowels(String text) {
        TreeMap<Character, Integer> result = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (chackIsVowel(text.charAt(i))) {
                refreshMap(i, result, text);
            }
        }

        return result;
    }

    private void refreshMap(int index, TreeMap<Character, Integer> mapToRefresh, String text) {
        if (!mapToRefresh.containsKey(text.charAt(index))) {
            mapToRefresh.put(text.charAt(index), 1);
        } else {
            mapToRefresh.put(text.charAt(index), mapToRefresh.get(text.charAt(index)) + 1);
        }
    }

    private boolean chackIsVowel(char c) {
        return VOWELS.indexOf(Character.toLowerCase(c)) >= 0;
    }
}
