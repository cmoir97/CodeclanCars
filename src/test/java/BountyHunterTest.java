import enums.Make;
import org.junit.Before;
import org.junit.Test;
import people.BountyHunter;
import people.Thief;
import vehicle.Car;

import static org.junit.Assert.assertEquals;

public class BountyHunterTest {

    BountyHunter bountyHunter;
    Thief thief;
    Car car;

    @Before
    public void before(){
        thief = new Thief("Freezer", 5, 100);
        bountyHunter = new BountyHunter("Dog", 100, thief);
        car = new Car("Herbie", "Beetle", Make.VW, 100);
    }

    @Test
    public void canGetThiefHunted(){
        assertEquals(thief, bountyHunter.getThiefHunted());
    }

    @Test
    public void canCatchCriminal(){
        bountyHunter.catchCriminal();
        assertEquals(200, bountyHunter.getWallet());
        assertEquals(0, thief.getWallet());
        assertEquals(0, thief.numberOfStolenVehicles());
    }
}
