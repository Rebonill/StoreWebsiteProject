import java.util.*;
import java.io.*;
import java.util.Scanner;

public class StoreWebsite{
  public ArrayList<Account> accountList = new ArrayList<Account>();
  Scanner input = new Scanner(System.in);

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
  }//end cunstructor
    
  public void MainPage(){
    System.out.println("Welcome To TechStop \n");
    System.out.println("1) Sign Into Your Account.");
    System.out.println("2) Register For An Acount.");
    System.out.println("3) Conintue As Guest.");
    System.out.println("0) Admin Sign In."); 
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
