import enums.Make;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import people.MiddleMan;
import vehicle.Car;

import static org.junit.Assert.assertEquals;

public class MiddleManTest {

    MiddleMan middleMan;
    Car car;

    @Before
    public void before(){
        middleMan = new MiddleMan("Zsolt", 200);
        car = new Car("Herbie", "Beetle", Make.VW, 100);
    }

    @Test
    public void canGetName(){
        assertEquals("Zsolt", middleMan.getName());
    }

    @Test
    public void canGetWallet(){
        assertEquals(200, middleMan.getWallet());
    }

    @Test
    public void vehicleListStartsEmpty(){
        assertEquals(0, middleMan.getNumberOfVehicles());
    }

    @Test
    public void canAddVehicle(){
        middleMan.addVehicle(car);
        assertEquals(1, middleMan.getNumberOfVehicles());
    }

    @Test
    public void canRemoveVehicle(){
        middleMan.addVehicle(car);
        middleMan.removeVehicle(car);
        assertEquals(0, middleMan.getNumberOfVehicles());
    }

    @Test
    public void canAddToWallet(){
        middleMan.addToWallet(10);
        assertEquals(210, middleMan.getWallet());
    }

    @Test
    public void canRemoveFromWallet(){
        middleMan.removeFromWallet(10);
        assertEquals(190, middleMan.getWallet());
    }

    @Test
    public void canSellVehicleToCustomer() {
        Customer customer = new Customer("Irati", car, 200);
        middleMan.addVehicle(car);
        middleMan.sellVehicleToCustomer(car, customer);
        assertEquals(0, middleMan.getNumberOfVehicles());
        assertEquals(310, middleMan.getWallet());
        assertEquals(90, customer.getWallet());
    }
}
