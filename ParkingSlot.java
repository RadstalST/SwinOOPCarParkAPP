
import java.util.Date;

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
}
