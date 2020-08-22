package assg2;

import java.util.ArrayList;

public class Customer implements Payable
{
    private String name;
    private String contactNo;
    private String paymentMethod;
    private Ticket ticket;
    private double balance;
    private double payment;
    private double due;
    private ArrayList<RentalItem> rental_item_details_list = new ArrayList<>();
    
    // DEFAULT CONSTRUCTOR
    public Customer() 
    {
        name = null;
        contactNo = null;
        paymentMethod = null;
        ticket = null;
        rental_item_details_list = new ArrayList<>();
    }
    
    // NON-DEFAULT CONSTRUCTOR
    public Customer(String name, String contactNo, String paymentMethod, Ticket ticket, ArrayList<RentalItem> rental_item_details_list) 
    {
        this.name = name;
        this.contactNo = contactNo;
        this.paymentMethod = paymentMethod;
        this.ticket = ticket;
        this.rental_item_details_list = rental_item_details_list;
    }
    
    // MUTATORS
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setContactNo(String contactNo) 
    {
        this.contactNo = contactNo;
    }
    
    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }
    
    public void setTicket(Ticket ticket)
    {
        this.ticket = ticket;
    }
    
    public void setRental_item_details_list(ArrayList<RentalItem> rental_item_details_list)
    {
        this.rental_item_details_list = rental_item_details_list;
    }
    
    public void setBalance(double balance)
    {
        this.balance =  balance;
    }
    
    public void setPayment(double payment)
    {
        this.payment = payment;
        double total = 0.0;
        for(int i=0; i<rental_item_details_list.size(); i++)
        {
            // INSTANCEOF AND DOWNCAST
            if(rental_item_details_list.get(i) instanceof BungyJump)
            {
                BungyJump bungyJump = (BungyJump) rental_item_details_list.get(i);
                total += bungyJump.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof GoKart)
            {
                GoKart goKart = (GoKart) rental_item_details_list.get(i);
                total += goKart.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof Locker)
            {
                Locker locker = (Locker) rental_item_details_list.get(i);
                total += locker.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof Tube)
            {
                Tube tube = (Tube) rental_item_details_list.get(i);
                total += tube.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof SurfBoard)
            {
                SurfBoard surfBoard = (SurfBoard) rental_item_details_list.get(i);
                total += surfBoard.calcTotalRentals();
            }
        }
        due = total - payment;
        balance -= payment;
    }
    
    public void setDue(double due)
    {
        this.due = due;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getContactNo()
    {
        return contactNo;
    }
    
    public String getPaymentMethod()
    {
        return paymentMethod;
    }
    
    public Ticket getTicket()
    {
        return ticket;
    }
    
    public ArrayList<RentalItem> getRental_item_details_list()
    {
        return rental_item_details_list;
    }
    
    public double getPayment()
    {
        return payment;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public double getDue()
    {
        return due;
    }
    
    @Override
    public String getPaymentDetails()
    {
        double total = 0.0;
        for(int i=0; i<rental_item_details_list.size(); i++)
        {
            // INSTANCEOF AND DOWNCAST
            if(rental_item_details_list.get(i) instanceof BungyJump)
            {
                BungyJump bungyJump = (BungyJump) rental_item_details_list.get(i);
                total += bungyJump.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof GoKart)
            {
                GoKart goKart = (GoKart) rental_item_details_list.get(i);
                total += goKart.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof Locker)
            {
                Locker locker = (Locker) rental_item_details_list.get(i);
                total += locker.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof Tube)
            {
                Tube tube = (Tube) rental_item_details_list.get(i);
                total += tube.calcTotalRentals();
            }
            else if(rental_item_details_list.get(i) instanceof SurfBoard)
            {
                SurfBoard surfBoard = (SurfBoard) rental_item_details_list.get(i);
                total += surfBoard.calcTotalRentals();
            }
        }
        String message = "A TOTAL OF FEES YOU HAVE TO PAY : " + total + "\n";
        message += "YOUR PAYMENT : RM" + payment + "\n";
        message += "YOUR DUE : RM" + due + "\n";
        message += "YOUR BALANCE : RM" + balance;
        return message;
    }
    
    @Override
    public String printReceipt()
    {
        return "YOUR PAYMENT RECEIPT\n"
                + "YOU PAID RM" + payment + " FOR RENTAL ITEMS\n"
                + "YOUR CURRENT BALANCE : RM" + balance;
    }
    
    @Override
    public String toString()
    {
        String display = "";
        display += "CUSTOMER NAME : " + name + "\n"
                + "CUSTOMER CONTACT NUMBER : " + contactNo + "\n"
                + "CUSTOMER PAYMENT METHOD : " + paymentMethod + "\n";
        if(ticket!=null)
                display += "CUSTOMER TICKET INFORMATION : \n" + ticket.toString();
        
        if(!rental_item_details_list.isEmpty())
        {
            for(int i=0; i<rental_item_details_list.size(); i++)
            {
                // INSTANCEOF AND DOWNCAST
                if(rental_item_details_list.get(i) instanceof BungyJump)
                {
                    BungyJump bungyJump = (BungyJump) rental_item_details_list.get(i);
                    display += "\n" + bungyJump.toString() + "\n";
                }
                else if(rental_item_details_list.get(i) instanceof GoKart)
                {
                    GoKart goKart = (GoKart) rental_item_details_list.get(i);
                    display += "\n" + goKart.toString() + "\n";
                }
                else if(rental_item_details_list.get(i) instanceof Locker)
                {
                    Locker locker = (Locker) rental_item_details_list.get(i);
                    display += "\n" + locker.toString() + "\n";
                }
                else if(rental_item_details_list.get(i) instanceof Tube)
                {
                    Tube tube = (Tube) rental_item_details_list.get(i);
                    display += "\n" + tube.toString() + "\n";
                }
                else if(rental_item_details_list.get(i) instanceof SurfBoard)
                {
                    SurfBoard surfBoard = (SurfBoard) rental_item_details_list.get(i);
                    display += "\n" + surfBoard.toString() + "\n";
                }
            }
        }
        display += "\nPAYMENT DETAILS : " + getPaymentDetails() + "\n\n";
        return display;
    }
}
