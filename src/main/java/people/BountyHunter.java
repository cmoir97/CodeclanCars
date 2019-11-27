package people;

public class BountyHunter extends Person {

    private Thief thiefHunted;

    public BountyHunter(String name, int wallet, Thief thiefHunted){
        super(name, wallet);
        this.thiefHunted = thiefHunted;
    }

    public Thief getThiefHunted(){
        return this.thiefHunted;
    }

    public void catchCriminal(){
        this.addToWallet(thiefHunted.getWallet());
        thiefHunted.emptyWallet();
        thiefHunted.emptyVehicleList();
    }
}
