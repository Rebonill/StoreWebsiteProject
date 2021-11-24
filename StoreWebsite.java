import java.util.*;
import java.io.*;

public class StoreWebsite{
  public ArrayList<Account> accountList = new ArrayList<Account>();
  Scanner input = new Scanner(System.in);
  CustomerMenu CM = new CustomerMenu();
  boolean keepGoing = true;
  boolean bool = true;

  public StoreWebsite(){
   //accountList.add(new Account("Admin", "Admin", "Admin@TechShop.com")); 
   loadAccount();
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
             System.out.println("Admin Sign In");
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
    if(choice == 1){
      for(int i=0; i<accountList.size(); i++){
        System.out.println(accountList.get(i).getfName());
      }
    }
    else{
      System.out.println("Not a Menu Option Please Choose Again");
      choice = AdminChoice();
    }
  }//end AdmninMenu

  public int AdminChoice(){
    System.out.println("Here Are Your Menu Choices");
    System.out.println("1) Check Customer Account List");
    System.out.println("2) Remove Customer Account");
    System.out.println("3) Edit Stock Items");
    System.out.println("4) Exit");
    String Response = input.nextLine();
    int Choice = Integer.parseInt(Response);
    return Choice;  
  }



  public int pageChoice(){
    System.out.println("Welcome To TechStop \n");
    System.out.println("1) Sign Into Your Account.");
    System.out.println("2) Register For An Acount.");
    System.out.println("3) Conintue As Guest.");
    System.out.println("4) Admin Sign In."); 
    String choice = input.nextLine();
    int response = Integer.parseInt(choice);
    return response;
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
}//Main
