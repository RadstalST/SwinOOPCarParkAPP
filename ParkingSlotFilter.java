
import java.util.Date;
import java.util.ArrayList;
public class ParkingSlotFilter extends ParkingSlot
{
     public ParkingSlotFilter()
    {
        super();
       
    }
    public void clear(){
        super.setId("");
       
    }
    public boolean isFiltering(){
        return !super.getId().equals("");
    }
}
