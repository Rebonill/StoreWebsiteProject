import java.util.*;

public class CustomerMenu{
  ItemStock IS = new ItemStock(); 
  Scanner input = new Scanner(System.in);
  boolean bool = true;
  boolean kG = true;
  public CustomerMenu(){
    
  }

  public void customerMenu(){
    int response = customerOptions();
    while(kG){
      if(response == 1){
        computerHardware();  
        kG = false; 
      }
      else if(response == 3){
        kG = false;
      }
      else{
        //continue;
      }
    }
  } 

  public int customerOptions(){
    System.out.println("What would you like to do today?");
    System.out.println("1) Buy Computer HardWare.");
    System.out.println("2) See Billing History");
    System.out.println("3) Exit");
    String choice = input.nextLine();
    int Choice = Integer.parseInt(choice);
    return Choice;
  }

  public void computerHardware(){
    int c = hardwareOptions();
    //while(bool){
    //  c = hardwareOptions();
      if(c == 0){
        System.out.println("This where we will send to checkout class");
        System.out.println("Is there anything else you would like to add to your cart?");
      }  
      /*else if(c == 1){
        System.out.println("This where we will send to checkout class");
        System.out.println("Is there anything else you would like to add to your cart?");
      }
      else if(c == 2){
        System.out.println("Check out and bills show");
      }
      else{
       System.out.println("Not a Menu Option Try Again");
       c = hardwareOptions(); 
      }*/
      
    //} 
  }
  public int hardwareOptions(){
    System.out.println("Here Are Our Hardware Options.");
    System.out.println("0) GPU(Graphics Processing Unit");
    System.out.println("1) CPU (Central Processor Unit");
    System.out.println("2) Checkout");
    String Response = input.nextLine();
    int res = Integer.parseInt(Response);
    return res;
  }
  
}


