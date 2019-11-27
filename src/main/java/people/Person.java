package people;

import vehicle.Car;

public abstract class Person {

    private String name;
    private int wallet;

    public Person(String name, int wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName(){
        return this.name;
    }

    public int getWallet(){
        return this.wallet;
    }

    public void addToWallet(int amount){
        this.wallet += amount;
    }

    public void removeFromWallet(int amount){
        this.wallet -= amount;
    }
}
