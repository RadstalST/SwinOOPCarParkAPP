public class CarFilter extends Car
{
    // instance variables - replace the example below with your own
    
    // private String carIdFilter = "";
    // private String carMakeFilter= "";
    // private String carModelFilter= "";
    // private String carYearFilter= "";
    private boolean isUnion = true;
    /**
     * Constructor for objects of class CarFilter
     */
    public CarFilter()
    {
        super("A0000","","","");
    }

    public void clear(){
        super.setId("");
        super.setMake("");
        super.setModel("");
        super.setYear("");
        isUnion = true;
    }
    public boolean isFiltering(){
        return !super.getId().equals("") || !super.getMake().equals("") || !super.getModel().equals("") || !super.getYear().equals("");
    }
   
    public String toString(){
        return "CarFilter: " + super.toString() + " isUnion: " + isUnion;
    }
    public boolean isUnion(){
        return isUnion;
    }
}
