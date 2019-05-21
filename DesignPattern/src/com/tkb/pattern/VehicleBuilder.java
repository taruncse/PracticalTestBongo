package com.tkb.pattern;

public class VehicleBuilder {
    public Vehicle buildCar(){
        Vehicle car = new Car();
        car.set_num_of_passengers();
        car.set_num_of_wheels();
        car.has_gas();
        return car;
    }

    public Vehicle buildPlane(){
        Vehicle plane = new Plane();
        plane.set_num_of_passengers();
        plane.set_num_of_wheels();
        plane.has_gas();
        return plane;
    }
}
