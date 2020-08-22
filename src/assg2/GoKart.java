package assg2;

public class GoKart extends Rides
{
    private String type;
    
    public GoKart()
    {
        super();
        type = null;
    }
    
    public GoKart(String description, String name, String type)
    {
        super(description, name);
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
        if(type.equalsIgnoreCase("single"))
            return 35.00;
        else if(type.equalsIgnoreCase("double"))
            return 40.00;
        
        return 0.0;
    }
    
    @Override
    public String toString()
    {
       return "DESCRIPTION : " + getDescription() +
                "\nRIDE NAME : " + getName() +
                "\nTYPE : " + type +
                "\nCALCULATION : RM" + calcTotalRentals() +"\n";
    }
}
