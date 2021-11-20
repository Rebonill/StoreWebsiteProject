import java.util.*;
import java.io.*;
import java.util.Scanner;

public class StoreWebsite{
  public ArrayList<Account> accountList = new ArrayList<Account>();
  Scanner input = new Scanner(System.in);
  boolean keepGoing = true;
  boolean bool = true;
  public StoreWebsite(){
   ItemStock IS = new ItemStock();
   System.out.println(IS.getStock());
   IS.addStock();
   System.out.println(IS.getStock());
   IS.writeFile();
   loadAccount();
   //registerAccount();
   System.out.println(accountList.get(1).getfName());
   System.out.println(accountList.get(1).getlName());
   System.out.println(accountList.get(1).getEmail());
   NextPage();
  }//end cunstructor

  public void NextPage(){
   // int response = MainPage();
    while(keepGoing){
      int i = 0;
      int response = MainPage();
      if(response == 1){
          System.out.println("Please Enter Your Email");
          String Email = input.nextLine();         
          while(bool){
            if(Email.equals(accountList.get(i).getEmail())){
              System.out.println("Welcome " + accountList.get(i).getfName());
              bool = false;
            }
            else if(i==1){
              System.out.println("Hi");
              i=0;
              Email = input.nextLine();
            }
            else{
            i++;
            }
          }
           /* else if (i == accountList.size()){
              System.out.println("Not The Correct Email. Please Enter The Correct Email");
              i=0;
              Email = input.nextLine();
          }*/
        
        System.out.println("Sign into account");
        keepGoing = false;
      }//end if statement
      else if(response == 2){
         registerAccount();
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
