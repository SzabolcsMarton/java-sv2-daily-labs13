package day04;

import java.util.*;

public class Vowels {

    //List<Character> vowels = Arrays.asList('a','e', 'i', 'o', 'u');

    private static final String VOWELS = "aeiou";

    public Map<Character, Integer> countVowels(String text){
        TreeMap<Character, Integer> result = new TreeMap<>();
        for(int i = 0; i < text.length(); i++){
            if(chackIsVowel(text.charAt(i))){
                if(!result.containsKey(text.charAt(i))){
                    result.put(text.charAt(i),1);
                }else {
                    result.put(text.charAt(i),result.get(text.charAt(i))+1);
                }
            }
        }
        return result;
    }

    private boolean chackIsVowel(char c){
        return VOWELS.indexOf(Character.toLowerCase(c)) >= 0;
    }
}
