package assg2;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class MainApp 
{
    public static void main(String[] args)
    {
        // DECLARE VARIABLE AND LIST FOR CUSTOMER
        String menuChoice;
        ArrayList<Customer> customerList = new ArrayList<>();
        
        do 
        {
            // MENU CHOICE
            menuChoice = JOptionPane.showInputDialog(
                                        "Welcome to the theme park program.\n" +
                                        "Please, choose a menu.\n" +
                                        "1) Add a customer.\n" +
                                        "2) Add a ticket.\n" +
                                        "3) Add a rental item.\n" +
                                        "4) Display all customers\n" +
                                        "5) Display all tickets purchased by a customer.\n" +
                                        "6) Display all rental items for a customer.\n" +
                                        "7) Display all rides only.\n" +
                                        "8) Display all equipment only.\n" +
                                        "9) Pay the due.\n" +
                                        "10) Exit the program");
            
            switch (menuChoice)
            {
                case "1": // 1) Add a customer
                {
                    String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                    String customerContactNo = JOptionPane.showInputDialog("Please, input a customer contact number.");
                    String paymentChoice;
                    String customerPaymentMethod=null;
                    do
                    {
                        // Payment choice
                        paymentChoice = JOptionPane.showInputDialog("Please, input a customer payment method.\n"
                            + "1) Cash\n"
                            + "2) Visa\n"
                            + "3) Master\n"
                            + "4) Online Payment");
                        
                        if(paymentChoice.equals("1"))
                            customerPaymentMethod = "Cash";
                        else if(paymentChoice.equals("2"))
                            customerPaymentMethod = "Visa";
                        else if(paymentChoice.equals("3"))
                            customerPaymentMethod = "Master";
                        else if(paymentChoice.equals("4"))
                            customerPaymentMethod = "Online";
                        else // VALIDATION FOR WRONG INPUT
                        {
                            JOptionPane.showMessageDialog(null, "Your input is wrong!\nPlease input again.");
                        }
                    } while((paymentChoice.equals("1")||paymentChoice.equals("2")||paymentChoice.equals("3")||paymentChoice.equals("4"))==false);
                    
                    try
                    {
                        double customerBalance = Double.parseDouble(JOptionPane.showInputDialog("Please, input a customer's balance : "));
                        
                        // MAKE A CUSTOMER OBJECT
                        Customer customer = new Customer();
                        customer.setName(customerName);
                        customer.setContactNo(customerContactNo);
                        customer.setPaymentMethod(customerPaymentMethod);
                        customer.setBalance(customerBalance);

                        // ADD A CUSTOMER OBJECT TO THE CUSTOMER LIST
                        customerList.add(customer);

                        // SHOW A SUCCESSFUL MESSAGE
                        JOptionPane.showMessageDialog(null, "A customer is successfully added!");
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                }
                
                case "2": // ADD A TICKET
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                        for(int i=0; i<customerList.size(); i++)
                        {
                            if(customerList.get(i).getName().equals(customerName))
                            {
                                try
                                {
                                    int numOfAdultTicket = Integer.parseInt(JOptionPane.showInputDialog("Please, input the number of adult ticket."));
                                    int numOfChildTicket = Integer.parseInt(JOptionPane.showInputDialog("Please, input the number of child ticket."));
                                    int numOfSeniorCitizenTicket = Integer.parseInt(JOptionPane.showInputDialog("Please, input the number of senior citizen ticket."));
                                    Ticket ticket = new Ticket(numOfAdultTicket, numOfChildTicket, numOfSeniorCitizenTicket);
                                    customerList.get(i).setTicket(ticket);
                                    JOptionPane.showMessageDialog(null, "The ticket is successfully added!");
                                }
                                catch (Exception e)
                                {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                        }
                    }
                    break;
                }
                
                case "3": // ADD A RENTAL ITEM
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                        for(int i=0; i<customerList.size(); i++)
                        {
                            if(customerList.get(i).getName().equals(customerName))
                            {
                                String rentalChoice, rideChoice, myKadChoice, goKartChoice, equipmentChoice, lockerChoice;
                                String tubeChoice, surfBoardChoice;
                                
                                do
                                {
                                    rentalChoice = JOptionPane.showInputDialog("Please, choose a rental item.\n"
                                            + "1) Rides\n"
                                            + "2) Locker\n"
                                            + "3) Equipment\n"
                                            + "4) Exit");
                                    
                                    if(rentalChoice.equals("1")) // RENTAL ITEM (RIDES)
                                    {
                                        rideChoice = JOptionPane.showInputDialog("Please, choose a ride.\n"
                                                + "1) Bungy Jump\n"
                                                + "2) Go Kart");
                                        
                                        while((rideChoice.equals("1")||rideChoice.equals("2"))==false)
                                        {
                                            rideChoice = JOptionPane.showInputDialog("Your input is wrong!\n"
                                                + "Please, choose a ride.\n"
                                                + "1) Bungy Jump\n"
                                                + "2) Go Kart");
                                        }
                                        
                                        if(rideChoice.equals("1")) // BUNGY JUMP
                                        {
                                            boolean myKad = false;
                                            myKadChoice = JOptionPane.showInputDialog("Do you have MyKad?"
                                                    + "1) Yes"
                                                    + "2) No");
                                            
                                            while((myKadChoice.equals("1")||myKadChoice.equals("2"))==false)
                                            {
                                                myKadChoice = JOptionPane.showInputDialog("Your input is wrong!\n"
                                                    + "Do you have MyKad?"
                                                    + "1) Yes"
                                                    + "2) No");
                                            }
                                            
                                            if(myKadChoice.equals("1")) // IF A CUSTOMER HAS MyKad
                                            {
                                                myKad = true;
                                            }
                                            else if(myKadChoice.equals("2")) // IF A CUSTOMER DOES NOT HAVE MyKad
                                            {
                                                myKad = false;
                                            }
                                            
                                            // USE POLYMORPHISM TO MAKE AN OBJECT
                                            RentalItem bungyJump = new BungyJump("Rides", "Bungy Jump", myKad);
                                            
                                            // STORE INTO THE CUSTOMER LIST'S RENTAL ITEM LIST
                                            customerList.get(i).getRental_item_details_list().add(bungyJump);
                                        }
                                        else if(rideChoice.equals("2")) // GO KART
                                        {
                                            String goKartType = null;
                                            goKartChoice = JOptionPane.showInputDialog("Which type do you want?"
                                                    + "1) Single"
                                                    + "2) Double");
                                            
                                            while((goKartChoice.equals("1")||goKartChoice.equals("2"))==false)
                                            {
                                                goKartChoice = JOptionPane.showInputDialog("Your input is wrong!\n"
                                                    + "Which type do you want?"
                                                    + "1) Single"
                                                    + "2) Double");
                                            }
                                            
                                            if(goKartChoice.equals("1")) // IF A CUSTOMER CHOOSES SINGLE
                                            {
                                                goKartType = "single";
                                            }
                                            else if(goKartChoice.equals("2")) // IF A CUSTOMER CHOOSES DOUBLE
                                            {
                                                goKartType = "double";
                                            }
                                            
                                            // USE POLYMORPHISM TO MAKE AN OBJECT
                                            RentalItem goKart = new GoKart("Rides", "Bungy Jump", goKartType);
                                            
                                            // STORE INTO THE CUSTOMER LIST'S RENTAL ITEM LIST
                                            customerList.get(i).getRental_item_details_list().add(goKart);
                                        }
                                    }
                                    else if(rentalChoice.equals("2")) // RENTAL ITEM (LOCKER)
                                    {
                                        String lockerType = null;
                                        lockerChoice = JOptionPane.showInputDialog("Which type do you want?\n"
                                                + "1) Standard\n"
                                                + "2) Luggage");
                                        
                                        while((lockerChoice.equals("1")||lockerChoice.equals("2"))==false)
                                        {
                                            lockerChoice = JOptionPane.showInputDialog("Your input is wrong!\n"
                                                + "Which type do you want?\n"
                                                + "1) Standard\n"
                                                + "2) Luggage");
                                        }
                                        
                                        if(lockerChoice.equals("1")) // Standard Type (LOCKER)
                                        {
                                            lockerType = "standard";
                                        }
                                        else if(lockerChoice.equals("2")) // Luggage Type (LOCKER)
                                        {
                                            lockerType = "luggage";
                                        }
                                        
                                        // USE POLYMORPHISM TO MAKE AN OBJECT
                                        RentalItem locker = new Locker("Locker", lockerType);
                                            
                                        // STORE INTO THE CUSTOMER LIST'S RENTAL ITEM LIST
                                        customerList.get(i).getRental_item_details_list().add(locker);
                                    }
                                    else if(rentalChoice.equals("3")) // RENTAL ITEM (EQUIPMENT)
                                    {
                                        try
                                        {
                                            int discRate = Integer.parseInt(JOptionPane.showInputDialog("Please, input a discount rate."));
                                            
                                            equipmentChoice = JOptionPane.showInputDialog("Please, choose equipment.\n"
                                                    + "1) Tube\n"
                                                    + "2) Surf Board");

                                            while((equipmentChoice.equals("1")||equipmentChoice.equals("2"))==false)
                                            {
                                                equipmentChoice = JOptionPane.showInputDialog("Your input is wrong!\n"
                                                    + "Please, choose equipment.\n"
                                                    + "1) Tube\n"
                                                    + "2) Surf Board");
                                            }

                                            if(equipmentChoice.equals("1")) // TUBE (EQUIPMENT)
                                            {
                                                String tubeSize = null;

                                                tubeChoice = JOptionPane.showInputDialog("Please, choose tube size.\n"
                                                        + "1) Single\n"
                                                        + "2) Double");

                                                while((tubeChoice.equals("1")||tubeChoice.equals("2"))==false)
                                                {
                                                    tubeChoice = JOptionPane.showInputDialog("Your input is wrong!\n"
                                                        + "Please, choose tube size.\n"
                                                        + "1) Single\n"
                                                        + "2) Double");
                                                }

                                                if(tubeChoice.equals("1")) // TUBE SIZE IS SINGLE
                                                {
                                                    tubeSize = "single";
                                                }
                                                else if(tubeChoice.equals("2")) // TUBE SIZE IS DOUBLE
                                                {
                                                    tubeSize = "double";
                                                }

                                                // USE POLYMORPHISM TO MAKE AN OBJECT
                                                RentalItem tube = new Tube("Equipment", "Tube", discRate, tubeSize);

                                                // STORE INTO THE CUSTOMER LIST'S RENTAL ITEM LIST
                                                customerList.get(i).getRental_item_details_list().add(tube);
                                            }
                                            else if(equipmentChoice.equals("2")) // SURF BOARD (EQUIPMENT)
                                            {
                                                boolean designBoard = false;
                                                
                                                surfBoardChoice = JOptionPane.showInputDialog("Does it surf board have a design board?\n"
                                                        + "1) Yes\n"
                                                        + "2) No");
                                                
                                                while((surfBoardChoice.equals("1")||surfBoardChoice.equals("2"))==false)
                                                {
                                                    surfBoardChoice = JOptionPane.showInputDialog("Your input is wrong!\n"
                                                        + "Does it surf board have a design board?\n"
                                                        + "1) Yes\n"
                                                        + "2) No");
                                                }
                                                
                                                if(surfBoardChoice.equals("1")) // IF HAVING DESIGN BOARD
                                                {
                                                    designBoard = true;
                                                }
                                                else if(surfBoardChoice.equals("2")) // IF NOT HAVING DESIGN BOARD
                                                {
                                                    designBoard = false;
                                                }
                                                
                                                // USE POLYMORPHISM TO MAKE AN OBJECT
                                                RentalItem surfBoard = new SurfBoard("Equipment", "Surf Board", discRate, designBoard);

                                                // STORE INTO THE CUSTOMER LIST'S RENTAL ITEM LIST
                                                customerList.get(i).getRental_item_details_list().add(surfBoard);
                                            }
                                        }
                                        catch (Exception e)
                                        {
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                        }
                                        
                                    }
                                    else if(rentalChoice.equals("4")) // EXIT
                                    {
                                        JOptionPane.showMessageDialog(null, "Going to the main menu.");
                                    }
                                    else // VALIDATION FOR WRONG INPUT
                                    {
                                        JOptionPane.showMessageDialog(null, "Your input is wrong!");
                                    }
                                }
                                while(rentalChoice.equals("4"));
                            }
                        }
                    }
                    break;
                }
                
                case "4": // DISPLAY ALL CUSTOMERS
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String display = "";
                        
                        for(int i=0; i<customerList.size(); i++)
                        {
                            display += customerList.get(i).toString();
                        }
                        JOptionPane.showMessageDialog(null, display);
                    }
                    break;
                }
                
                case "5": // Display all tickets purchased by a customer
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                        for(int i=0; i<customerList.size(); i++)
                        {
                            if(customerList.get(i).getName().equals(customerName))
                            {
                                JOptionPane.showMessageDialog(null, customerList.get(i).getTicket().toString());
                            }
                        }
                    }
                    break;
                }
                
                case "6": // Display all rental items for a customer
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                        String result = "";
                        for(int i=0; i<customerList.size(); i++)
                        {
                            if(customerList.get(i).getName().equals(customerName))
                            {
                                for(int j=0; j<customerList.get(i).getRental_item_details_list().size(); j++)
                                {
                                    // INSTANCEOF AND DOWNCAST
                                    if(customerList.get(i).getRental_item_details_list().get(j) instanceof BungyJump)
                                    {
                                        BungyJump bungyJump = (BungyJump) customerList.get(i).getRental_item_details_list().get(j);
                                        result += bungyJump.toString();
                                    }
                                    else if(customerList.get(i).getRental_item_details_list().get(j) instanceof GoKart)
                                    {
                                        GoKart goKart = (GoKart) customerList.get(i).getRental_item_details_list().get(j);
                                        result += goKart.toString();
                                    }
                                    else if(customerList.get(i).getRental_item_details_list().get(j) instanceof Locker)
                                    {
                                        Locker locker = (Locker) customerList.get(i).getRental_item_details_list().get(j);
                                        result += locker.toString();
                                    }
                                    else if(customerList.get(i).getRental_item_details_list().get(j) instanceof Tube)
                                    {
                                        Tube tube = (Tube) customerList.get(i).getRental_item_details_list().get(j);
                                        result += tube.toString();
                                    }
                                    else if(customerList.get(i).getRental_item_details_list().get(j) instanceof SurfBoard)
                                    {
                                        SurfBoard surfBoard = (SurfBoard) customerList.get(i).getRental_item_details_list().get(j);
                                        result += surfBoard.toString();
                                    }
                                }
                                JOptionPane.showMessageDialog(null, result);
                            }
                        }
                    }
                    break;
                }
                
                case "7": // Display all rides only
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                        String result = "";
                        for(int i=0; i<customerList.size(); i++)
                        {
                            if(customerList.get(i).getName().equals(customerName))
                            {
                                for(int j=0; j<customerList.get(i).getRental_item_details_list().size(); j++)
                                {
                                    // INSTANCEOF AND DOWNCAST
                                    if(customerList.get(i).getRental_item_details_list().get(j) instanceof BungyJump)
                                    {
                                        BungyJump bungyJump = (BungyJump) customerList.get(i).getRental_item_details_list().get(j);
                                        result += bungyJump.toString();
                                    }
                                    else if(customerList.get(i).getRental_item_details_list().get(j) instanceof GoKart)
                                    {
                                        GoKart goKart = (GoKart) customerList.get(i).getRental_item_details_list().get(j);
                                        result += goKart.toString();
                                    }
                                }
                                JOptionPane.showMessageDialog(null, result);
                            }
                        }
                    }
                    break;
                }
                
                case "8": // Display all equipment only
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                        String result = "";
                        for(int i=0; i<customerList.size(); i++)
                        {
                            if(customerList.get(i).getName().equals(customerName))
                            {
                                for(int j=0; j<customerList.get(i).getRental_item_details_list().size(); j++)
                                {
                                    // INSTANCEOF AND DOWNCAST
                                    if(customerList.get(i).getRental_item_details_list().get(j) instanceof Tube)
                                    {
                                        Tube tube = (Tube) customerList.get(i).getRental_item_details_list().get(j);
                                        result += tube.toString();
                                    }
                                    else if(customerList.get(i).getRental_item_details_list().get(j) instanceof SurfBoard)
                                    {
                                        SurfBoard surfBoard = (SurfBoard) customerList.get(i).getRental_item_details_list().get(j);
                                        result += surfBoard.toString();
                                    }
                                }
                                JOptionPane.showMessageDialog(null, result);
                            }
                        }
                    }
                    break;
                }
                
                case "9": // MAKE A PAYMENT
                {
                    if(customerList.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You have to add a customer first!");
                    }
                    else
                    {
                        String customerName = JOptionPane.showInputDialog("Please, input a customer name.");
                        for(int i=0; i<customerList.size(); i++)
                        {
                            if(customerList.get(i).getName().equals(customerName))
                            {
                                try
                                {
                                    double payment = Double.parseDouble(JOptionPane.showInputDialog(
                                            customerList.get(i).getPaymentDetails() + 
                                            "\n\nHow much do you want to pay?"));
                                    
                                    while(payment < 1)
                                    {
                                        payment = Double.parseDouble(JOptionPane.showInputDialog(
                                            customerList.get(i).getPaymentDetails() + 
                                            "\n\nYou cannot pay below RM1, how much do you want to pay?"));
                                    }
                                    
                                    customerList.get(i).setPayment(payment);
                                    JOptionPane.showMessageDialog(null, "PAID SUCCESSFULLY!"
                                            + "\n\n" + customerList.get(i).printReceipt());
                                }
                                catch (Exception e)
                                {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                            }
                        }
                    }
                    break;
                }
                
                case "10": // EXIT THE PROGRAM
                {
                    JOptionPane.showMessageDialog(null, "Thank you for using our program.\nEnd the program.");
                    break;
                }
                
                default: // VALIDATION FOR WRONG INPUT
                {
                    JOptionPane.showMessageDialog(null, "Your input is wrong!");
                }
            }
        } while(!menuChoice.equals("10"));
    }
}