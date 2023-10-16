import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("A1233", "Toyota", "Camry", "2022");
    }

    @AfterEach
    public void tearDown() {
        car = null;
    }

    @Test
    public void testGetLicensePlate() {
        assertEquals("A1233", car.getId());
    }

    @Test
    public void testGetMake() {
        assertEquals("Toyota", car.getMake());
    }

    @Test
    public void testGetModel() {
        assertEquals("Camry", car.getModel());
    }

    @Test
    public void testGetYear() {
        assertEquals("2022", car.getYear());
    }  
}