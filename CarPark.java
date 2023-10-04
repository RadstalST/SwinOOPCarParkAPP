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
   
    public String toString(){
        ArrayList<String> parkingSlotIds = new ArrayList<String>();
        for(ParkingSlot parkingSlot : parkingSlots){
            parkingSlotIds.add(parkingSlot.getId());
        }
        return String.join(",", parkingSlotIds);
    }
   
}
