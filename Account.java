import java.io.Serializable;
import java.util.*;
public class Account implements AccountInterface, Serializable{
  String fName;
  String lName;
  String email;
  public String BH = "Billing History \n";
  int j = 0;
  //String password;
  public Account(String fName, String lName, String email){
    this.fName = fName;
    this.lName = lName;
    this.email = email;
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
  public String getbH(){
    return BH;
  }//end getbH
  public void billingHistory(String List){
   j+=1;
   BH=BH+j+") \n"+List;
  }//end billingHistory

}//end Account Ckass
