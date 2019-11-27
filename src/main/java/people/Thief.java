package people;

import vehicle.Vehicle;

import java.util.ArrayList;

public class Thief extends Person {

    private ArrayList<Vehicle> stolenVehicles;
    private int skill;

    public Thief(String name, int skill, int wallet){
        super(name, wallet);
        this.skill = skill;
        this.stolenVehicles = new ArrayList<Vehicle>();
    }

    public int numberOfStolenVehicles(){
        return this.stolenVehicles.size();
    }

    public int getSkill(){
        return this.skill;
    }


    public void increaseSkill(){
        this.skill ++;
    }

    public void addVehicle(Vehicle vehicle){
        this.stolenVehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.stolenVehicles.remove(vehicle);
    }

    public void stealVehicle(Vehicle vehicle){
        if (vehicleStealable(vehicle)) {
            addVehicle(vehicle);
        }
    }

    public boolean vehicleStealable(Vehicle vehicle){
        return getSkill() >= vehicle.getMake().getDifficulty();
    }

    public void sellVehicle(MiddleMan middleMan, Vehicle vehicle){
        middleMan.addVehicle(vehicle);
        this.addToWallet(vehicle.getValue());
        middleMan.removeFromWallet(vehicle.getValue());
        removeVehicle(vehicle);
    }

    public void sellVehicle(Customer customer, Vehicle vehicle){
        if (customer.getVehicleWanted() == vehicle) {
            removeVehicle(vehicle);
            customer.removeFromWallet(vehicle.getValue());
            addToWallet(vehicle.getValue());
        }
    }

    public void emptyWallet(){
        this.removeFromWallet(this.getWallet());
    }

    public void emptyVehicleList(){
        this.stolenVehicles.clear();
    }

}
