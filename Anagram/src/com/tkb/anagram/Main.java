package com.tkb.anagram;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        if (ifAnagram("eat", "tar")){
            System.out.println("This two strings are anagram");
        } else{
            System.out.println("This two strings are not anagram");
        }
}

    static boolean ifAnagram(String firstString, String secondString)
    {
        int ARRAY_COUNT = 256;

        char firstArray[] = firstString.toCharArray();
        char secondArray[] = secondString.toCharArray();

        int firstCounter[] = new int[ARRAY_COUNT];
        Arrays.fill(firstCounter, 0); // set default value

        int secondCounter[] = new int[ARRAY_COUNT];
        Arrays.fill(secondCounter, 0); // set default value

        for (int i = 0; i < firstArray.length && i < secondArray.length; i++) {
            firstCounter[firstArray[i]]++;
            secondCounter[secondArray[i]]++;
        }


        if (firstArray.length != secondArray.length)
            return false;

        for (int j = 0; j < ARRAY_COUNT; j++)
            if (firstCounter[j] != secondCounter[j]) // match the count values
                return false;

        return true;
    }
}
