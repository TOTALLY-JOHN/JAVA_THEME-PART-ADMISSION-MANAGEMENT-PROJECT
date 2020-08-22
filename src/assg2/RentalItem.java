package assg2;

// SUPERCLASS
public abstract class RentalItem 
{
    private String description;
    
    // DEFAULT CONSTRUCTOR
    public RentalItem()
    {
        description = null;
    }
    
    // NON-DEFAULT-CONSTRUCTOR
    public RentalItem(String description)
    {
        this.description = description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public abstract double calcTotalRentals();
    
    @Override
    public String toString()
    {
        return "DESCRIPTION : " + description;
    }
}
