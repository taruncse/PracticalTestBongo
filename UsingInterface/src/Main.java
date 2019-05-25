import basic.Vehicle;
import basic.VehicleProvider;
import factory.VehicleFactory;

public class Main {

    public static void main(String[] args) {
       /* VehicleProvider vehicleProvider = new VehicleProvider();

        Vehicle plane = vehicleProvider.getPlane();
        printValue(plane);

        Vehicle car = vehicleProvider.getCar();
        printValue(car);*/

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
