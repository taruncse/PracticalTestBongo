# PracticalTestBongo



# 1) Write a function that detects if two strings are anagram e.g. ‘bleat’ and ‘table’ are anagrams but ‘eat’ and ‘tar’ are not.

* Anagram.java class
```
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


        if (firstArray.length != secondArray.length)
            return false;

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
```
* Main method , from where the Anagram method will be called
```
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
}
```

* Anagram Test code

```
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

```
