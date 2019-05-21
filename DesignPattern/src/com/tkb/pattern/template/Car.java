package com.tkb.pattern.template;


public class Car extends Vehicle {
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
        return false;
    }
}
