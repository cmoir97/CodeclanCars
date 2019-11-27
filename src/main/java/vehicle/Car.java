package vehicle;

import enums.Make;

public class Car extends Vehicle {

    public Car(String name, String model, Make make, int value){
        super(name, model, make, value);
    }

    public String drive(){
        return "Vroom Vroom?";
    }
}
