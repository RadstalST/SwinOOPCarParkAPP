
import java.util.Date;
import java.util.ArrayList;
public class ParkingSlot
{
    private Car carInSlot;
    private String id; //[A-Za-z]{1}[0-9]{3}
    private Date createdTimestamp;
    private Date updateTimestamp;
    public ParkingSlot(String id)
    {
        this.id = id.toUpperCase();
        createdTimestamp = new Date();
        updateTimestamp = new Date();
        if(!id.matches("[A-Za-z]{1}[0-9]{3}")){
            throw new IllegalArgumentException("id is [A-Za-z]{1}[0-9]{3}");
        }
    }
    public String getId(){
        return id;
    }
    public void parkCar(Car car){
        updateTimestampHandler();
        this.carInSlot = car;
    }
    public Car removeCar(){
        updateTimestampHandler();
        Car car = carInSlot;
        this.carInSlot = null;
        return car;
    }
    public Car getCar(){
        return carInSlot;
    }
    public Date getCreatedTimestamp(){
        return createdTimestamp;
    }
    public Date getUpdateTimestamp(){
        return updateTimestamp;
    }
    public void updateTimestampHandler(){
        updateTimestamp = new Date();
    }
    public static ArrayList<ParkingSlot> generateParkingSlot(int n){
        ArrayList<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();
        for(int i = 0; i < n; i++){
            //random
            parkingSlots.add(new ParkingSlot(
                "%c%03d".formatted(
                    (char)(Math.random() * 26 + 'A'),
                    (int)(Math.random() * 1000)
                )
                ));
        }
        return parkingSlots;
    }
}
