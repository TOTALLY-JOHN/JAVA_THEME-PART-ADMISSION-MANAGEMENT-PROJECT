package assg2;

public abstract class Equipment extends RentalItem
{
    private String name;
    private int discRate;
    
    public Equipment()
    {
        super();
        name = null;
        discRate = 0;
    }
    
    public Equipment(String description, String name, int discRate)
    {
        super(description);
        this.name = name;
        this.discRate = discRate;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setDiscRate(int discRate)
    {
        this.discRate = discRate;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getDiscRate()
    {
        return discRate;
    }
    
    @Override
    public abstract double calcTotalRentals();
    
    @Override
    public String toString()
    {
        return "DESCRIPTION : " + getDescription() +
                "\nNAME : " + name +
                "\nDISCOUNT RATE : " + discRate +"\n";
    }
}
