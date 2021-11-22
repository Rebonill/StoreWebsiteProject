import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Main{
  //public ArrayList<Account> accountList = new ArrayList<Account>();
  //Scanner input = new Scanner(System.in);
  public static void main(String[] args){
    new Main();   
  }

  public Main(){
   StoreWebsite SW = new StoreWebsite();
   SW.MainPage();
   /*ItemStock IS = new ItemStock();
   System.out.println(IS.getStock());
   IS.addStock();
   System.out.println(IS.getStock());
   IS.writeFile();
   loadAccount();
   registerAccount();
   System.out.println(accountList.get(0).getfName());*/
  }//end cunstructor
  /*  
  public void MainPage(){
    System.out.println("Welcome To TechStop");
    System.out.println("Would You Like To Sign Into Your Account? Please Press 1");
    System.out.println("Would You Like To Register For Acount? Please Press 2");
    System.out.println("Conintue As Guest. Please Press 3");
    System.out.println("Admin Sign In. Please Press 0"); 
  }






  
  public void registerAccount(){
    System.out.println("Enter New First Name");
    String name = input.nextLine();
    accountList.add(new Account(name));
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
  
  }//end loadUser*/
}//Main
