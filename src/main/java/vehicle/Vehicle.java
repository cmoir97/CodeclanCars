package vehicle;

import behaviours.IDrive;
import enums.Make;

public abstract class Vehicle implements IDrive {
    private String name;
    private String model;
    private Make make;
    private int value;

    public Vehicle(String name, String model, Make make, int value){
        this.name = name;
        this.model = model;
        this.make = make;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public String getModel(){
        return this.model;
    }

    public int getValue(){
        return this.value;
    }

    public Make getMake(){
        return this.make;
    }


}
