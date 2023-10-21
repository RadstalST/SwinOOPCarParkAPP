
import java.util.Date;
import java.util.ArrayList;
/**
 * This class represents a parking slot in a car park.
 * @author Suchat Tangjarukij (103511058)
 * @version 1.0.0
 */
public class ParkingSlot
{
    private Car carInSlot; // The car currently parked in this slot
    private String id; // The unique identifier for this slot
    private Date createdTimestamp; // The timestamp when this slot was created
    private Date updateTimestamp; // The timestamp when this slot was last updated

    /**
     * Constructs a new ParkingSlot object with the given ID.
     * @param id The ID for this slot (must match the pattern [A-Za-z]{1}[0-9]{3})
     * @throws IllegalArgumentException if the given ID does not match the required pattern
     */
    public ParkingSlot(String id)
    {
        this.id = id.toUpperCase();
        createdTimestamp = new Date();
        updateTimestamp = new Date();
        if(!id.matches("[A-Za-z]{1}[0-9]{3}")){
            throw new IllegalArgumentException("id is [A-Za-z]{1}[0-9]{3}");
        }
    }

    /**
     * Constructs a new ParkingSlot object with an empty ID.
     */
    public ParkingSlot(){
        this.id = "";
        createdTimestamp = new Date();
        updateTimestamp = new Date();
    }

    /**
     * Returns the ID for this slot.
     * @return The ID for this slot
     */
    public String getId(){
        return id;
    }

    /**
     * Sets the ID for this slot.
     * @param id The new ID for this slot (must match the pattern [A-Za-z]{1}[0-9]{3})
     * @throws IllegalArgumentException if the given ID does not match the required pattern
     */
    public void setId(String id){
        this.id = id.toUpperCase();
    }

    /**
     * Parks a car in this slot.
     * @param car The car to park in this slot
     */
    public void parkCar(Car car){
        updateTimestampHandler();
        this.carInSlot = car;
    }

    /**
     * Removes the car from this slot.
     * @return The car that was parked in this slot
     */
    public Car removeCar(){
        updateTimestampHandler();
        Car car = carInSlot;
        this.carInSlot = null;
        return car;
    }

    /**
     * Returns the car currently parked in this slot.
     * @return The car currently parked in this slot
     */
    public Car getCar(){
        return carInSlot;
    }

    /**
     * Returns the timestamp when this slot was created.
     * @return The timestamp when this slot was created
     */
    public Date getCreatedTimestamp(){
        return createdTimestamp;
    }

    /**
     * Returns the timestamp when this slot was last updated.
     * @return The timestamp when this slot was last updated
     */
    public Date getUpdateTimestamp(){
        return updateTimestamp;
    }

    /**
     * Updates the timestamp for this slot to the current time.
     */
    public void updateTimestampHandler(){
        updateTimestamp = new Date();
    }

    /**
     * Generates a list of n ParkingSlot objects with random IDs.
     * @param n The number of ParkingSlot objects to generate
     * @return A list of n ParkingSlot objects with random IDs
     */
    public static ArrayList<ParkingSlot> generateParkingSlot(int n){
        ArrayList<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();
        for(int i = 0; i < n; i++){
            //random
            parkingSlots.add(new ParkingSlot(
                "%c%03d".formatted(
                    'G',
                    (int)(Math.random() * 1000)
                )
                ));
        }
        return parkingSlots;
    }
}
