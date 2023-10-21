/**
 * The CarPark class represents a car park that contains a list of parking slots.
 * It provides methods to add parking slots, get the list of parking slots, get the capacity of the car park,
 * get a specific parking slot, get a list of cars by their ID, make, model, and year, and filter cars based on multiple criteria.
 * @author Suchat Tangjarukij (103511058)
 * @version 1.0.0
 */
import java.util.ArrayList;
public class CarPark
{
    /**
     * The list of parking slots in the car park.
     */
    private ArrayList<ParkingSlot> parkingSlots;
    
    /**
     * Constructs a new CarPark object with an empty list of parking slots.
     */
    public CarPark()
    {
        parkingSlots = new ArrayList<ParkingSlot>();
    }

    /**
     * Adds a parking slot to the car park if it does not already exist.
     * @param parkingSlot the parking slot to add
     * @return true if the parking slot was added successfully, false otherwise
     */
    public boolean addParkingSlot(ParkingSlot parkingSlot){
        for(ParkingSlot slot : parkingSlots){
            if(slot.getId().equals(parkingSlot.getId())){
                return false;
            }
        }
        parkingSlots.add(parkingSlot);
        return true;
    }
    
    /**
     * Gets the list of parking slots in the car park.
     * @return the list of parking slots
     */
    public ArrayList<ParkingSlot> getParkingSlots(){
        return parkingSlots;
    }
    
    /**
     * Gets the capacity of the car park.
     * @return the number of parking slots in the car park
     */
    public int getCapacity(){
        return parkingSlots.size();
    }
    
    /**
     * Gets a specific parking slot in the car park by its index.
     * @param i the index of the parking slot to get
     * @return the parking slot at the specified index
     */
    public ParkingSlot getSlot(int i){
        return parkingSlots.get(i);
    }
    
    /**
     * Gets the list of parking slots in the car park.
     * @return the list of parking slots
     */
    public ArrayList <ParkingSlot> getSlots(){
        return parkingSlots;
    }
   
    /**
     * Returns a string representation of the car park, which is a comma-separated list of parking slot IDs.
     * @return a string representation of the car park
     */
    public String toString(){
        ArrayList<String> parkingSlotIds = new ArrayList<String>();
        for(ParkingSlot parkingSlot : parkingSlots){
            parkingSlotIds.add(parkingSlot.getId());
        }
        return String.join(",", parkingSlotIds);
    }
    
    /**
     * Gets a list of cars in the car park by their ID.
     * @param id the ID of the cars to get
     * @return the list of cars with the specified ID
     */
    public ArrayList<Car> getCarsById(String id){
        ArrayList<Car> cars = new ArrayList<Car>();
        for(ParkingSlot parkingSlot : parkingSlots){
            Car car = parkingSlot.getCar();
            if(car != null && car.getId().equals(id)){
                cars.add(car);
            }
        }
        return cars;
    }
    
    /**
     * Gets a list of cars in the car park by their make.
     * @param make the make of the cars to get
     * @return the list of cars with the specified make
     */
    public ArrayList<Car> getCarsByMake(String make){
        ArrayList<Car> cars = new ArrayList<Car>();
        for(ParkingSlot parkingSlot : parkingSlots){
            Car car = parkingSlot.getCar();
            if(car != null && car.getMake().equals(make)){
                cars.add(car);
            }
        }
        return cars;
    }
    
    /**
     * Gets a list of cars in the car park by their model.
     * @param model the model of the cars to get
     * @return the list of cars with the specified model
     */
    public ArrayList<Car> getCarsByModel(String model){
        ArrayList<Car> cars = new ArrayList<Car>();
        for(ParkingSlot parkingSlot : parkingSlots){
            Car car = parkingSlot.getCar();
            if(car != null && car.getModel().equals(model)){
                cars.add(car);
            }
        }
        return cars;
    }
    
    /**
     * Gets a list of cars in the car park by their year.
     * @param year the year of the cars to get
     * @return the list of cars with the specified year
     */
    public ArrayList<Car> getCarsByYear(String year){
        ArrayList<Car> cars = new ArrayList<Car>();
        for(ParkingSlot parkingSlot : parkingSlots){
            Car car = parkingSlot.getCar();
            if(car != null && car.getYear() == year){
                cars.add(car);
            }
        }
        return cars;
    }
    
    /**
     * Gets a list of cars in the car park that match the specified criteria.
     * @param id the ID of the cars to get
     * @param make the make of the cars to get
     * @param model the model of the cars to get
     * @param year the year of the cars to get
     * @param union true if the list should include cars that match any of the criteria, false if it should include only cars that match all of the criteria
     * @return the list of cars that match the specified criteria
     */
    public ArrayList<Car> getCarsFilter(String id, String make,String model,String year,boolean union){
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<Car> carsById = getCarsById(id);
        ArrayList<Car> carsByMake = getCarsByMake(make);
        ArrayList<Car> carsByModel = getCarsByModel(model);
        ArrayList<Car> carsByYear = getCarsByYear(year);
        if(union){
            cars.addAll(carsByMake);
            cars.addAll(carsByModel);
            cars.addAll(carsByYear);
        }else{
            for(Car car : carsByMake){
                if(carsByModel.contains(car) && carsByYear.contains(car)){
                    cars.add(car);
                }
            }
        }
        return cars;
    }
    
    /**
     * Gets a list of cars in the car park that match the specified criteria.
     * @param carFilterStruct a CarFilter object containing the criteria to match
     * @return the list of cars that match the specified criteria
     */
    public ArrayList<Car> getCarsFilter(CarFilter carFilterStruct){
        return getCarsFilter(
            carFilterStruct.getId(),
            carFilterStruct.getMake(),
            carFilterStruct.getModel(),
            carFilterStruct.getYear(),
            carFilterStruct.isUnion());
    }
    
    /**
     * Gets a list of parking slots in the specified list that match the specified ID.
     * @param parkingSlots the list of parking slots to search
     * @param id the ID of the parking slots to get
     * @return the list of parking slots with the specified ID
     */
    public static ArrayList<ParkingSlot> getParkingSlotsById( ArrayList<ParkingSlot> parkingSlots,String id){
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.getId().toLowerCase() == id.toLowerCase()){
                parkingSlots.add(parkingSlot);
            }
        }
        return parkingSlots;
    }

}
