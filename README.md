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

# Q3. Write a video player application with ‘Play’, ‘Forward’ , ‘Rewind’ functionalities. Please write pseudocode for this program and explain the design pattern you will use to develop these three functionalities.

Answer: 

I think *Facade design pattern* can be used to build this entire application. Sometimes it seems that *Command Pattern* would be more suited as the play/pause functionality is under the same button. But Facade will be more suited here than Command pattern.

The sudo code is given bellow.

* activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/txtDisplay"
        android:layout_width="257dp"
        android:layout_height="50dp"
        android:text="This is a player!"
        android:gravity="center"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.13" />

    <Button
        android:id="@+id/btnPlay"
        android:layout_width="53dp"
        android:layout_height="45dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="48dp"
        android:layout_marginEnd="8dp"
        android:background="@android:color/transparent"
        android:drawableTop="@drawable/play"
        app:layout_constraintEnd_toStartOf="@+id/btnForward"
        app:layout_constraintHorizontal_bias="0.495"
        app:layout_constraintStart_toEndOf="@+id/btnBack"
        app:layout_constraintTop_toBottomOf="@+id/txtDisplay" />

    <Button
        android:id="@+id/btnBack"
        android:layout_width="59dp"
        android:layout_height="42dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="48dp"
        android:background="@android:color/transparent"
        android:drawableTop="@drawable/rewind"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtDisplay" />

    <Button
        android:id="@+id/btnForward"
        android:layout_width="65dp"
        android:layout_height="44dp"
        android:layout_marginTop="48dp"
        android:layout_marginEnd="16dp"
        android:background="@android:color/transparent"
        android:drawableTop="@drawable/forward"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtDisplay" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

* PlayerFunction interface.

```
public interface PlayerFunction {
    boolean hasExternalStorage();
    String getVideoPath();
    int getVideoSize();
}
```

* PlayerInterface

```
public interface PlayerInterface {
    void play();
    void pause();
    void forward();
    void rewind();
}
```
* Update view interface

```
public interface Update {
    void update(String value);
}
```
Constants class for constant values

```
public class Constants {
    public static String PLAY_TAG = "Play";
    public static String PAUSE_TAG = "Pause";

    public static String PLAY = "Playing...";
    public static String PAUSE = "Paused...";
    public static String REWIND = "Rewind...";
    public static String FORWARD = "Forward...";

}
```

* Player class

```
public class Player implements PlayerFunction{
    @Override
    public boolean hasExternalStorage() {
        return false;
    }

    @Override
    public String getVideoPath() {
        return null;
    }

    @Override
    public int getVideoSize() {
        return 0;
    }
}
```
* PlayerFacade class

```
public class PlayerFacade implements PlayerInterface{
    protected  Player player;
    Update update;
    public PlayerFacade(Player player, Update update){
        this.player = player;
        this.update = update;
    }

    @Override
    public void play() {
        player.getVideoPath();
        player.getVideoSize();
        player.hasExternalStorage();
        update.update(Constants.PLAY);
    }

    @Override
    public void pause() {
        player.getVideoPath();
        update.update(Constants.PAUSE);

    }

    @Override
    public void forward() {
        player.getVideoPath();
        update.update(Constants.FORWARD);

    }

    @Override
    public void rewind() {
        player.getVideoPath();
        update.update(Constants.REWIND);
    }
}
```

* MainActivity is the entry point of the programm

```
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Update{

    Button btnPlay,btnBack,btnForward;
    TextView txtDisplay;
    PlayerInterface player;
    Drawable pauseDrawable,playDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization() {
        btnBack = findViewById(R.id.btnBack);
        btnForward = findViewById(R.id.btnForward);
        btnPlay = findViewById(R.id.btnPlay);

        txtDisplay = findViewById(R.id.txtDisplay);

        btnPlay.setOnClickListener(this);
        btnForward.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        setTag(Constants.PLAY_TAG);
        player = new PlayerFacade(new Player(),this);

        pauseDrawable =  ContextCompat.getDrawable(this, R.drawable.pause);
        playDrawable =  ContextCompat.getDrawable(this, R.drawable.play);

        changeImage(playDrawable);

    }

    @Override
    public void update(String value) {
        txtDisplay.setText(value);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnBack:
                player.rewind();
                break;
            case R.id.btnForward:
                player.forward();
                break;
            case R.id.btnPlay:
                if (btnPlay.getTag().equals(Constants.PLAY_TAG)){
                    setTag(Constants.PAUSE_TAG);
                    player.play();
                    changeImage(pauseDrawable);
                }else {
                    setTag(Constants.PLAY_TAG);
                    player.pause();
                    changeImage(playDrawable);
                }
                break;
        }
    }

    private void setTag(String tag){
        btnPlay.setTag(tag);
    }

    private void changeImage(Drawable img){
        btnPlay.setCompoundDrawablesWithIntrinsicBounds(null, img , null, null);
    }
}
```
