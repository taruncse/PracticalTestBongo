package com.tkb.pattern.template;

public abstract class Vehicle {
    abstract int set_num_of_wheels();
    abstract int set_num_of_passengers();
    abstract boolean has_gas();

    public String buildVehicle() {
        String information = "\n Has gas: ";
        information += has_gas();
        information += "\n Number of Passengers: "+set_num_of_wheels();
        information += "\n Number of wheels: "+set_num_of_passengers();
        return information;
    }
}
