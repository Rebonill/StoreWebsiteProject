import java.util.*;
import java.io.*;
import java.util.Scanner;

public class StoreWebsite{
  public ArrayList<Account> accountList = new ArrayList<Account>();
  Scanner input = new Scanner(System.in);
  boolean keepGoing = true;
  public StoreWebsite(){
   ItemStock IS = new ItemStock();
   System.out.println(IS.getStock());
   IS.addStock();
   System.out.println(IS.getStock());
   IS.writeFile();
   loadAccount();
   //registerAccount();
   System.out.println(accountList.get(0).getfName());
   System.out.println(accountList.get(0).getlName());
   MainPage();
   NextPage();
  }//end cunstructor

  public void NextPage(){
   // int response = MainPage();
    while(keepGoing){
      int response = MainPage();
      if(response == 1){
        System.out.println("Sign into account");
        keepGoing = false;
      }//end if statement
      else if(response == 2){
        System.out.println("Register For An Account");
         keepGoing = false;
      }//end if statement 
      else if(response == 3){
        System.out.println("Continue As Guest");
         keepGoing = false;
      }//end if statement
      else if(response==0){
        System.out.println("Admin Sign In");
         keepGoing = false;
      }//end if statement
      else{
        System.out.println("Not a Menu Option please choose again");
      } //end else
    }//end while loop 
  }




    
  public int MainPage(){
    System.out.println("Welcome To TechStop \n");
    System.out.println("1) Sign Into Your Account.");
    System.out.println("2) Register For An Acount.");
    System.out.println("3) Conintue As Guest.");
    System.out.println("0) Admin Sign In."); 
    String choice = input.nextLine();
    int response = Integer.parseInt(choice);
    return response;
  }
  
  public void registerAccount(){
    System.out.println("Enter Your First Name");
    String fName = input.nextLine();
    System.out.println("Enter Your Last Name");
    String lName = input.nextLine();
    accountList.add(new Account(fName, lName));
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
