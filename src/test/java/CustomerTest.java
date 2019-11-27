import enums.Make;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import vehicle.Car;
import vehicle.Vehicle;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    Car car;

    @Before
    public void before(){
        car = new Car("Herbie", "Beetle", Make.VW, 100);
        customer = new Customer("Irati", car, 200);
    }

    @Test
    public void canGetName(){
        assertEquals("Irati", customer.getName());
    }

    @Test
    public void canGetVehicleWanted(){
        assertEquals(car, customer.getVehicleWanted());
    }
}
