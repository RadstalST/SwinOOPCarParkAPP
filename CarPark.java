/**
 * This class represents a Car Park that contains a list of ParkingSlots.
 */
import java.util.ArrayList;
public class CarPark
{
    // instance variables - replace the example below with your own
    private ArrayList<ParkingSlot> parkingSlots;
    public CarPark()
    {
        parkingSlots = new ArrayList<ParkingSlot>();
    }

    
    public boolean addParkingSlot(ParkingSlot parkingSlot){
        for(ParkingSlot slot : parkingSlots){
            if(slot.getId().equals(parkingSlot.getId())){
                return false;
            }
        }
        parkingSlots.add(parkingSlot);
        return true;
    }
    public ArrayList<ParkingSlot> getParkingSlots(){
        return parkingSlots;
    }
    public int getCapacity(){
        return parkingSlots.size();
    }
    public ParkingSlot getSlot(int i){
        return parkingSlots.get(i);
    }
    public ArrayList <ParkingSlot> getSlots(){
        return parkingSlots;
    }
   
    public String toString(){
        ArrayList<String> parkingSlotIds = new ArrayList<String>();
        for(ParkingSlot parkingSlot : parkingSlots){
            parkingSlotIds.add(parkingSlot.getId());
        }
        return String.join(",", parkingSlotIds);
    }
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
    public ArrayList<Car> getCarsFilter(CarFilter carFilterStruct){
        return getCarsFilter(
            carFilterStruct.getId(),
            carFilterStruct.getMake(),
            carFilterStruct.getModel(),
            carFilterStruct.getYear(),
            carFilterStruct.isUnion());
    }
    public static ArrayList<ParkingSlot> getParkingSlotsById( ArrayList<ParkingSlot> parkingSlots,String id){
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.getId().toLowerCase() == id.toLowerCase()){
                parkingSlots.add(parkingSlot);
            }
        }
        return parkingSlots;
    }

}
