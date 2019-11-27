import enums.Make;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import people.Customer;
import people.MiddleMan;
import vehicle.Car;

import static org.junit.Assert.*;

public class MiddleManTest {

    MiddleMan middleMan;
    Car car;
    Customer customer;

    @Before
    public void before(){
        middleMan = new MiddleMan("Zsolt", 200);
        car = new Car("Herbie", "Beetle", Make.VW, 100);
        customer = new Customer("Irati", car, 200);
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
        middleMan.addVehicle(car);
        middleMan.sellVehicleToCustomer(car, customer);
        assertEquals(0, middleMan.getNumberOfVehicles());
        assertEquals(310, middleMan.getWallet());
        assertEquals(90, customer.getWallet());
    }

    @Test
    public void customerHasNotEnoughMoney() {
        customer.removeFromWallet(150);
        middleMan.addVehicle(car);
        middleMan.sellVehicleToCustomer(car, customer);
        assertEquals(1, middleMan.getNumberOfVehicles());
        assertEquals(200, middleMan.getWallet());
        assertEquals(50, customer.getWallet());
    }

    @Test
    public void hasEnoughMoney(){
        assertTrue(middleMan.hasEnoughMoney(car));
    }

    @Test
    public void hasNotEnough(){
        middleMan.removeFromWallet(150);
        assertFalse(middleMan.hasEnoughMoney(car));
    }
}
