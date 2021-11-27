import java.util.*;
import java.io.*;

public class StoreWebsite extends ItemStock implements Website{
  public ArrayList<Account> accountList = new ArrayList<Account>();
  Scanner input = new Scanner(System.in);
  CustomerMenu CM = new CustomerMenu();
  boolean keepGoing = true;
  boolean bool = true;
  public static void main(String[] args){
    new StoreWebsite();   
  }
  public StoreWebsite(){
   //accountList.add(new Account("Admin", "Admin", "Admin@TechShop.com")); 
   loadAccount();
   MainPage();
   //registerAccount();
  }//end cunstructor

  public void MainPage(){
    int i = 0;
    int response = pageChoice();
    while(keepGoing){
      if(response == 1){
          System.out.println("Please Enter Your Email");
          String Email = input.nextLine();         
          while(bool){
            if(Email.equals(accountList.get(i).getEmail())){
              System.out.println("Welcome " + accountList.get(i).getfName());
              bool = false;
              CM.customerMenu();
            }//end if
            else if(i==accountList.size()-1){
              System.out.println("This is an Incorrect Email"+"\n"+"Try Again.");
              i=0;
              Email = input.nextLine();
            }//end else if
            else{
            i++;
            }//end else 
          }//end While Loop   
        System.out.println("Sign into account");
        keepGoing = false;
      }//end if statement
      else if(response == 2){
         registerAccount();
         keepGoing = false;
      }//end if statement 
      else if(response == 3){
        System.out.println("Continue As Guest");
        CM.customerMenu(); 
        keepGoing = false;
      }//end if statement
      else if(response==4){
         System.out.println("Please Enter Your Email");
         String Email = input.nextLine();
         System.out.println();         
           while(bool){
             if(Email.equals("Admin@TechShop.com")){
               System.out.println("Welcome Admin");
               AdminMenu();
               bool = false;
             }//end if statement 
             else{
               System.out.println("This is an Incorrect Email"+"\n"+"Try Again.");
               Email = input.nextLine();
             }//end else statement
           }//End While Loop
             keepGoing = false;
      }//end if statement
      else {
        System.out.println("Not a Menu Option please choose again");
        response = pageChoice();
      } //end else
    }//end while loop 
  }//end MainPage

  public void AdminMenu(){
    int choice = AdminChoice();
    while(bool){
      if(choice == 1){
        for(int i=0; i<accountList.size(); i++){
          
          System.out.println(i+1+"\n"+"First and Last Name");
          System.out.println(accountList.get(i).getfName()+" "+accountList.get(i).getlName());
          System.out.println("Email");
          System.out.println(accountList.get(i).getEmail()+"\n");
          //System.out.println(getitemName(i));
        }//end forloop
        choice = AdminChoice();
      }//end if statement
      else if(choice == 2){
        System.out.println("Please Type The Email Associated With The Account You Want To Delete.");
        String Email = input.nextLine();
        for(int i=0; i<accountList.size(); i++){
          if(Email.equals(accountList.get(i).getEmail())){
            accountList.remove(accountList.get(i));
            System.out.println("Account Removed");
          }
          else{
            System.out.println("Account Does Not Exitst");
          }//end else Statement
        }//end if Statement
        choice = AdminChoice();
      }
      else if(choice == 3){
        itemList();  
        System.out.println("Please Select An Item To Edit");
        EditStock();
        choice = AdminChoice(); 
      }
      else if(choice == 4){
        System.out.println("Thank You And Have A Nice Day!");
        bool = false;
       saveAccount();
      }//end else if
      else{
        System.out.println("Not a Menu Option Please Choose Again");
        choice = AdminChoice();
      }//end else
    }//end while loop
  }//end AdmninMenu
    
  public int AdminChoice(){
    System.out.println("Here Are Your Menu Choices");
    System.out.println("1) Check Customer Account List");
    System.out.println("2) Remove Customer Account");
    System.out.println("3) Edit Stock Items");
    System.out.println("4) Exit");
    String Response = input.nextLine();
    System.out.println();
    int Choice = Integer.parseInt(Response);
    return Choice;  
  }//end AdminChoice
  
  public int pageChoice(){
    System.out.println("Welcome To TechStop \n");
    System.out.println("1) Sign Into Your Account.");
    System.out.println("2) Register For An Acount.");
    System.out.println("3) Conintue As Guest.");
    System.out.println("4) Admin Sign In." +"\n"); 
    String choice = input.nextLine();
    System.out.println();
    int response = Integer.parseInt(choice);
    return response;
  }//end pageChoice

  public void itemList(){
    System.out.println("Here Is The List Of All The Items");
    for(int i=0; i<itemName.length; i++){
      System.out.println(itemName[i]+": "+itemCost[i]);
      System.out.println("Quantity: "+itemQuantity[i]);
      System.out.println();
    } 
  }
   
  public void EditStock(){
    int choice = StockItems();
    while(bool){
      if(choice == 0){
        System.out.println("Enter New Quantiy For "+getitemName(choice));
        itemQuantity[choice] = Integer.parseInt(input.nextLine()); 
        System.out.println("Would You Like To Edit Another Item?"); 
        choice = StockItems();
      }
      
      else if(choice == 1){
        System.out.println("Enter New Quantiy For "+getitemName(choice));
        itemQuantity[choice] = Integer.parseInt(input.nextLine());  
        System.out.println("Would You Like To Edit Another Item?");
        choice = StockItems();   
      }
      else if(choice == 2){
        System.out.println("Updated Stock Information");
        itemList();
        writeFile();
        bool = false;
      }
      else{
        System.out.println("Not a Menu Option Try Again");
        choice = StockItems();
      } 
    }//end while loop 
  }

 public int StockItems(){
   System.out.println("0) GPU(Graphics Processing Unit)");
   System.out.println("1) CPU (Central Processor Unit)");
   System.out.println("2) Exit");
   String Response = input.nextLine();
   int res = Integer.parseInt(Response);
   return res;
 }  
  
  public void registerAccount(){
    System.out.println("Enter Your First Name");
    String fName = input.nextLine();
    System.out.println("Enter Your Last Name");
    String lName = input.nextLine();
    System.out.println("Enter Your Email");
    String Email = input.nextLine();
    accountList.add(new Account(fName, lName, Email));
    saveAccount();
  }//end registeraccount

  public void saveAccount(){
    try{
       FileOutputStream SaveFile = new FileOutputStream("AccountList.dat");
       ObjectOutputStream save = new ObjectOutputStream(SaveFile);
       save.writeObject(accountList);
    }//end try
 
    catch (Exception e){
      System.out.println(e.getMessage());
    }//end catch 

  }//end saveaccount

  @SuppressWarnings("unchecked")  
  public void loadAccount(){
    try{
      FileInputStream LoadFile = new FileInputStream("AccountList.dat");
      ObjectInputStream load = new ObjectInputStream(LoadFile);
      accountList = (ArrayList<Account>)load.readObject();
    }//end try

    catch (Exception e){
      System.out.println(e.getMessage());
    }//end catch
  
  }//end loadUser

}//end StoreWebsite
