import java.io.Serializable;
import java.util.*;
public class Account implements AccountInterface, Serializable{
  String fName;
  String lName;
  String email;
  String password;
  public String BH = "Billing History \n";
  int j = 0;
  public Account(String fName, String lName, String email, String password){
    this.fName = fName;
    this.lName = lName;
    this.email = email;
    this.password = password;
  }//end Account

  public String getfName(){
    return fName;
  }//end getlName
  public String getlName(){
    return lName;
  }//end getlName
  public String getEmail(){
    return email;
  }//end getEmail
  public String getPassword(){
    return password;
  }
  public String getbH(){
    return BH;
  }//end getbH
 
  public void billingHistory(String List){
   j+=1;
   BH=BH+"\nPurchase Number: "+j+") \n"+List;
  }//end billingHistory

}//end Account Ckass
