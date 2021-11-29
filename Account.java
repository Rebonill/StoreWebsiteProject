import java.io.Serializable;
import java.util.*;
public class Account implements AccountInterface, Serializable{
  String fName;
  String lName;
  String email;
  //public  ArrayList<String> BillingHistory = new ArrayList<String>();
  String BH = "Billing History \n";
  //String password;

  public Account(String fName, String lName, String email){
    this.fName = fName;
    this.lName = lName;
    this.email = email;
  }

  public String getfName(){
    return fName;
  }
  public String getlName(){
    return lName;
  }
  public String getEmail(){
    return email;
  }
  public String getbH(){
    return BH;
  }
  public void billingHistory(String List){
   BH+=List;
  }

}
