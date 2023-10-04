
import java.util.Date;
public class Car
{
    // instance variables - replace the example below with your own
    private String id;
    private String make;
    private String model;
    private String year;
    private Date createdTimestamp;
    private Date updateTimestamp;

    /**
     * Constructor for objects of class Car
     */
    public Car(String id , String make, String model, String year)
    {
        this.createdTimestamp = new Date();
        this.updateTimestamp = new Date();
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        if(!id.matches("[A-Za-z]{1}[0-9]{3}")){
            throw new IllegalArgumentException("id is [A-Za-z]{1}[0-9]{3}");
        }
    }

    private void updateTimestampHandler(){
        updateTimestamp = new Date();
    }
    public void setMake(String make){
        this.make = make;
        updateTimestampHandler();
    }
    public void setModel(String model){
        this.model = model;
        updateTimestampHandler();
    }
    public void setYear(String year){
        this.year = year;
        updateTimestampHandler();
    }
    public String getId(){
        return id;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public String getYear(){
        return year;
    }
    public Date getCreatedTimestamp(){
        return createdTimestamp;
    }
    public Date getUpdateTimestamp(){
        return updateTimestamp;
    }
    public String toString(){
        return "Car: " + id + " " + make + " " + model + " " + year + " " + createdTimestamp + " " + updateTimestamp;
    }
}
