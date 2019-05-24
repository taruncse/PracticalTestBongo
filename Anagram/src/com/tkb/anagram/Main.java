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

        if (Anagram.isAnagram(firstString, secondString)){
            System.out.println(firstString+" and "+secondString+" two strings are anagram");
        } else{
            System.out.println(firstString+" and "+secondString+" two strings are not anagram");
        }
}

    // Anagram checker
}
