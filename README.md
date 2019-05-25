# PracticalTestBongo



# Q1) Write a function that detects if two strings are anagram e.g. ‘bleat’ and ‘table’ are anagrams but ‘eat’ and ‘tar’ are not.

Answer : 

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

# Q2) Explain the design pattern used in following:
```
interface Vehicle {
	int set_num_of_wheels()
	int set_num_of_passengers()
	boolean has_gas()
}
```
# 2a) Explain how can you use the pattern to create car and plane class?

Answer : 

We can use this interface directly as the normal interface is used.

Given Interface Vehicle
```
public interface Vehicle {
    int set_num_of_wheels();
    int set_num_of_passengers();
    boolean has_gas();
}
```

* Vehicle interface has been implemented in Car class, and default values are assigned.

```
public class Car implements Vehicle {
    @Override
    public int set_num_of_wheels() {
        return 4;
    }

    @Override
    public int set_num_of_passengers() {
        return 6;
    }

    @Override
    public boolean has_gas() {
        return true;
    }
}
```
* Vehicle interface has been implemented in Plane class, and default values are assigned.

```
public class Plane implements Vehicle {
    @Override
    public int set_num_of_wheels() {
        return 6;
    }

    @Override
    public int set_num_of_passengers() {
        return 200;
    }

    @Override
    public boolean has_gas() {
        return false;
    }
}
```

* VehicleProvider class

```
public class VehicleProvider {
    public Vehicle getCar(){
        return new Car();
    }

    public Vehicle getPlane(){
        return new Plane();
    }
}
```
* Main method and entry point of the programm
```
import basic.VehicleProvider;

public class Main {

    public static void main(String[] args) {
        VehicleProvider vehicleProvider = new VehicleProvider();

        Vehicle plane = vehicleProvider.getPlane();
        printValue(plane);

        Vehicle car = vehicleProvider.getCar();
        printValue(car);

    }

    private static void printValue(Vehicle vehicle){
        System.out.print(vehicle.getClass().getSimpleName()+":\n Has gas: "+vehicle.has_gas()+
                "\n Number of Passengers: "+vehicle.set_num_of_passengers()+
                "\n Number of wheels: "+vehicle.set_num_of_wheels()+"\n");
    }
}
```
# 2b) Use a different design pattern for this solution.

Answer : For the different solution , I would use *Simple factory pattern* . Because , a interface is given to build two types of
object like Car and Plane. This types of scenario will be a perfect match with *Simple factory pattern* . And we would be able to change 
the value of the object on the fly.

Given Interface Vehicle
```
public interface Vehicle {
    int set_num_of_wheels();
    int set_num_of_passengers();
    boolean has_gas();
}
```

* Car class
```
import basic.Vehicle;

public class Car implements Vehicle {
    int num_of_wheels,num_of_passengers;
    boolean has_gas;
    public Car(int num_of_passengers, int num_of_wheels, boolean has_gas){
        this.num_of_passengers = num_of_passengers;
        this.num_of_wheels = num_of_wheels;
        this.has_gas = has_gas;
    }
    @Override
    public int set_num_of_wheels() {
        return num_of_wheels;
    }

    @Override
    public int set_num_of_passengers() {
        return num_of_passengers;
    }

    @Override
    public boolean has_gas() {
        return has_gas;
    }
}
```
* Plane class

```
import basic.Vehicle;

public class Plane implements Vehicle {

    int num_of_wheels,num_of_passengers;
    boolean has_gas;
    public Plane(int num_of_passengers, int num_of_wheels, boolean has_gas){
        this.num_of_passengers = num_of_passengers;
        this.num_of_wheels = num_of_wheels;
        this.has_gas = has_gas;
    }
    @Override
    public int set_num_of_wheels() {
        return num_of_wheels;
    }

    @Override
    public int set_num_of_passengers() {
        return num_of_passengers;
    }

    @Override
    public boolean has_gas() {
        return has_gas;
    }
}
```

* Factory class
```
import basic.Vehicle;

public class VehicleFactory {
    public static Vehicle createCar ( int num_of_wheels,int num_of_passengers,
            boolean has_gas){
        return new Car(num_of_passengers, num_of_wheels, has_gas);
    }

    public static Vehicle createPlane ( int num_of_wheels,int num_of_passengers,
                                      boolean has_gas){
        return new Plane(num_of_passengers, num_of_wheels, has_gas);
    }
}
```

Main entry point to test the pattern

```
import factory.VehicleFactory;

public class Main {

    public static void main(String[] args) {
     
        Vehicle car = VehicleFactory.createCar(4,6,true);
        printValue(car);

        Vehicle plane = VehicleFactory.createPlane(6,200,false);
        printValue(plane);
    }

    private static void printValue(Vehicle vehicle){
        System.out.print(vehicle.getClass().getSimpleName()+":\n Has gas: "+vehicle.has_gas()+
                "\n Number of Passengers: "+vehicle.set_num_of_passengers()+
                "\n Number of wheels: "+vehicle.set_num_of_wheels()+"\n");
    }
}
```
