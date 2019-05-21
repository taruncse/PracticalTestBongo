package com.tkb.anagram;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first String");
        String firstString = sc.nextLine();

        System.out.println("Enter second String");
        String secondString = sc.nextLine();

        if (ifAnagram(firstString, secondString)){
            System.out.println(firstString+" and "+secondString+" two strings are anagram");
        } else{
            System.out.println(firstString+" and "+secondString+" two strings are not anagram");
        }
}

    // Anagram checker
    static boolean ifAnagram(String firstString, String secondString)
    {
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

        if (firstArray.length != secondArray.length)
            return false;

        for (int j = 0; j < ARRAY_COUNT; j++)
            if (firstCounter[j] != secondCounter[j]) // match the count values
                return false;

        return true;
    }
}
