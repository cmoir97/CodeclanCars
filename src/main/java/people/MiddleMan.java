package people;

import vehicle.Vehicle;

import java.util.ArrayList;

public class MiddleMan extends Person {

    private ArrayList<Vehicle> vehicles;

    public MiddleMan(String name, int wallet){
        super(name, wallet);
        vehicles = new ArrayList<Vehicle>();
    }

    public int getNumberOfVehicles(){
        return this.vehicles.size();
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }

    public void sellVehicleToCustomer(Vehicle vehicle, Customer customer){
        if (customer.getVehicleWanted() == vehicle && customer.hasEnoughForMiddleman(vehicle)) {
            removeVehicle(vehicle);
            customer.removeFromWallet(((int)(vehicle.getValue() * 1.1)));
            addToWallet(((int)(vehicle.getValue() * 1.1)));
        }
    }

    public boolean hasEnoughMoney(Vehicle vehicle){
        return getWallet() >= vehicle.getValue();
    }

}
