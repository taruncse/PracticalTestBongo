package com.tkb.pattern.template;

public class Plane extends Vehicle {
    @Override
    public int set_num_of_wheels() {
        return 6;
    }

    @Override
    public int set_num_of_passengers() {
        return 100;
    }

    @Override
    public boolean has_gas() {
        return true;
    }
}
