package com.tkb.anagram;

import java.util.Arrays;

public class Anagram {
    static boolean isAnagram(String firstString, String secondString)
    {
        if (firstString == null || secondString == null || firstString.length()==0 || secondString.length()==0 ||
                (firstString.length() != secondString.length()))
            return false;


        int ARRAY_COUNT = 256;

        char firstArray[] = firstString.toLowerCase().toCharArray();
        char secondArray[] = secondString.toLowerCase().toCharArray();


        int firstCounter[] = new int[ARRAY_COUNT];
        Arrays.fill(firstCounter, 0); // set default value

        int secondCounter[] = new int[ARRAY_COUNT];
        Arrays.fill(secondCounter, 0); // set default value

        for (int i = 0; i < firstArray.length && i < secondArray.length; i++) {
            firstCounter[firstArray[i]]++;
            secondCounter[secondArray[i]]++;
        }

        for (int j = 0; j < ARRAY_COUNT; j++)
            if (firstCounter[j] != secondCounter[j]) // match the count values
                return false;

        return true;
    }
}
