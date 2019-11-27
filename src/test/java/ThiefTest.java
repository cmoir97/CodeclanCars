import enums.Make;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import people.MiddleMan;
import people.Thief;
import vehicle.Car;

import static org.junit.Assert.*;

public class ThiefTest {

    Thief thief;
    Car car;
    Customer customer;

    @Before
    public void before(){
        car = new Car("Herbie", "Beetle", Make.VW, 100);
        thief = new Thief("Freezer", 5, 100);
        customer = new Customer("Irati", car, 200);
    }

    @Test
    public void canGetName(){
        assertEquals("Freezer", thief.getName());
    }



    @Test
    public void stolenVehiclesStartsEmpty(){
        assertEquals(0, thief.numberOfStolenVehicles());
    }

    @Test
    public void canAddCar(){
        thief.addVehicle(car);
        assertEquals(1, thief.numberOfStolenVehicles());
    }


    @Test
    public void canStealVehicle(){
        thief.stealVehicle(car);
        assertEquals(1, thief.numberOfStolenVehicles());
    }

    @Test
    public void canGetSkill(){
        assertEquals(5, thief.getSkill());
    }

    @Test
    public void canIncreaseSkill(){
        thief.increaseSkill();
        assertEquals(6, thief.getSkill());
    }

    @Test
    public void isSkillfulEnough(){
        assertTrue(thief.vehicleStealable(car));
    }

    @Test
    public void isNotSkillfulEnough(){
       Car car2 = new Car("Herbie", "Beetle", Make.PORSCHE, 100);
        assertFalse(thief.vehicleStealable(car2));
    }

    @Test
    public void cannotStealCar(){
        Car car2 = new Car("Herbie", "Beetle", Make.PORSCHE, 100);
        thief.stealVehicle(car2);
        assertEquals(0, thief.numberOfStolenVehicles());

    }

    @Test
    public void canSellVehicleToMiddleman() {
        MiddleMan middleman = new MiddleMan("Zsolt", 200);
        thief.stealVehicle(car);
        thief.sellVehicle(middleman, car);
        assertEquals(1, middleman.getNumberOfVehicles());
        assertEquals(0, thief.numberOfStolenVehicles());
        assertEquals(200, thief.getWallet());
        assertEquals(100, middleman.getWallet());
    }

    @Test
    public void canSellVehicleToCustomer() {
        thief.stealVehicle(car);
        thief.sellVehicle(customer, car);
        assertEquals(0, thief.numberOfStolenVehicles());
        assertEquals(200, thief.getWallet());
        assertEquals(100, customer.getWallet());
    }

    @Test
    public void canEmptyWallet(){
        thief.emptyWallet();
        assertEquals(0, thief.getWallet());
    }

    @Test
    public void canEmptyVehicleList(){
        thief.stealVehicle(car);
        thief.stealVehicle(car);
        thief.emptyVehicleList();
        assertEquals(0, thief.numberOfStolenVehicles());
    }

    @Test
    public void CustomerHasNotEnoughMoney(){
        customer.removeFromWallet(150);
        thief.stealVehicle(car);
        thief.sellVehicle(customer, car);
        assertEquals(1, thief.numberOfStolenVehicles());
        assertEquals(100, thief.getWallet());
        assertEquals(50, customer.getWallet());
    }

    @Test
    public void cannotSellToMiddleman() {
        MiddleMan middleman = new MiddleMan("Zsolt", 200);
        middleman.removeFromWallet(150);
        thief.stealVehicle(car);
        thief.sellVehicle(middleman, car);
        assertEquals(0, middleman.getNumberOfVehicles());
        assertEquals(1, thief.numberOfStolenVehicles());
        assertEquals(100, thief.getWallet());
        assertEquals(50, middleman.getWallet());
    }

}
