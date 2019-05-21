package com.tkb.pattern;
import com.tkb.pattern.template.Plane;
import com.tkb.pattern.template.Vehicle;
import com.tkb.pattern.template.Car;

public class Main {

    public static void main(String[] args) {

        Vehicle car = new Car();
       System.out.print(car.buildVehicle());

        Vehicle plane = new Plane();
        System.out.print(plane.buildVehicle());
      /*  VehicleBuilder vehicleBuilder = new VehicleBuilder();
        Vehicle car = vehicleBuilder.buildCar();
        System.out.print("Car:\n Has gas: "+car.has_gas()+
                "\n Number of Passengers: "+car.set_num_of_passengers()+
                "\n Number of wheels: "+car.set_num_of_wheels());


        Vehicle plane = vehicleBuilder.buildPlane();
        System.out.print("\nPlane:\n Has gas: "+plane.has_gas()+
                "\n Number of Passengers: "+plane.set_num_of_passengers()+
                "\n Number of wheels: "+plane.set_num_of_wheels()); */
    }
}
