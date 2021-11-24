import java.util.*;

public class CustomerMenu{
  Checkout Co = new Checkout();
  Scanner input = new Scanner(System.in);
  ItemStock Is = new ItemStock();
  boolean bool = true;
  boolean keepGoing = true;
  public CustomerMenu(){
  //IS.writeFile(); 
  }

  public void customerMenu(){
    int response = customerOptions();
    while(keepGoing){
      if(response == 1){
        computerHardware();  
        keepGoing = false; 
      }
      else if(response == 3){
        keepGoing = false;
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
    int choice = hardwareOptions();
    while(bool){
      if(choice == 0){
        if(Is.getStock(choice)==0){
          System.out.println("We Apologize But This Item Is Out Of Stock");
          System.out.println("Would You like To Choose A Different Product"+"\n");
          choice = hardwareOptions();
        }
        else{
        Co.setcheckOutList(choice);
        System.out.println("Item added to Cart");
        System.out.println("Is there anything else you would like to add to your cart?"+"\n");
        Is.decreaseStock(choice);
        choice = hardwareOptions();
        }
      }  
      else if(choice == 1){
        if(Is.getStock(choice)==1){
          System.out.println("We Apologize But This Item Is Out Of Stock");
          System.out.println("Would You like To Choose A Different Product"+"\n");
          choice = hardwareOptions();
        }
        Co.setcheckOutList(choice);
        System.out.println("Is there anything else you would like to add to your cart?"+"\n");
        Is.decreaseStock(choice);
        choice = hardwareOptions();
      }
      else if(choice == 2){
       System.out.println("Check out and bills show");
       Co.getcheckoutList();
       Is.writeFile();
       bool = false;
      }
      else{
       System.out.println("Not a Menu Option Try Again");
       choice = hardwareOptions(); 
      }
      
    }//end while loop 
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


