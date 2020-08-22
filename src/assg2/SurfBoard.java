package assg2;

public class SurfBoard extends Equipment
{
    private boolean designBoard;
    
    public SurfBoard()
    {
        super();
        designBoard = false;
    }
    
    public SurfBoard(String description, String name, int discRate, boolean designBoard)
    {
        super(description, name, discRate);
        this.designBoard = designBoard;
    }
    
    public void setDesignBoard(boolean designBoard)
    {
        this.designBoard = designBoard;
    }
    
    public boolean getDesignBoard()
    {
        return designBoard;
    }
    
    @Override
    public double calcTotalRentals()
    {
        // Miss did not write Design Board specification.
        if(designBoard)
            return 20+32.0;
        else
            return 20+32.0;
    }
    
    @Override
    public String toString()
    {
        String result = "DESCRIPTION : " + getDescription() +
                "\nNAME : " + getName() +
                "\nDISCOUNT RATE : " + getDiscRate();
        if(designBoard)
            result += "\nDESIGN BOARD : YES";
        else
            result += "\nDESIGN BOARD : NO";
        result += "\nCALCULATION : RM" + calcTotalRentals() +"\n";
        return result;
    }
}
