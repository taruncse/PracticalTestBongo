package basic;

public class VehicleProvider {
    public Vehicle getCar(){
        return new Car();
    }

    public Vehicle getPlane(){
        return new Plane();
    }
}
