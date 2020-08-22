package assg2;

public class Ticket 
{
    private int numOfAdultTicket;
    private int numOfChildTicket;
    private int numOfSeniorCitizenTicket;
    private static final double ADULT_TICKET_PRICE = 202.00;
    private static final double CHILD_TICKET_PRICE = 170.00;
    private static final double SENIOR_CITIZEN_TICKET_PRICE = 150.00;
    
    // DEFAULT CONSTRUCTOR
    public Ticket()
    {
        numOfAdultTicket = 0;
        numOfChildTicket = 0;
        numOfSeniorCitizenTicket = 0;
    }
    
    // NON-DEFAULT CONSTRUCTOR
    public Ticket(int numOfAdultTicket, int numOfChildTicket, int numOfSeniorCitizenTicket)
    {
        this.numOfAdultTicket = numOfAdultTicket;
        this.numOfChildTicket = numOfChildTicket;
        this.numOfSeniorCitizenTicket = numOfSeniorCitizenTicket;
    }
    
    public void setNumOfAdultTicket(int numOfAdultTicket)
    {
        this.numOfAdultTicket = numOfAdultTicket;
    }
    
    public void setNumOfChildTicket(int numOfChildTicket)
    {
        this.numOfChildTicket = numOfChildTicket;
    }
    
    public void setNumOfSeniorCitizenTicket(int numOfSeniorCitizenTicket)
    {
        this.numOfSeniorCitizenTicket = numOfSeniorCitizenTicket;
    }
    
    public int getNumOfAdultTicket()
    {
        return numOfAdultTicket;
    }
    
    public int getNumOfChildTicket()
    {
       return numOfChildTicket;
    }
    
    public int getNumOfSeniorCitizenTicket()
    {
        return numOfSeniorCitizenTicket;
    }
    
    public double calculation()
    {
        return (numOfAdultTicket * ADULT_TICKET_PRICE) + 
                (numOfChildTicket * CHILD_TICKET_PRICE) +
                (numOfSeniorCitizenTicket * SENIOR_CITIZEN_TICKET_PRICE);
    }
    
    @Override
    public String toString()
    {
        return "THE NUMBER OF ADULT TICKET : " + numOfAdultTicket +
                "\nTHE NUMBER OF CHILD TICKET : " + numOfChildTicket +
                "\nTHE NUMBER OF SENIOR CITIZEN TICKET : " + numOfSeniorCitizenTicket;
    }
}
