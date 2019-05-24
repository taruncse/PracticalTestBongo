package com.tkb.anagram;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest extends Anagram {

    @Test
    public void nullTest() {
        boolean testNull = Anagram.isAnagram(null,null);
       assertEquals(false,testNull);
    }

    @Test
    public void emptyStringTest() {
        boolean testEmpty = Anagram.isAnagram("","");
        assertEquals(false,testEmpty);
    }

    @Test
    public void emptyStringAndNullTest() {
        boolean testEmpty = Anagram.isAnagram(null,"");
        assertEquals(false,testEmpty);
    }
    @Test
    public void anagramTest() {
        boolean testEmpty = Anagram.isAnagram("bleat","table");
        assertEquals(true,testEmpty);
    }

    @Test
    public void notAnagramTest() {
        boolean testEmpty = Anagram.isAnagram("eat","tar");
        assertEquals(false,testEmpty);
    }
    @Test
    public void largeStringTest() {
        boolean testEmpty = Anagram.isAnagram("Hi this is a large string to test anagram. If the test is fails then there is a problem"
                ,"Hi this is a large string to test anagram. If the test is fails then there is a problem");
        assertEquals(true,testEmpty);
    }
}