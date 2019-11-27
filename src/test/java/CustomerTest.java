import enums.Make;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import vehicle.Car;
import vehicle.Vehicle;

import static org.junit.Assert.*;

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

    @Test
    public void hasEnoughForMiddleman(){
        assertTrue(customer.hasEnoughForMiddleman(car));
    }

    @Test
    public void hasEnoughForThief(){
        assertTrue(customer.hasEnoughForThief(car));
    }

    @Test
    public void doesNotHaveEnoughForMiddleman(){
        customer.removeFromWallet(150);
        assertFalse(customer.hasEnoughForMiddleman(car));
    }

    @Test
    public void doesNotHaveEnoughForThief(){
        customer.removeFromWallet(150);
        assertFalse(customer.hasEnoughForThief(car));
    }
}
