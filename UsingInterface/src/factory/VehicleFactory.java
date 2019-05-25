package factory;

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
