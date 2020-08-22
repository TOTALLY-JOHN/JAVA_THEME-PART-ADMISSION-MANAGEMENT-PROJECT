package assg2;

public class Locker extends RentalItem
{
    private String type;
    
    public Locker()
    {
        super();
        type = null;
    }
    
    public Locker(String description, String type)
    {
        super(description);
        this.type = type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getType()
    {
        return type;
    }
    
    @Override
    public double calcTotalRentals()
    {
        if(type.equalsIgnoreCase("standard"))
            return 10.0; // That one we have to ask lecturer (She did not write the value price)
        else if(type.equalsIgnoreCase("luggage"))
            return 10.0; // That one we have to ask lecturer (She did not write the value price)
        
        return 0.0;
    }
    
    @Override
    public String toString()
    {
        return "DESCRIPTION : " + getDescription() +
               "\nTYPE : " + type +
               "\nCALCULATION : RM" + calcTotalRentals() +"\n";
    }
}
