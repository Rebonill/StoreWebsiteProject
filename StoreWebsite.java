import java.util.*;
import java.io.*;

public class StoreWebsite extends ItemStock implements Website{
  ArrayList<Account> accountList = new ArrayList<Account>();
  Scanner input = new Scanner(System.in);
  CustomerMenu CM = new CustomerMenu();
  boolean keepGoing = true;
  boolean bool = true;
  String StockMessage="No Updates As Of Right Now";
  public static void main(String[] args){
    new StoreWebsite();   
  }
  public StoreWebsite(){
   loadAccount();
   MainPage();
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
            CM.list = accountList.get(i).getbH();;
            CM.customerMenu();
            if(CM.List.equals("")){
              break; 
            }
	    else{
              accountList.get(i).billingHistory(CM.List); 
              saveAccount();
            }
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
    StockReadFile();
    while(bool){

      if(choice == 1){
        for(int i=0; i<accountList.size(); i++){
          System.out.println(i+1+"\n"+"First and Last Name");
          System.out.println(accountList.get(i).getfName()+" "+accountList.get(i).getlName());
          System.out.println("Email");
          System.out.println(accountList.get(i).getEmail()+"\n");
        }//end forloop
      choice = AdminChoice();
      }//end if statement

      else if(choice == 2){
        System.out.println("Please Type The Email Associated With The Account You Want To Delete.");
        String Email = input.nextLine();
        boolean bool = true;

        for(int i=0; i<accountList.size(); i++){
          if(Email.equals(accountList.get(i).getEmail())){
            accountList.remove(accountList.get(i));
            System.out.println("Account Removed");
            choice = AdminChoice();
            bool = false;
          }//end if statement
        }//end forloop
     
        if(bool == true){
          System.out.println("Account Does Not Exitst");
        }//end if Statement*/
      }//end else if Statement
      
      else if(choice == 3){
        itemList();  
        System.out.println("Please Select An Item To Edit");
        EditStock();
        CM.stockWrite("No Update As of Right Now");
        choice = AdminChoice(); 
      }//end else if statement

      else if (choice ==4){
        StockReadFile();
        System.out.println(StockMessage); 
        choice=AdminChoice(); 
      }

      else if(choice == 5){
        System.out.println("Thank You And Have A Nice Day!");
        bool = false;
        //CM.stockWrite("No Update As of Right Now");
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
    System.out.println("4) Stock Update Message");
    System.out.println("5) Exit");
    try{
      String Response = input.nextLine();
      System.out.println();
      int Choice = Integer.parseInt(Response);
      return Choice; 
    }catch (NumberFormatException e){
       System.out.println("Please Enter A Number");
    }catch (Exception e){
       System.out.println(e.getMessage());
    } // end try 
    return 0;
  }//end AdminChoice
  
  public int pageChoice(){
    System.out.println();
    System.out.println("Welcome To TechStop \n");
    System.out.println("1) Sign Into Your Account.");
    System.out.println("2) Register For An Acount.");
    System.out.println("3) Conintue As Guest.");
    System.out.println("4) Admin Sign In." +"\n");
    try{ 
      String choice = input.nextLine();
      System.out.println();
      int response = Integer.parseInt(choice);
      return response;
    }catch (NumberFormatException e){
       System.out.println("Please Enter A Number");
    }catch (Exception e){
       System.out.println(e.getMessage());
    } // end try 
    return 0;
  }//end pageChoice

  public void itemList(){
    System.out.println("Here Is The List Of All The Items");
    for(int i=0; i<itemName.length; i++){
      System.out.println(itemName[i]+": "+itemCost[i]);
      System.out.println("Quantity: "+itemQuantity[i]);
      System.out.println();
    }//end for loop 
  }//end itemList
   
  public void EditStock(){
    boolean KG = true;
    int choice = StockItems();
    while(KG){
      if(choice == 0){
        System.out.println("Enter New Quantiy For "+getitemName(choice));
        itemQuantity[choice] = Integer.parseInt(input.nextLine()); 
        System.out.println("Would You Like To Edit Another Item?"); 
        choice = StockItems();
      }//end if statement
      
      else if(choice == 1){
        System.out.println("Enter New Quantiy For "+getitemName(choice));
        itemQuantity[choice] = Integer.parseInt(input.nextLine());  
        System.out.println("Would You Like To Edit Another Item?");
        choice = StockItems();   
      }//end else if
      else if(choice == 2){
        System.out.println("Updated Stock Information");
        itemList();
        writeFile();
        KG = false;
      }//end else if
      else{
        System.out.println("Not a Menu Option Try Again");
        choice = StockItems();
      }//end else 
    }//end while loop 
  }//end editstock

 public int StockItems(){
   System.out.println("0) GPU(Graphics Processing Unit)");
   System.out.println("1) CPU (Central Processor Unit)");
   System.out.println("2) Exit");
   String Response = input.nextLine();
   int res = Integer.parseInt(Response);
   return res;
 }//end StockItems  
  
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
  
  public void StockReadFile(){
    try {
      File item = new File("StockUpdate.dat");
      Scanner input = new Scanner(item);
      StockMessage = input.nextLine();
    }//end try
     catch(IOException e){
         System.out.println(e.getMessage());
     } //end catch
   }//end readFile
}//end StoreWebsite
