
import java.util.Date;
import java.util.ArrayList;
/**
 * The Car class represents a car object with its attributes such as id, make, model, year, createdTimestamp, and updateTimestamp.
 * @author Suchat Tangjarukij (103511058)
 * @version 1.0.0
 */
public class Car
{
    // The id of the car.
    private String id;
    // The make of the car.
    private String make;
    // The model of the car.
    private String model;
    // The year of the car.
    private String year;
    // The timestamp when the car object is created.
    private Date createdTimestamp;
    // The timestamp when the car object is updated.
    private Date updateTimestamp;

    /**
     * Constructs a Car object with the given id, make, model, and year.
     * @param id The id of the car.
     * @param make The make of the car.
     * @param model The model of the car.
     * @param year The year of the car.
     * @throws IllegalArgumentException if the id does not match the pattern "[A-Za-z]{1}[0-9]{4}".
     */
    public Car(String id , String make, String model, String year)
    {
        // Initializes the createdTimestamp and updateTimestamp to the current date and time.
        this.createdTimestamp = new Date();
        this.updateTimestamp = new Date();
        // Sets the id, make, model, and year of the car object.
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        // Throws an IllegalArgumentException if the id does not match the pattern "[A-Za-z]{1}[0-9]{4}".
        if(!id.matches("[A-Za-z]{1}[0-9]{4}")){
            throw new IllegalArgumentException("id is [A-Za-z]{1}[0-9]{4}");
        }
    }

    /**
     * Updates the updateTimestamp to the current date and time.
     */
    private void updateTimestampHandler(){
        updateTimestamp = new Date();
    }

    /**
     * Sets the id of the car object and updates the updateTimestamp to the current date and time.
     * @param id The id of the car.
     */
    public void setId(String id){
        this.id = id;
        updateTimestampHandler();
    }

    /**
     * Sets the make of the car object and updates the updateTimestamp to the current date and time.
     * @param make The make of the car.
     */
    public void setMake(String make){
        this.make = make;
        updateTimestampHandler();
    }

    /**
     * Sets the model of the car object and updates the updateTimestamp to the current date and time.
     * @param model The model of the car.
     */
    public void setModel(String model){
        this.model = model;
        updateTimestampHandler();
    }

    /**
     * Sets the year of the car object and updates the updateTimestamp to the current date and time.
     * @param year The year of the car.
     */
    public void setYear(String year){
        this.year = year;
        updateTimestampHandler();
    }

    /**
     * Returns the id of the car object.
     * @return The id of the car.
     */
    public String getId(){
        return id;
    }

    /**
     * Returns the make of the car object.
     * @return The make of the car.
     */
    public String getMake(){
        return make;
    }

    /**
     * Returns the model of the car object.
     * @return The model of the car.
     */
    public String getModel(){
        return model;
    }

    /**
     * Returns the year of the car object.
     * @return The year of the car.
     */
    public String getYear(){
        return year;
    }

    /**
     * Returns the createdTimestamp of the car object.
     * @return The createdTimestamp of the car.
     */
    public Date getCreatedTimestamp(){
        return createdTimestamp;
    }

    /**
     * Returns the updateTimestamp of the car object.
     * @return The updateTimestamp of the car.
     */
    public Date getUpdateTimestamp(){
        return updateTimestamp;
    }

    /**
     * Returns a string representation of the car object.
     * @return A string representation of the car object.
     */
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

    /**
     * Generates an ArrayList of Car objects with the given number of cars.
     * @param n The number of cars to generate.
     * @return An ArrayList of Car objects.
     */
    public static ArrayList<Car> generateCar(int n){
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<String> possibleMakes = new ArrayList<String>();
        ArrayList<String> possibleModels = new ArrayList<String>();

        // Adds possible makes of the car.
        possibleMakes.add("Toyota");
        possibleMakes.add("Honda");
        possibleMakes.add("Nissan");
        possibleMakes.add("Mazda");
        possibleMakes.add("Mitsubishi");
        // Adds possible models of the car.
        possibleModels.add("Camry");
        possibleModels.add("Corolla");
        possibleModels.add("Prius");
        possibleModels.add("Civic");

        // Generates n number of cars with random id, make, model, and year.
        for(int i = 0; i < n; i++){
            //randomly
            cars.add(new Car(
                "%c%04d".formatted(
                    'G',
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
