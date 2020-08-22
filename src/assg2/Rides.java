package assg2;

public abstract class Rides extends RentalItem
{
    private String name;
    
    public Rides()
    {
        super();
        name = null;
    }
    
    public Rides(String description, String name)
    {
        super(description);
        this.name = name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public abstract double calcTotalRentals();
    
    @Override
    public String toString()
    {
        return "DESCRIPTION : " + getDescription() +
                "\nRIDE NAME : " + name;
    }
}
