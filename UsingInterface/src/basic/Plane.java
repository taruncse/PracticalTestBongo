package basic;

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
