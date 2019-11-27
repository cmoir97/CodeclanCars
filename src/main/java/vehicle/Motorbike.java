package vehicle;

import enums.Make;

public class Motorbike extends Vehicle {

    public Motorbike(String name, String model, Make make, int value){
        super(name, model, make, value);
    }

    public String drive(){
        return "Broom Broom?";
    }
}
