import java.util.*;

public class CustomerMenu{
  public String List = "";
  String list = "";
  Checkout Co = new Checkout();
  Scanner input = new Scanner(System.in);
  boolean bool = true;
  boolean keepGoing = true;
  public CustomerMenu(){
  }

  public void customerMenu(){
    int response = customerOptions();
    while(keepGoing){
      if(response == 1){
        computerHardware();  
        keepGoing = false; 
      }
      else if(response == 2){
       System.out.println(list);
       response = customerOptions(); 
      }
      else if(response == 3){
        keepGoing = false;
      }
      else{
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
    System.out.println("Here Is A List Of Our Hardware And Prices");
    Co.itemList();
    System.out.println("What Would You Like to Buy?"+"\n");
    int choice = hardwareOptions();
    while(bool){
      if(choice == 0){
        if(Co.getStock(choice)==0){
          System.out.println("We Apologize But This Item Is Out Of Stock");
          System.out.println("Would You like To Choose A Different Product"+"\n");
          choice = hardwareOptions();
        }
        else{
        Co.setcheckOutList(choice);
        System.out.println("Item added to Cart");
        System.out.println("Is there anything else you would like to add to your cart?"+"\n");
        Co.decreaseStock(choice);
        choice = hardwareOptions();
        }
      }  
      else if(choice == 1){
        if(Co.getStock(choice)==1){
          System.out.println("We Apologize But This Item Is Out Of Stock");
          System.out.println("Would You like To Choose A Different Product"+"\n");
          choice = hardwareOptions();
        }
        Co.setcheckOutList(choice);
        System.out.println("Is there anything else you would like to add to your cart?"+"\n");
        System.out.println("Item added to Cart");
        Co.decreaseStock(choice);
        choice = hardwareOptions();
      }
      else if(choice == 2){
       System.out.println("Here Is Your CheckOut List");
       List = Co.getcheckoutList();
       System.out.println(List);
       Co.getTotalCost();
       Co.writeFile();
       bool = false;
      }
      else{
       System.out.println("Not a Menu Option Try Again");
       choice = hardwareOptions(); 
      }
      
    }//end while loop 
  }
  public int hardwareOptions(){
    System.out.println("0) GPU(Graphics Processing Unit");
    System.out.println("1) CPU (Central Processor Unit");
    System.out.println("2) Checkout");
    String Response = input.nextLine();
    int res = Integer.parseInt(Response);
    return res;
  }
  
}


