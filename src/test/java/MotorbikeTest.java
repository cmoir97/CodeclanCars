import enums.Make;
import org.junit.Before;
import org.junit.Test;
import vehicle.Motorbike;

import static org.junit.Assert.assertEquals;

public class MotorbikeTest {

    Motorbike motorbike;

    @Before
    public void before(){
        motorbike = new Motorbike("Quin", "Harley", Make.HARLEYDAVIDSON, 100);
    }

    @Test
    public void canGetName(){
        assertEquals("Quin", motorbike.getName());
    }

    @Test
    public void canGetModel(){
        assertEquals("Harley", motorbike.getModel());
    }

    @Test
    public void canGetMake(){
        assertEquals(Make.HARLEYDAVIDSON, motorbike.getMake());
    }

    @Test
    public void canGetValue(){
        assertEquals(100, motorbike.getValue());
    }

    @Test
    public void canDrive(){
        assertEquals("Broom Broom?", motorbike.drive());
    }
}
