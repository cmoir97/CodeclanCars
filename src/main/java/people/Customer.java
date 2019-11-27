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

    public boolean hasEnoughForMiddleman(Vehicle vehicle){
        return this.getWallet() >= (vehicle.getValue() * 1.1);
    }

    public boolean hasEnoughForThief(Vehicle vehicle){
        return this.getWallet() >= (vehicle.getValue());
    }
}
