import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("ABC123", "Toyota", "Camry", 2010);
    }

    @AfterEach
    public void tearDown() {
        car = null;
    }

    @Test
    public void testGetLicensePlate() {
        assertEquals("ABC123", car.getLicensePlate());
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
        assertEquals(2010, car.getYear());
    }

    @Test
    public void testToString() {
        String expected = "License Plate: ABC123\nMake: Toyota\nModel: Camry\nYear: 2010";
        assertEquals(expected, car.toString());
    }
}