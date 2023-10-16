
import java.util.Date;
import java.util.ArrayList;
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
        // if(!id.matches("[A-Za-z]{1}[0-9]{4}")){
        //     throw new IllegalArgumentException("id is [A-Za-z]{1}[0-9]{4}");
        // }
    }

    private void updateTimestampHandler(){
        updateTimestamp = new Date();
    }
    public void setId(String id){
        this.id = id;
        updateTimestampHandler();
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
        return """
        Id:\t\t%s
        make:\t\t%s
        model:\t\t%s
        year:\t\t%s
        createdTimestamp:\t%s
        updateTimestamp:\t%s
        """.formatted(id,make,model,year,createdTimestamp,updateTimestamp);
        
    }

    public static ArrayList<Car> generateCar(int n){
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<String> possibleMakes = new ArrayList<String>();
        possibleMakes.add("Toyota");
        possibleMakes.add("Honda");
        possibleMakes.add("Nissan");
        possibleMakes.add("Mazda");
        possibleMakes.add("Mitsubishi");
        ArrayList<String> possibleModels = new ArrayList<String>();
        possibleModels.add("Camry");
        possibleModels.add("Corolla");
        possibleModels.add("Prius");
        possibleModels.add("Civic");

        for(int i = 0; i < n; i++){
            //randomly
            cars.add(new Car(
                "%c%04d".formatted(
                    (char)((int)(Math.random() * 26) + 65),
                    (int)(Math.random() * 10000)
                ),
                possibleMakes.get((int)(Math.random() * possibleMakes.size())),
                possibleModels.get((int)(Math.random() * possibleModels.size())),
                "2021"
                
                ));
        }
        return cars;
    }
}
