import java.util.*;
import java.io.*;
public class CustomerMenu{
  Checkout Co = new Checkout();
  Scanner input = new Scanner(System.in);
  String list = "";
  public String List = "";
  boolean bool = true;
  boolean keepGoing = true;
  
  public void customerMenu(){
    int response = customerOptions();
    while(keepGoing){
      if(response == 1){
        computerHardware();  
        keepGoing = false; 
      }//end if statement
      else if(response == 2){
        if(list == ""){
          System.out.println("Please Register For An Account With Our Website To View Your Billing History");
          response = customerOptions();
        }
        else{
          System.out.println(list);
          response = customerOptions(); 
        }
      }//end else if statement
      else if(response == 3){
        keepGoing = false;
      }//end else if statement
      else{
        System.out.println("Not a Menu Option please choose again");
        response = customerOptions();
      }//end else statement
    }//end while loop
  }//end customerMenu 

  public int customerOptions(){
    System.out.println("\n|What would you like to do today?|\n");
    System.out.println("1) |Buy Computer HardWare|");
    System.out.println("2) |See Billing History|");
    System.out.println("3) |Exit|");
    try{   
      String choice = input.nextLine();
      System.out.println();
      int Choice = Integer.parseInt(choice);
      return Choice;
    }catch (NumberFormatException e){
       System.out.println("Please Enter A Number");
    }catch (Exception e){
       System.out.println(e.getMessage());
    }//end try 
    return 0;
  }//end custoemrOptions

  public void computerHardware(){
    System.out.println("|Here Is A List Of Our Computer Hardware And Prices|\n");
    Co.itemList();
    System.out.println("\n|What Would You Like to Buy?|"+"\n");
    int choice = hardwareOptions();
    while(bool){
      if(choice == 0){
        if(Co.getStock(choice)==0){
          System.out.println("|We Apologize But This Item Is Out Of Stock|");
          stockWrite("GPU Out Of Stock Needs Restocking");
          System.out.println("|Would You like To Choose A Different Product|"+"\n");
          choice = hardwareOptions();
        }//end if statement
        else{
          Co.setcheckOutList(choice);
          System.out.println("\nItem added to Cart");
          System.out.println("Is there anything else you would like to add to your cart?"+"\n");
          Co.decreaseStock(choice);
          choice = hardwareOptions();
        }//end else
      }//end if statement
      else if(choice == 1){
        if(Co.getStock(choice)==0){
          System.out.println("|We Apologize But This Item Is Out Of Stock|");
          stockWrite("CPU Out Of Stock Needs Restocking");
          System.out.println("|Would You like To Choose A Different Product|"+"\n");
          choice = hardwareOptions();
        }//end else if statement
        else{
          Co.setcheckOutList(choice);
          System.out.println("\nItem added to Cart");
          System.out.println("Is there anything else you would like to add to your cart?"+"\n");
          Co.decreaseStock(choice);
          choice = hardwareOptions();
        }//end else
      }//end else if statement
      else if(choice == 2){
        if(Co.getStock(choice)==0){
          System.out.println("|We Apologize But This Item Is Out Of Stock|");
          stockWrite("RAM Out Of Stock Needs Restocking");
          System.out.println("|Would You like To Choose A Different Product|"+"\n");
          choice = hardwareOptions();
        }//end else if statement
        else{
          Co.setcheckOutList(choice);
          System.out.println("\nItem added to Cart");
          System.out.println("Is there anything else you would like to add to your cart?"+"\n");
          Co.decreaseStock(choice);
          choice = hardwareOptions();
        }//end else
      }//end else if statement 
 
      else if(choice == 3){
        System.out.println("\n|Here Is Your Checkout List|\n");
        List = Co.getcheckoutList() +"Total Cost: \n" +"$" + Co.getTotalCost()+"\n";
        System.out.println(List);
        System.out.println("Thank You For Shopping at Techshop Please Come Again!!");
        Co.writeFile();
        bool = false;
      }//end else if
      else if(choice == 4){
        System.out.println("Thank You For Visiting TechShop. Please Come Again!!");
        bool = false;
      }//end else if
      else{
        System.out.println("Not a Menu Option Try Again");
        choice = hardwareOptions(); 
      }//end else
    }//end while loop 
  }//end computerHardware

  public int hardwareOptions(){
    System.out.println("0) |GPU (Graphics Processing Unit)|");
    System.out.println("1) |CPU (Central Processor Unit)|");
    System.out.println("2) |RAM (Random Access Memory)|");
    System.out.println("3) |Checkout|");
    System.out.println("4) |Exit/No Purchase|");
    try{
      String Response = input.nextLine();
      int res = Integer.parseInt(Response);
      return res;  
    }catch (NumberFormatException e){
       System.out.println("Please Enter A Number");
    }catch (Exception e){
       System.out.println(e.getMessage());
    }//end try 
    return 0;
  }//end hardwareOptions

  public void stockWrite(String Message){
    try{
      File file = new File("StockUpdate.dat");
      FileWriter fw = new FileWriter(file);
      PrintWriter pw = new PrintWriter(fw);
      pw.println(Message);
      pw.close();
    }//end try   
    catch(IOException e){
      System.out.println(e.getMessage());
    }//end catch
  }//end stockWrite  
}//
