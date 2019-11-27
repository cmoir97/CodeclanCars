import enums.Make;
import org.junit.Before;
import org.junit.Test;
import vehicle.Car;

import static org.junit.Assert.assertEquals;

public class CarTest {

    Car car;

    @Before
    public void before(){
        car = new Car("Herbie", "Beetle", Make.VW, 100);
    }

    @Test
    public void canGetName(){
        assertEquals("Herbie", car.getName());
    }

    @Test
    public void canGetModel(){
        assertEquals("Beetle", car.getModel());
    }

    @Test
    public void canGetMake(){
        assertEquals(Make.VW, car.getMake());
    }

    @Test
    public void canGetValue(){
        assertEquals(100, car.getValue());
    }

    @Test
    public void canDrive(){
        assertEquals("Vroom Vroom?", car.drive());
    }
}
