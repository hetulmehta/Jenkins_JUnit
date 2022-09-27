import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    String make = "BMW"; 
    String model = "Civic"; 
    Car testCar = new Car(make, model); 
    

    @Test
    public void testMake(){
        System.out.println("Running Test 1!");
        Assertions.assertEquals("BMW", testCar.getMake(),"Expected vehicle make did not match actual vehicle make"); 
    }

    @Test 
    public void testModel(){
        System.out.println("Running Test 2!");
        Assertions.assertEquals("Civic",testCar.getModel(),"Expected vehicle model did not match actual vehicle model"); 
    }
    
}

