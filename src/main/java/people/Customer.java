package people;

import vehicle.Car;
import vehicle.Vehicle;

public class Customer extends Person {

    private Vehicle vehicleWanted;

    public Customer(String name, Vehicle vehicleWanted, int wallet){
        super(name, wallet);
        this.vehicleWanted = vehicleWanted;
    }


    public Vehicle getVehicleWanted() {
        return this.vehicleWanted;
    }
}
