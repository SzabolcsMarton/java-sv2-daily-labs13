package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VowelsTest {

    @Test
    void countVowelsTest(){
        Vowels vowels = new Vowels();

        Map<Character, Integer> result = vowels.countVowels("Golders Green");

        assertEquals(1,result.get('o'));
        assertEquals(3,result.get('e'));
    }



}