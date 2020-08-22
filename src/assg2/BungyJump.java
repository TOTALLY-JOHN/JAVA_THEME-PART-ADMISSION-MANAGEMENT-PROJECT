package assg2;

public class BungyJump extends Rides
{
    private boolean myKad;
    
    public BungyJump()
    {
        super();
        myKad = false;
    }
    
    public BungyJump(String description, String name, boolean myKad)
    {
        super(description, name);
        this.myKad = myKad;
    }
    
    public void setMyKad(boolean myKad)
    {
        this.myKad = myKad;
    }
    
    public boolean getMyKad()
    {
        return myKad;
    }
    
    @Override
    public double calcTotalRentals()
    {
        // IF A PERSON HAS A MYKAD
        if (myKad)
            return 85.00;
        
        // OTHERWISE
        return 147.00;
    }
    
    @Override
    public String toString()
    {
        String result = "DESCRIPTION : " + getDescription() +
                "\nRIDE NAME : " + getName();
        if(myKad)
            result += "\nTHIS CUSTOMER HAS MyKad.";
        else
            result += "\nTHIS CUSTOMER DOES NOT HAVE MyKad.";
        result += "\nCALCULATION : RM" + calcTotalRentals() + "\n";
        return result;
    }
}
