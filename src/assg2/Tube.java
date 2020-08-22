package assg2;

public class Tube extends Equipment
{
    private String size;
    
    public Tube()
    {
        super();
    }
    
    public Tube(String description, String name, int discRate, String size)
    {
        super(description, name, discRate);
        this.size = size;
    }
    
    public void setSize(String size)
    {
        this.size = size;
    }
    
    public String getSize()
    {
        return size;
    }
    
    @Override
    public double calcTotalRentals()
    {
        if(size.equalsIgnoreCase("single"))
            return 10 + (16.0 * ((100 - getDiscRate()) / 100));
        else if(size.equalsIgnoreCase("double"))
            return 20 + (25.0 * ((100 - getDiscRate()) / 100));
        
        return 0.0;
    }
    
    @Override
    public String toString()
    {
        return "DESCRIPTION : " + getDescription() +
                "\nNAME : " + getName() +
                "\nDISCOUNT RATE : " + getDiscRate() +
                "\nSIZE : " + size +
                "\nCALCULATION : RM" + calcTotalRentals() + "\n";
    }
}
